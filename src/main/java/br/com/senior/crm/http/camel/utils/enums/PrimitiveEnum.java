package br.com.senior.crm.http.camel.utils.enums;

import lombok.Getter;

public enum PrimitiveEnum {
    // Account
    ACCOUNT("account"),
    ACCOUNT_DEFINITION("accountDefinition"),
    ACCOUNT_PHONE("accountPhone"),
    ACCOUNT_ADDRESS("accountAddress"),
    ACCOUNT_HISTORY_INTEGRATION("accountHistoryIntegration"),
    GET_ACCOUNT_DEFINITION("getDefinitionByAccount"),
    GET_ACCOUNT_PHONE("getPhoneByAccount"),
    GET_ACCOUNT_ADDRESS("getAddressByAccount"),
    GET_ACCOUNT_HISTORY_INTEGRATION("getHistoryIntegrationByAccount"),

    // Opportunity

    // Basic Records
    ACCOUNT_TYPE("accountType"),

    // Integration Management
    LIST_LOG_BY_INTEGRATION("listLogByIntegration"),
    LOG_INTEGRATION("logIntegration");

    @Getter
    private String path;

    PrimitiveEnum(String path) {
        this.path = path;
    }
}
