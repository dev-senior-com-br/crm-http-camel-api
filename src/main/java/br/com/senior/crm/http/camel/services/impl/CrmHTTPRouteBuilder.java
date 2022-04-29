package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.SeniorXHTTPRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

public class CrmHTTPRouteBuilder extends SeniorXHTTPRouteBuilder {

    public static final String DOMAIN_CRM = "crm";

    public CrmHTTPRouteBuilder(RouteBuilder builder, ServiceEnum service, PrimitiveType primitiveType, PrimitiveEnum primitive, MethodEnum method)
    {
        super(builder);

        this
            .domain(DOMAIN_CRM)
            .service(service.getPath())
            .primitiveType(primitiveType)
            .primitive(primitive.getPath())
            .method(method.getPath())
        ;
    }
}
