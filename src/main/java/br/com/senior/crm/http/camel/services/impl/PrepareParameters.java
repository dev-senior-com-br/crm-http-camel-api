package br.com.senior.crm.http.camel.services.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private static Object decode(String valueEncoded)
    {
        byte[] valueDecoded = Base64.getDecoder().decode(valueEncoded);
        String value = new String(valueDecoded);

        if (isJsonObject(value)) {
            return new JSONObject(value);
        }

        if (isJsonArray(value)) {
            return new JSONArray(value);
        }

        return value;
    }

    private static boolean isJsonObject(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException ex) {
            return false;
        }
        return true;
    }

    private static boolean isJsonArray(String json)
    {
        try {
            new JSONArray(json);
        } catch (JSONException ex1) {
            return false;
        }

        return true;
    }
}
