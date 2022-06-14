package br.com.senior.crm.http.camel.utils.enums;

import lombok.Getter;

public enum ServiceEnum
{
    ACCOUNT("account"),
    OPPORTUNITY("opportunity"),
    BASE_RECORDS("basic_records"),
    CRM_INTEGRATION_MANAGEMENT("crm_integration_management");

    @Getter
    private String path;

    ServiceEnum(String path) {
        this.path = path;
    }
}
