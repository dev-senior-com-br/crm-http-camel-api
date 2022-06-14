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
 * DTO do Estado
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateDTO {

    public static final JacksonDataFormat STATE_DTO_FORMAT = new JacksonDataFormat(StateDTO.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Nome
     */
    @JsonProperty("name")
    public String name;

    /**
     * Inicial
     */
    @JsonProperty("initials")
    public String initials;

    /**
     * País
     */
    @JsonProperty("country")
    public CountryDTO country;

    /**
     * Id ERO
     */
    @JsonProperty("idErp")
    public String idErp;

}
