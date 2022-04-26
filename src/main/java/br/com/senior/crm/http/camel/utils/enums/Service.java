package br.com.senior.crm.http.camel.utils.enums;

public enum Service
{
    ACCOUNT("account"),
    OPPORTUNITY("opportunity"),
    BASE_RECORDS("basic_records");

    private String path;

    public String getPath() {
        return path;
    }

    Service(String path) {
        this.path = path;
    }
}
