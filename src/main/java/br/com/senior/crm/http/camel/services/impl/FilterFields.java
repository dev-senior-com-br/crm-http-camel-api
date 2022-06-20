package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.account.AccountDefinition;
import br.com.senior.crm.http.camel.entities.account.AccountDefinitionCollection;
import br.com.senior.crm.http.camel.utils.constants.AccountParamsConstant;
import br.com.senior.crm.http.camel.utils.constants.HeadersConstants;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class FilterFields {
    @NonNull
    private RouteBuilder builder;
    private final String id = UUID.randomUUID().toString();
    @Getter
    private final String directImpl = "direct:crm-filter-fields-".concat(id);
    @Getter
    private final String directResponse = "direct:crm-filter-fields-response-".concat(id);

    private static final String MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_PT_BR = "O tipo de conta %s não pode ser integrado.";
    private static final String MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_ES_CO = "El tipo de cuenta %s no se puede fusionar.";

    public static final String PROPERTY_IS_VALID = "property:filter-fields-is-valid";

    public static final String PROPERTY_MESSAGE = "property:filter-fields-message";


    public void prepare() {
        builder
            .from(directImpl)
            .process(exchange -> exchange.setProperty(PROPERTY_IS_VALID, filter(exchange)))
            .to(directResponse)
        ;
    }

    private Boolean filter(Exchange exchange) {//
        return exchange.getMessage().getBody() instanceof AccountDefinitionCollection//
            ? this.filterAccountDefinition(exchange)//
            : Boolean.FALSE;//
    }

    private Boolean filterAccountDefinition(Exchange exchange) {
        AccountDefinitionCollection collection = exchange.getMessage().getBody(AccountDefinitionCollection.class);//
        Long typeAccount = exchange.getProperty(AccountParamsConstant.TYPE_ACCOUNT, Long.class);//
        Boolean isValid = false;//

        for (AccountDefinition accountDefinition : collection.definitions) {//
            if (isValid.equals(Boolean.FALSE)) {//
                isValid = accountDefinition.getAccountType().getId().equals(typeAccount);//
                String integrationName = (String) exchange.getMessage().getHeader(HeadersConstants.INTEGRATION);

                if (integrationName.contains("novasoft")) {
                    exchange.setProperty(
                        PROPERTY_MESSAGE,
                        String.format(MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_ES_CO, accountDefinition.getAccountType().getName())
                    );
                } else {
                    exchange.setProperty(
                        PROPERTY_MESSAGE,
                        String.format(MESSAGE_ACCOUNT_CANNOT_BE_INTEGRATED_PT_BR, accountDefinition.getAccountType().getName())
                    );
                }

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