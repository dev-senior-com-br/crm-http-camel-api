package br.com.senior.crm.http.camel.services.validateSettings;

import br.com.senior.crm.http.camel.dtos.AccountTypeDTO;
import br.com.senior.crm.http.camel.entities.account.AccountDefinition;
import br.com.senior.crm.http.camel.entities.account.collections.AccountDefinitionCollection;
import br.com.senior.crm.http.camel.services.impl.CrmHTTPRouteBuilder;
import br.com.senior.crm.http.camel.utils.constants.AccountParamsConstant;
import br.com.senior.crm.http.camel.utils.constants.HeadersConstants;
import br.com.senior.crm.http.camel.utils.constants.ValidateSettingsPropertyConstant;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveComplementEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.crm.http.camel.utils.enums.ValidateSettingsDirectEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.authentication.AuthenticationAPI;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class CrmNovasoftAccount implements ValidateSettingsInterface {

    @NonNull
    private RouteBuilder builder;
    private final String id = UUID.randomUUID().toString();

    @Getter
    private final String directResponse = "direct:crm-filter-fields-response-crm-novasoft-account-".concat(id);

    private static final String MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_PT_BR = "O tipo de conta %s não é aceito para integração. Altere para o tipo de conta %s.";
    private static final String MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_ES_CO = "El tipo de cuenta %s no es acepto para integración. Cambie para el tipo de cuenta %s.";

    public void prepare()
    {
        prepareAccountDefinition();
    }

    private void prepareAccountDefinition() {
        CrmHTTPRouteBuilder getAccountType = new CrmHTTPRouteBuilder(
            builder,
            ServiceEnum.BASE_RECORDS,
            PrimitiveType.ENTITY,
            PrimitiveEnum.ACCOUNT_TYPE,
            br.com.senior.crm.http.camel.utils.enums.MethodEnum.GET
        );

        builder
            .from(ValidateSettingsDirectEnum.DIRECT_NOVASOFT_ACCOUNT_DEFINITION.getValue())
            .routeId("Filter Account Definition")
            .process(exchange -> exchange.setProperty(AccountDefinitionCollection.class.toString(), exchange.getMessage().getBody()))
            .process(AuthenticationAPI::addAuthorization)
            .process(exchange -> exchange.getMessage().setBody(null))
            .process(exchange -> getAccountType.setPrimitiveComplement(exchange.getProperty(AccountParamsConstant.TYPE_ACCOUNT, "0", String.class), PrimitiveComplementEnum.PARAMETER))
            .process(getAccountType::route)
            .unmarshal(AccountTypeDTO.JACKSON_DATA_FORMAT)
            .process(exchange -> exchange.setProperty(AccountTypeDTO.class.toString(), exchange.getMessage().getBody(AccountTypeDTO.class)))
            .process(exchange -> exchange.setProperty(ValidateSettingsPropertyConstant.IS_VALID, filterAccountDefinition(exchange)))
            .to(directResponse)
        ;
    }
    private Boolean filterAccountDefinition(Exchange exchange) {
        AccountDefinitionCollection collection = exchange.getProperty(AccountDefinitionCollection.class.toString(), null, AccountDefinitionCollection.class);//
        Long typeAccount = exchange.getProperty(AccountParamsConstant.TYPE_ACCOUNT, "0", Long.class);//
        Boolean isValid = false;//

        for (AccountDefinition accountDefinition : collection.definitions) {//
            if (isValid.equals(Boolean.FALSE)) {//

                isValid = accountDefinition.getAccountType().getId().equals(typeAccount);//
                String integrationName = (String) exchange.getMessage().getHeader(HeadersConstants.INTEGRATION);
                AccountTypeDTO accountTypeDTO = exchange.getProperty(AccountTypeDTO.class.toString(), null, AccountTypeDTO.class);

                if (integrationName.contains("novasoft")) {//
                    exchange.setProperty(//
                        ValidateSettingsPropertyConstant.MESSAGE,//
                        String.format(//
                            MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_ES_CO,//
                            accountDefinition.getAccountType().getName(),//
                            accountTypeDTO.getName()//
                        )//
                    );//
                } else {//
                    exchange.setProperty(//
                        ValidateSettingsPropertyConstant.MESSAGE,//
                        String.format(//
                            MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_PT_BR,//
                            accountDefinition.getAccountType().getName(),//
                            accountTypeDTO.getName()//
                        )//
                    );//
                }//

                log.info(//
                    "Comparative between account type: Definition {} with type account {} and parameter type account {}",//
                    accountDefinition.getId(),//
                    accountDefinition.getAccountType().getId(),//
                    typeAccount//
                );//
            }//
        }//

        return isValid;//
    }
}
