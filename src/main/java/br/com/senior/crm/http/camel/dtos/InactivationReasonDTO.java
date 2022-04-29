package br.com.senior.crm.http.camel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InactivationReasonDTO {

    public static final JacksonDataFormat INACTIVATION_REASON_DTO_FORMAT = new JacksonDataFormat(InactivationReasonDTO.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Motivo da inativação
     */
    @JsonProperty("name")
    public String name;
}