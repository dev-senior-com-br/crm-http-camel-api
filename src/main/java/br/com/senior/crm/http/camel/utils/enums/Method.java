package br.com.senior.crm.http.camel.utils.enums;

public enum Method {

    POST("post"),
    PUT("put"),
    GET("get"),
    DELETE("delete");

    private String path;

    public String getPath() {
        return path;
    }

    Method(String path) {
        this.path = path;
    }
}
