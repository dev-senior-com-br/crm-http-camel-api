package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.account.Account;
import br.com.senior.crm.http.camel.entities.account.AccountAddress;
import br.com.senior.crm.http.camel.entities.account.AccountPhone;
import br.com.senior.crm.http.camel.utils.constants.AccountParamsConstant;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONArray;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiredArgsConstructor
public class ValidateRequiredFields
{
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-validate-required-fields-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-validate-required-fields-response-" + id.toString();

    public void prepare()
    {
        builder
            .from(directImpl)
            .choice()
            .when(this::validate)
            .to(directResponse)
            .otherwise()
            .endRest()
        ;
    }

    private boolean validate(Exchange exchange)
    {
        Message message = exchange.getMessage();
        Map<Object, Object> body = (Map<Object, Object>) message.getBody();
        Class<?> nameClass = message.getBody().getClass();
        JSONArray fields = new JSONArray();
        AtomicBoolean rtn = new AtomicBoolean(true);

        if (Account.class.equals(nameClass)) {
            fields = (JSONArray) exchange.getProperty(AccountParamsConstant.FIELDS_ACCOUNT);
        } else if (AccountAddress.class.equals(nameClass)) {
            fields = (JSONArray) exchange.getProperty(AccountParamsConstant.FIELDS_ADDRESS);
        } else if (AccountPhone.class.equals(nameClass)) {
            fields = (JSONArray) exchange.getProperty(AccountParamsConstant.FIELDS_PHONE);
        }

        fields.forEach(o -> {
            if (body.get(o) == null || body.get(o).toString().length() == 0) {
                System.err.println(nameClass);
                System.err.println(o);
                rtn.set(false);
            }
        });

        return rtn.get();
    }
}
