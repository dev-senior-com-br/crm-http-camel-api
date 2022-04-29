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
 * DTO do
 * Tipo de Pessoa
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonTypeDTO {

    public static final JacksonDataFormat PERSON_TYPE_DTO_FORMAT = new JacksonDataFormat(PersonTypeDTO.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Nome do tipo de Pessoa
     */
    @JsonProperty("name")
    public String name;
}
