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
public class CompanyBranchDTO {

    public static final JacksonDataFormat COMPANY_BRANCH_DTO_FORMAT = new JacksonDataFormat(CompanyBranchDTO.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código de identificação da empresa no sistema terceiro
     */
    @JsonProperty("companyErp")
    public String companyErp;

    /**
     * Código de identificação da filial no sistema terceiro
     */
    @JsonProperty("branchErp")
    public String branchErp;
}