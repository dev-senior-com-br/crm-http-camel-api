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
 * DTO da origem da oportunidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityOriginDTO {

    public static final JacksonDataFormat OPPORTUNITY_ORIGIN_DTO_FORMAT = new JacksonDataFormat(OpportunityOriginDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Nome da origem da oportunidade
     */
    @JsonProperty("name")
    public String name;

    /**
     * Indicativo se a origem da oportunidade está ativa
     */
    @JsonProperty("active")
    public Boolean active;
}
