package br.com.senior.crm.http.camel.Utils.Enums;

public enum EntitiesAccount
{
    ACCOUNT("account"),
    ACCOUNT_DEFINITION("accountDefinition"),
    ACCOUNT_PHONE("accountPhone"),
    ACCOUNT_ADDRESS("accountAddress")
    ;

    final String path;

    EntitiesAccount(String path) {
        this.path = path;
    }
}
