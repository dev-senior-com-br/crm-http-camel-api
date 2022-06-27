package br.com.senior.crm.http.camel.utils.enums;

import lombok.Getter;

public enum ValidateSettingsDirectEnum {
    // Novasoft
    DIRECT_NOVASOFT_ACCOUNT_DEFINITION("direct:crm-validate-settings-novasoft-account-definition")
    ;

    @Getter
    private final String value;

    ValidateSettingsDirectEnum(String value) {
        this.value = value;
    }
}
