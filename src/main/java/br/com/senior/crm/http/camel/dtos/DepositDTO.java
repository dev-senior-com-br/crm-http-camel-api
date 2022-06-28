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
 * DTO do depósito
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDTO {

    public static final JacksonDataFormat DEPOSIT_DTO_FORMAT = new JacksonDataFormat(DepositDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("id")
    private String idErp;

    /**
     * Nome do depósito
     */
    @JsonProperty("name")
    private String name;

    /**
     * Indicativo se o depósito está ativo
     */
    @JsonProperty("active")
    private Boolean active;
}
