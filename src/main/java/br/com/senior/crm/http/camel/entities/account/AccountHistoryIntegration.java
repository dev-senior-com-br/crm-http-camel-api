package br.com.senior.crm.http.camel.entities.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;
import org.apache.camel.component.jackson.JacksonDataFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountHistoryIntegration {
    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountHistoryIntegration.class);

    /**
     * Identificador do Histórico
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Data e hora
     */
    @JsonProperty("datetime")
    private String datetime;

    /**
     * Status: 0 = Não Integrado; 1 = Integrado: 2 = Falha ao integrar
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * Conteúdo do resultado da integração
     */
    @JsonProperty("content")
    private String content;

    /**
     * Conta Integrada
     */
    @JsonProperty("account")
    private Long account;

}
