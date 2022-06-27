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
 * DTO transportadore de redespacho
 * padrão para a definição de conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarrierDispatchDTO {

    public static final JacksonDataFormat CARRIER_DISPATCH_DTO_FORMAT = new JacksonDataFormat(CarrierDispatchDTO.class);

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
     * Nome da transportadora de dispacho
     */
    @JsonProperty("name")
    public String name;

    /**
     * Indicativo se a transportadora de redespacho está ativa
     */
    @JsonProperty("active")
    public Boolean active;
}
