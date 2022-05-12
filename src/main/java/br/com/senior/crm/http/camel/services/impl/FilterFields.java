package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.account.Account;
import br.com.senior.crm.http.camel.entities.account.AccountDefinition;
import br.com.senior.crm.http.camel.utils.constants.AccountParamsConstant;
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
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-filter-fields-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-filter-fields-response-" + id.toString();

    private static String DIRECT_END_REST = "direct:crm-filter-fields-end-rest";

    public void prepare()
    {
        builder
            .from(directImpl)
            .choice()
            .when(this::filter)
                .to(directResponse)
            .otherwise()
                .to(DIRECT_END_REST)
            .endChoice()
        ;

        builder.
            from(DIRECT_END_REST)
            .log("Não passou no filtro")
            .endRest()
        ;
    }

    private boolean filter(Exchange exchange)
    {
        System.out.println("Step 1");
        boolean isValid = false;

        System.out.println(exchange.getMessage().getBody() instanceof AccountDefinition);
        if (exchange.getMessage().getBody() instanceof AccountDefinition) {
            isValid = this.filterAccountDefinition(exchange.getMessage().getBody(AccountDefinition.class), exchange.getProperty(AccountParamsConstant.TYPE_ACCOUNT, Long.class));
        }
        System.out.println(isValid);

        return isValid;
    }

    private boolean filterAccountDefinition(AccountDefinition accountDefinition, Long typeAccount)
    {
        boolean isValid = false;

        isValid = accountDefinition.getAccountType().getId().equals(typeAccount);

        if (isValid == false) {
            System.out.println("O tipo de conta é " + accountDefinition.getAccountType().getId() + " e somente o tipo de conta " + typeAccount + " pode ser integrado!");
        }

        return isValid;
    }
}
