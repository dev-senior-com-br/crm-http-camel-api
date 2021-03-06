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
 * DTO da Cidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDTO {

    public static final JacksonDataFormat CITY_DTO_FORMAT = new JacksonDataFormat(CityDTO.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código da cidade no IBGE
     */
    @JsonProperty("ibgeCode")
    public String ibgeCode;

    /**
     * Nome da cidade
     */
    @JsonProperty("name")
    public String name;

    /**
     * Estado
     */
    @JsonProperty("state")
    public StateDTO state;

    /**
     * Id ERO
     */
    @JsonProperty("idErp")
    public String idErp;

}
