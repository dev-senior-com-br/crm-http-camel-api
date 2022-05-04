package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.SeniorXHTTPRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

public class CrmHTTPRouteBuilder extends SeniorXHTTPRouteBuilder {

    public static final String DOMAIN_CRM = "crm";

    public CrmHTTPRouteBuilder(RouteBuilder builder, ServiceEnum service, PrimitiveType primitiveType, PrimitiveEnum primitive, MethodEnum method, String id)
    {
        super(builder);

        this.setInfo(
            service.getPath(),
            primitiveType,
            primitive.getPath().concat("/").concat(id),
            method.getPath()
        );
    }

    public CrmHTTPRouteBuilder(RouteBuilder builder, ServiceEnum service, PrimitiveType primitiveType, PrimitiveEnum primitive, MethodEnum method)
    {
        super(builder);

        this.setInfo(
            service.getPath(),
            primitiveType,
            primitive.getPath(),
            method.getPath()
        );
    }

    private void setInfo(String service, PrimitiveType primitiveType, String primitive, String method)
    {
        this
            .domain(DOMAIN_CRM)
            .service(service)
            .primitiveType(primitiveType)
            .primitive(primitive)
            .method(method)
        ;
    }
}
