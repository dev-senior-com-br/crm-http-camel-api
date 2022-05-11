package br.com.senior.crm.http.camel.dtos.enums;

import lombok.Getter;

/**
 * Enum do tipo do telefone da conta
 */
public enum EnumPhoneTypeDTO {
    /**
     * Tipo Telefone Fixo
     */
    TelefoneFixo("1"),
    /**
     * Tipo Celular
     */
    Celular("2"),
    /**
     * Tipo Fax
     */
    Fax("3");

    @Getter
    private String type;

    EnumPhoneTypeDTO(String type) {
        this.type = type;
    }
}
