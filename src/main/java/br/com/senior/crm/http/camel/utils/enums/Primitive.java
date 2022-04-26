package br.com.senior.crm.http.camel.utils.enums;

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

    private String path;

    public String getPath() {
        return path;
    }

    Primitive(String path) {
        this.path = path;
    }
}
