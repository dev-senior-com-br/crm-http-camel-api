package br.com.senior.crm.http.camel.services;

import br.com.senior.crm.http.camel.utils.enums.Method;
import br.com.senior.crm.http.camel.utils.enums.Primitive;
import br.com.senior.crm.http.camel.utils.enums.Service;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.SeniorXHTTPRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

public class CrmHTTPRouteBuilder extends SeniorXHTTPRouteBuilder {

    public static String DOMAIN = "crm";

    public CrmHTTPRouteBuilder(RouteBuilder builder, Service service, PrimitiveType primitiveType, Primitive primitive, Method method)
    {
        super(builder);

        this
            .domain(DOMAIN)
            .service(service.getPath())
            .primitiveType(primitiveType)
            .primitive(primitive.getPath())
            .method(method.getPath())
        ;
    }
}
