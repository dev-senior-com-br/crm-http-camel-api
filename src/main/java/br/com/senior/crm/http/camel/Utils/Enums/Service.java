package br.com.senior.crm.http.camel.Utils.Enums;

public enum Service
{
    ACCOUNT("account"),
    OPPORTUNITY("opportunity"),
    BASE_RECORDS("basic_records");

    public String path;

    Service(String path) {
        this.path = path;
    }
}
