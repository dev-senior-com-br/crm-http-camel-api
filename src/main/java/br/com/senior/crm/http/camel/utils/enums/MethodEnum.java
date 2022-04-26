package br.com.senior.crm.http.camel.utils.enums;

public enum MethodEnum {

    POST("post"),
    PUT("put"),
    GET("get"),
    DELETE("delete");

    private String path;

    public String getPath() {
        return path;
    }

    MethodEnum(String path) {
        this.path = path;
    }
}
