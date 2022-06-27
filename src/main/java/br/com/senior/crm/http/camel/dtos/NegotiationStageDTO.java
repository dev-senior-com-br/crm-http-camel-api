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
 * DTO do estágio de negociação
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NegotiationStageDTO {

    public static final JacksonDataFormat NEGOTIATION_STATE_DTO_FORMAT = new JacksonDataFormat(NegotiationStageDTO.class);

    @JsonProperty("stage")
    private Long stage;

    /**
     * Nome do estágio
     * da negociação
     */
    @JsonProperty("name")
    private String name;

    /**
     * Percentual do estágio
     */
    @JsonProperty("percentage")
    public Long percentage;
}