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
 * DTO do responsável
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsibleDTO {

    public static final JacksonDataFormat RESPONSIBLE_DTO_FORMAT = new JacksonDataFormat(ResponsibleDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("idErp")
    public Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("idErp")
    public String idErp;

}
