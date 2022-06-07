package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.integrationManagement.LogIntegration;
import br.com.senior.crm.http.camel.utils.constants.HeadersConstants;
import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@RequiredArgsConstructor
public class SaveLog {

    public static String PAYLOAD_SENT = "payloadSent";
    public static String PAYLOAD_RECEIVER = "payloadReceiver";
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-save-log-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-save-log-response-" + id.toString();

    void prepare() {
        CrmHTTPRouteBuilder logIntegration = new CrmHTTPRouteBuilder(
            builder,
            ServiceEnum.CRM_INTEGRATION_MANAGEMENT,
            PrimitiveType.ENTITY,
            PrimitiveEnum.LOG_INTEGRATION,
            MethodEnum.POST
        );

        builder
            .from(directImpl)
            .choice()
            .process(this::prepareLogIntegration)
            .marshal(LogIntegration.JACKSON_DATA_FORMAT)
            .process(logIntegration::route)
            .log("Return POST logIntegration: ${body}")
            .process(exchange -> exchange.getMessage().setBody(exchange.getProperty(PAYLOAD_RECEIVER)))
            .to(directResponse)
        ;
    }

    private void prepareLogIntegration(Exchange exchange)
    {
        String integration = exchange.getMessage().getHeader(HeadersConstants.INTEGRATION, String.class);
        String payloadSent = exchange.getProperty(PAYLOAD_SENT, String.class);
        String payloadReceived = exchange.getProperty(PAYLOAD_RECEIVER, String.class);
        Long statusCode = exchange.getMessage().getHeader(Exchange.HTTP_RESPONSE_CODE, Long.class);

        LogIntegration log = new LogIntegration();
        log.setIntegration(integration);
        log.setPayloadSent(payloadSent);
        log.setPayloadReceived(payloadReceived);
        log.setStatusCode(statusCode);

        exchange.getMessage().setBody(log);
    }
}
