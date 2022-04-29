package br.com.senior.crm.http.camel.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

/**
 * Entidade referente a
 * erros retornados
 * de entidades em Java
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseEntity {

    public static final JacksonDataFormat ERROR_RESPONSE_ENTITY_FORMAT = new JacksonDataFormat(ErrorResponseEntity.class);

    /**
     * Messagem de erro
     * da requisição
     */
    @JsonProperty("message")
    private String message;

    /**
     * Local do Erro
     * no Java
     */
    @JsonProperty("errorCode")
    private String errorCode;

    /**
     * Tipo do erro
     * em HTTP
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * Dominio da aplicação
     */
    @JsonProperty("domain")
    private String domain;

    /**
     * Serviço da aplicação
     */
    @JsonProperty("service")
    private String service;
}