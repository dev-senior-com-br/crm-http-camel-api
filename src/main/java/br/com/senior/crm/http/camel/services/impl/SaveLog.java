package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.entities.integrationManagement.LogIntegration;
import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@RequiredArgsConstructor
public class SaveLog {
    @NonNull
    private RouteBuilder builder;
    private final UUID id = UUID.randomUUID();
    @Getter
    private final String directImpl = "direct:crm-save-log-" + id.toString();
    @Getter
    private final String directResponse = "direct:crm-save-log-response-" + id.toString();

    void prepare()
    {
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
            .when(this::isBodyLogIntegration)
            .marshal(LogIntegration.JACKSON_DATA_FORMAT)
            .process(logIntegration::route)
            .end()
            .to(directResponse)
        ;
    }

    private boolean isBodyLogIntegration(Exchange exchange)
    {
        Message message = exchange.getMessage();

        return message.getBody() instanceof LogIntegration;
    }
}
