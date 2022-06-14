package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.integrationManagement.LogIntegration;
import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class Request {
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-save-log-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-save-log-response-" + id.toString();
    @Setter
    private final CrmHTTPRouteBuilder crmHTTPRouteBuilder;

    void prepare() {
        builder
            .from(directImpl)
            .process(crmHTTPRouteBuilder::route)
            .choice()
            .when(ComparativeStatusCode::isOk)
            .to(directResponse)
            .otherwise()
            .process(exchange -> log.info("Error " + exchange.getMessage().getHeader(Exchange.HTTP_RESPONSE_CODE) + " when to make a request to route " + exchange.getMessage().getHeader(Exchange.HTTP_URL)))
            .endRest()
        ;
    }

}
