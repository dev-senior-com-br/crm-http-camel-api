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
 * DTO do tipo da Conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTypeDTO {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountTypeDTO.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Nome do tipo da Conta
     */
    @JsonProperty("name")
    private String name;

    /**
     * Se esse tipo
     * de conta está
     * ativo ou não
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * Icone do tipo
     * de conta
     */
    @JsonProperty("icon")
    private String icon;

    /**
     * Cor desse tipo
     * de conta.
     */
    @JsonProperty("color")
    private String color;

    /**
     * Campos customizados.
     */
    @JsonProperty("customFields")
    private String customFields;
}