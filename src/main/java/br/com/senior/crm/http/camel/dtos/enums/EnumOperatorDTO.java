package br.com.senior.crm.http.camel.dtos.enums;

import lombok.Getter;

/**
 * Operadora
 */

public enum EnumOperatorDTO {
    /**
     * CLARO
     */
    CLARO("1"),
    /**
     * TIM
     */
    TIM("2"),
    /**
     * VIVO
     */
    VIVO("3"),
    /**
     * OI
     */
    OI("4");

    @Getter
    private String operator;

    EnumOperatorDTO(String operator) {
        this.operator = operator;
    }
}
