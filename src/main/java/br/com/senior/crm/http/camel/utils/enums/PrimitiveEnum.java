package br.com.senior.crm.http.camel.utils.enums;

import lombok.Getter;

public enum PrimitiveEnum
{
    // Account
    ACCOUNT("account"),
    ACCOUNT_DEFINITION("accountDefinition"),
    ACCOUNT_PHONE("accountPhone"),
    ACCOUNT_ADDRESS("accountAddress"),
    GET_ACCOUNT_DEFINITION("getDefinitionByAccount"),
    GET_ACCOUNT_PHONE("getPhoneByAccount"),
    GET_ACCOUNT_ADDRESS("getAddressByAccount")
    // Opportunity

    // Base Records

    ;

    @Getter
    private String path;

    PrimitiveEnum(String path) {
        this.path = path;
    }
}
