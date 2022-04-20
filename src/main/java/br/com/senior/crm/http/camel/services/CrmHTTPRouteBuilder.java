package br.com.senior.crm.http.camel.services;

import br.com.senior.crm.http.camel.Utils.Enums.Method;
import br.com.senior.crm.http.camel.Utils.Enums.Primitive;
import br.com.senior.crm.http.camel.Utils.Enums.Service;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.SeniorXHTTPRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

public class CrmHTTPRouteBuilder extends SeniorXHTTPRouteBuilder {

    private static String domain = "crm";

    public CrmHTTPRouteBuilder(RouteBuilder builder, Service service, PrimitiveType primitiveType, Primitive primitive, Method method)
    {
        super(builder);

        this
            .domain(domain)
            .service(service.path)
            .primitiveType(primitiveType)
            .primitive(primitive.path)
            .method(method.path)
        ;
    }
}
