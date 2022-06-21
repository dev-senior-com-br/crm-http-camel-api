package br.com.senior.crm.http.camel.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;

import java.util.Map;

/**
 * <h1>Classe que formata propriedades.</h1>
 *
 * <p>Classe que contém os métodos
 * por formatar propriedades das
 * {@link Exchange}.</p>
 *
 * @author lucas.nunes
 */
@Slf4j
public class FormatProperty {

    private FormatProperty() {
    }

    /**
     * <h1>Formata a propriedade da {@link Exchange}.</h1>
     *
     * <p>Recebe uma {@link Exchange}, um campo
     * e o nome de uma propriedade. Ele atribui
     * o valor do field para o property
     * passado. Ele converte o body
     * da {@link Exchange} para um
     * {@link Map}
     * e tenta recuperar o field
     * de dentro desse Map,
     * se ele conseguir ele irá
     * converter esse field para outro
     * Map e pegar o campo Id de dentro
     * dele. Se ele não conseguir
     * recuperar o field dentro desse
     * Map ele apenas irá retornar o
     * campo id de dentro desse Map.</p>
     *
     * @param exchange     {@link Exchange} referente a {@link Exchange}
     *                     da requisição.
     * @param field        {@link String} referente ao campo
     *                     onde será procurado o id.
     * @param propertyName {@link String} nome da propriedade
     *                     onde será salvo o valor
     *                     recuperado do field ou
     *                     do body.
     */
    public static void format(Exchange exchange, String field, String propertyName) {
        Map<String, Object> body = (Map<String, Object>) exchange.getMessage().getBody();
        if (body.get(field) != null) {
            Map<String, Object> objectField = (Map<String, Object>) body.get(field);
            exchange.setProperty(propertyName, objectField.get("id").toString());
        } else {
            exchange.setProperty(propertyName, body.get("id").toString());
        }
    }
}