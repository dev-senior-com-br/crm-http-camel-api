package br.com.senior.crm.http.camel.services.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import java.util.Base64;
import java.util.List;

public class PrepareParameters
{
    private static final String HEADER_PARAMS = "X-Param-";

    public static void prepare(Exchange exchange, List<String> params)
    {
        Message message = exchange.getMessage();

        params.forEach(param -> {
            String paramComplete = HEADER_PARAMS + param;
            if (message.getHeader(paramComplete) != null) {
                exchange.setProperty(param, decode(message.getHeader(paramComplete).toString()));
            }
        });
    }

    private static String decode(String valueEncoded)
    {
        byte[] valueDecoded = Base64.getDecoder().decode(valueEncoded);
        return new String(valueDecoded);
    }
}
