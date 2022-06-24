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
 * de negócio
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessTypeDTO {

    public static final JacksonDataFormat BUSINESS_TYPE_DTO_FORMAT = new JacksonDataFormat(BusinessTypeDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Nome da modalidade de negócio
     */
    @JsonProperty("name")
    public String name;

    /**
     * Indicativo se a modalidade de negócio está ativa
     */
    @JsonProperty("active")
    public Boolean active;
}
