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
 * DTO da classe
 * de ramo de atividade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityBranchDTO {

    public static final JacksonDataFormat ACTIVITY_BRANCH_DTO_FORMAT = new JacksonDataFormat(ActivityBranchDTO.class);

    /**
     * Id de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código de identificação no sistema terceiro
     */
    @JsonProperty("idErp")
    public String idErp;

    /**
     * Nome da Empresa/Filial
     */
    @JsonProperty("name")
    public String name;
}
