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
 * DTO do vendedor padrão
 * para a definição de conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellerDTO {

    public static final JacksonDataFormat SELLER_DTO_FORMAT = new JacksonDataFormat(SellerDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("representative")
    public Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("representative")
    public String idErp;

    /**
     * Nome do vendedor
     */
    @JsonProperty("representative")
    public String name;
}