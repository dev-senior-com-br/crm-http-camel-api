package br.com.senior.crm.http.camel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

/**
 * DTO dos
 * dados básicos
 * da Conta.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicAccountDTO {

    public static final JacksonDataFormat BASIC_ACCOUNT_DTO_FORMAT = new JacksonDataFormat(BasicAccountDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("idErp")
    public String idErp;

    /**
     * Nome da conta
     */
    @JsonProperty("name")
    public String name;

    /**
     * CNPJ da Conta
     */
    @JsonProperty("cnpj")
    public String cnpj;

    /**
     * CPF da Conta
     */
    @JsonProperty("cpf")
    public String cpf;

    /**
     * RG da Conta
     */
    @JsonProperty("rg")
    public String rg;
}
