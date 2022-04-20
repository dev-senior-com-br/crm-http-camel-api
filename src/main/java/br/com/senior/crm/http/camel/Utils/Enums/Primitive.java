package br.com.senior.crm.http.camel.Utils.Enums;

public enum Primitive
{
    // Account
    ACCOUNT("account"),
    ACCOUNT_DEFINITION("accountDefinition"),
    ACCOUNT_PHONE("accountPhone"),
    ACCOUNT_ADDRESS("accountAddress"),
    // Opportunity

    // Base Records

    ;

    public String path;

    Primitive(String path) {
        this.path = path;
    }
}
