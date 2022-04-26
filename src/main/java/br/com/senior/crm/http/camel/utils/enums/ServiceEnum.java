package br.com.senior.crm.http.camel.utils.enums;

public enum ServiceEnum
{
    ACCOUNT("account"),
    OPPORTUNITY("opportunity"),
    BASE_RECORDS("basic_records");

    private String path;

    public String getPath() {
        return path;
    }

    ServiceEnum(String path) {
        this.path = path;
    }
}
