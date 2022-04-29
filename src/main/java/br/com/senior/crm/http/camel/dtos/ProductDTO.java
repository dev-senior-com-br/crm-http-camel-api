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
 * DTO do Produto
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    public static final JacksonDataFormat PRODUCT_DTO_FORMAT = new JacksonDataFormat(ProductDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("productCode")
    public String productCode;

    /**
     * Código de identificação da derivação no sistema terceiro
     */
    @JsonProperty("productDerivationCode")
    public String productDerivationCode;
}
