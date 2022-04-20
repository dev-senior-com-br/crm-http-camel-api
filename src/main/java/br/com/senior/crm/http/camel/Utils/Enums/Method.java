package br.com.senior.crm.http.camel.Utils.Enums;

public enum Method {

    POST("post"),
    PUT("put"),
    GET("get"),
    DELETE("delete");

    public String path;

    Method(String path) {
        this.path = path;
    }
}
