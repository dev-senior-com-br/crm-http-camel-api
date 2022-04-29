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
 * DTO da Oportunidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityDTO {

    public static final JacksonDataFormat OPPORTUNITY_DTO_FORMAT = new JacksonDataFormat(OpportunityDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Número da proposta no CRM
     */
    @JsonProperty("proposalNumber")
    public String proposalNumber;

    /**
     * Número do pedido no sistema terceiro
     */
    @JsonProperty("orderNumber")
    public String orderNumber;
}
