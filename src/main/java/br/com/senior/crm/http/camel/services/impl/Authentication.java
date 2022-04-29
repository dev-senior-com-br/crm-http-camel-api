package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.services.exception.AuthenticationException;
import br.com.senior.crm.http.camel.utils.constants.HeadersConstants;
import br.com.senior.seniorx.http.camel.authentication.AuthenticationAPI;
import br.com.senior.seniorx.http.camel.authentication.LoginWithKeyInput;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;

import java.util.Base64;
import java.util.UUID;

@RequiredArgsConstructor
public class Authentication
{
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-authentication-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-authentication-response-" + id.toString();

    public void prepare()
    {
        AuthenticationAPI authenticationAPI = new AuthenticationAPI(builder);
        authenticationAPI.prepare();

        builder
            .from(directImpl)
            .routeId("Authentication SeniorX (CRM)")
            .process(this::searchAuthorization)
            .process(this::prepareAuthorization)
            .to(authenticationAPI.route())
        ;

        builder
            .from(authenticationAPI.responseRoute())
            .to(directResponse)
        ;
    }

    public void searchAuthorization(Exchange exchange)
    {
        Message message = exchange.getMessage();
        String authorization = message.getHeader(HeadersConstants.AUTHORIZATION, String.class);

        if (authorization == null) {
            throw new AuthenticationException("Basic Auth not found!");
        }
    }

    private void prepareAuthorization(Exchange exchange)
    {
        Message message = exchange.getMessage();

        String authorizationEncode = message.getHeader(HeadersConstants.AUTHORIZATION, String.class).replace("Basic", "").trim();
        String authorizationDecode = decode(authorizationEncode);
        String[] authorization = authorizationDecode.split(":");

        LoginWithKeyInput loginWithKeyInput = new LoginWithKeyInput();
        loginWithKeyInput.accessKey = authorization[0];
        loginWithKeyInput.secret = authorization[1];
        loginWithKeyInput.tenantName = message.getHeader(HeadersConstants.TENANT, String.class);

        message.setBody(loginWithKeyInput);
    }

    private static String decode(String valueEncoded)
    {
        byte[] valueDecoded = Base64.getDecoder().decode(valueEncoded);
        return new String(valueDecoded);
    }
}
