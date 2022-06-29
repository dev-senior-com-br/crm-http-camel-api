package br.com.senior.crm.http.camel.utils.enums;

/**
 * Enum referente aos comparadores
 * de filtro que podem ser usados no CRM.
 */
public enum ComparatorEnum {

    /**
     * Igual
     */
    EQ,

    /**
     * Diferente
     */
    NEQ,

    /**
     * Contém
     */
    IN,

    /**
     * Não contém
     */
    NOT_IN,

    /**
     * Contém parte
     */
    LIKE,

    /**
     * Não contém parte
     */
    NOT_LIKE,

    /**
     * Menor que
     */
    LT,

    /**
     * Menor ou igual
     */
    LTE,

    /**
     * Maior que
     */
    GT,

    /**
     * Maior ou igual
     */
    GTE;

    public String getComparator() {
        return this.toString();
    }
}