package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.account.*;
import br.com.senior.crm.http.camel.utils.constants.AccountParamsConstant;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONArray;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class ValidateRequiredFields {
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-validate-required-fields-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-validate-required-fields-response-" + id.toString();

    public void prepare() {
        builder
            .from(directImpl)
            .choice()
            .when(this::isAccount)
            .process(this::validateAccount)
            .when(this::isAddress)
            .process(this::validateAddress)
            .when(this::isPhone)
            .process(this::validatePhone)
            .endChoice()
            .to(directResponse)
        ;
    }

    private boolean isAccount(Object body) {
        return body instanceof Account;
    }
    private boolean isAddress(Object body) {
        return body instanceof AccountAddressCollection;
    }
    private boolean isPhone(Object body) {
        return body instanceof AccountPhoneCollection;
    }

    private void validateAccount(Exchange exchange) {
        Map<Account, Account> account = (Map<Account, Account>) this.getBody(exchange, Account.class);

        exchange.getProperty(AccountParamsConstant.FIELDS_ACCOUNT, JSONArray.class).forEach(o -> {
            if (account.get(o).toString().length() == 0) {
                throw new RuntimeException("O campo " + o + " da conta é obrigatório");
            }
        });
    }

    private void validateAddress(Exchange exchange) {
//        Map<AccountAddress, AccountAddress> accountAddress = (Map<AccountAddress, AccountAddress>) this.getBody(exchange, AccountAddressCollection.class);
//
//        exchange.getProperty(AccountParamsConstant.FIELDS_ADDRESS, JSONArray.class).forEach(o -> {
//            if (accountAddress.get(o).toString().length() == 0) {
//                throw new RuntimeException("O campo " + o + " da conta é obrigatório");
//            }
//        });
    }

    private void validatePhone(Exchange exchange) {
//        Map<AccountPhone, AccountPhone> account = (Map<AccountPhone, AccountPhone>) this.getBody(exchange, AccountPhoneCollection.class);
//
//        exchange.getProperty(AccountParamsConstant.FIELDS_PHONE, JSONArray.class).forEach(o -> {
//            if (account.get(o).toString().length() == 0) {
//                throw new RuntimeException("O campo " + o + " da conta é obrigatório");
//            }
//        });
    }
    private  <T> T getBody(Exchange exchange, Class<T> type) {
        return exchange.getMessage().getBody(type);
    }
}
