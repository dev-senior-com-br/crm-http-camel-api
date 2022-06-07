package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.utils.enums.MethodEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveComplementEnum;
import br.com.senior.crm.http.camel.utils.enums.PrimitiveEnum;
import br.com.senior.crm.http.camel.utils.enums.ServiceEnum;
import br.com.senior.seniorx.http.camel.PrimitiveType;
import br.com.senior.seniorx.http.camel.SeniorXHTTPRouteBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class CrmHTTPRouteBuilder extends SeniorXHTTPRouteBuilder {

    public static final String DOMAIN_CRM = "crm";
    private String primitiveCrm = "";

    public CrmHTTPRouteBuilder(RouteBuilder builder, ServiceEnum service, PrimitiveType primitiveType, PrimitiveEnum primitive, MethodEnum method, PrimitiveComplementEnum primitiveComplementEnum, String primitiveComplement) {
        super(builder);

        this.setInfo(
            service.getPath(),
            primitiveType,
            primitive.getPath(),
            method.getPath()
        );
        this.setPrimitiveComplement(primitiveComplement, primitiveComplementEnum);

        this.throwExceptionOnFailure(false);
    }

    public CrmHTTPRouteBuilder(RouteBuilder builder, ServiceEnum service, PrimitiveType primitiveType, PrimitiveEnum primitive, MethodEnum method) {
        super(builder);

        this.setInfo(
            service.getPath(),
            primitiveType,
            primitive.getPath(),
            method.getPath()
        );

        this.throwExceptionOnFailure(false);
    }

    private void setInfo(String service, PrimitiveType primitiveType, String primitive, String method) {
        this.primitiveCrm = primitive;
        this
            .domain(DOMAIN_CRM)
            .service(service)
            .primitiveType(primitiveType)
            .primitive(primitive)
            .method(method)
        ;
    }

    public void setPrimitiveComplement(String primitiveComplement, PrimitiveComplementEnum primitiveComplementEnum) {
        this.primitive = this.primitiveCrm;
        this.primitive += primitiveComplementEnum.getPath() + primitiveComplement;
    }
}
