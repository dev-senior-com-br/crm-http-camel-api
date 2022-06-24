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
 * DTO da tabela de preço
 * padrão para a definição de conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceTableDTO {

    public static final JacksonDataFormat PRICE_TABLE_DTO_FORMAT = new JacksonDataFormat(PriceTableDTO.class);

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
     * Nome da tabela de preços
     */
    @JsonProperty("name")
    public String name;

    /**
     * Indicativo se a tabela de preço está ativa
     */
    @JsonProperty("active")
    public String active;
}