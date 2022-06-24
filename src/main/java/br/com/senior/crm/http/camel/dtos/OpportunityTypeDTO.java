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
 * DTO do tipo
 * da oportunidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityTypeDTO {

    public static final JacksonDataFormat OPPORTUNITY_TYPE_DTO_FORMAT = new JacksonDataFormat(OpportunityTypeDTO.class);

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
     * Nome do tipo de oportunidade
     */
    @JsonProperty("name")
    public String name;

    /**
     * Observação do tipo de oportunidade
     */
    @JsonProperty("note")
    public String note;

    /**
     * Indicativo se o tipo de oportunidade está ativo
     */
    @JsonProperty("active")
    public Boolean active;
}