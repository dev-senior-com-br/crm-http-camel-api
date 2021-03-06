package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.BasicAccountDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

/**
 * Entidade da conta de telefone
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountPhone {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountPhone.class);

    /**
     * Código de identificação da definição da conta no CRM
     */
    @JsonProperty("id")
    private Long id;

    /**
     * A conta da definição
     */
    @JsonProperty("account")
    private BasicAccountDTO account;

    /**
     * Número de telefone da conta
     */
    @JsonProperty("number")
    private String number;

    /**
     * Tipo de telefone da conta
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * Operadora de telefone da conta
     */
    @JsonProperty("operator")
    private Integer operator;

    /**
     * É o principal telefone da conta
     */
    @JsonProperty("main")
    private Boolean main;
}