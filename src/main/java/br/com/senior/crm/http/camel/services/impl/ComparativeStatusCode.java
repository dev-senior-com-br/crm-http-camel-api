package br.com.senior.crm.http.camel.services.impl;

import org.apache.camel.Exchange;

public class ComparativeStatusCode
{

    public static boolean isOk(Exchange exchange)
    {
        return equalStatusCode(exchange, 200) || equalStatusCode(exchange, 201);
    }

    public static boolean notOk(Exchange exchange)
    {
        return notEqualStatusCode(exchange, 200) && notEqualStatusCode(exchange, 201);
    }

    public static boolean isInternationalServerError(Exchange exchange)
    {
        return equalStatusCode(exchange, 500);
    }

    public static boolean isNotFound(Exchange exchange)
    {
        return equalStatusCode(exchange, 404);
    }

    public static boolean isUnauthorized(Exchange exchange)
    {
        return equalStatusCode(exchange, 401);
    }

    private static boolean equalStatusCode(Exchange exchange, Integer statusCode)
    {
        return exchange.getMessage().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class).equals(statusCode);
    }

    private static boolean notEqualStatusCode(Exchange exchange, Integer statusCode)
    {
        return !exchange.getMessage().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class).equals(statusCode);
    }
}
