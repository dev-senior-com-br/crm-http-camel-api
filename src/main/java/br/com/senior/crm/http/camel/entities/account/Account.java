package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

/**
 * Entidade referente a Conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(Account.class);

    /**
     * Id de identificação
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Código de identificação
     */
    @JsonProperty("idErp")
    private String idErp;

    /**
     * Nome da conta
     */
    @JsonProperty("name")
    private String name;

    /**
     * Nome fantasia
     */
    @JsonProperty("fantasyName")
    private String fantasyName;

    /**
     * CNPJ da conta
     */
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * CPF da conta
     */
    @JsonProperty("cpf")
    private String cpf;

    /**
     * RG da conta
     */
    @JsonProperty("rg")
    private String rg;

    /**
     * Nit (Novasoft)
     */
    @JsonProperty("nit")
    private String nit;

    /**
     * Cedula de Ciudadania (Novasoft)
     */
    @JsonProperty("citizenshipCard")
    private String citizenshipCard;

    /**
     * Passaporte (Novasoft)
     */
    @JsonProperty("passport")
    private String passport;

    /**
     * Ramo de atividade
     */
    @JsonProperty("activityBranch")
    private ActivityBranchDTO activityBranch;

    /**
     * Inscrição estadual
     */
    @JsonProperty("stateRegistration")
    private String stateRegistration;

    /**
     * Inscrição municipal
     */
    @JsonProperty("municipalRegistration")
    private String municipalRegistration;

    /**
     * Porte da empresa
     */
    @JsonProperty("companySize")
    private CompanySizeDTO companySize;

    /**
     * URL do site da conta
     */
    @JsonProperty("url")
    private String url;

    /**
     * E-mail geral
     */
    @JsonProperty("generalEmail")
    private String generalEmail;

    /**
     * E-mail financeiro
     */
    @JsonProperty("financialEmail")
    private String financialEmail;

    /**
     * Data do cadastro
     */
    @JsonProperty("registerDate")
    private String registerDate;

    /**
     * Receita anual
     */
    @JsonProperty("annualIncome")
    private Double annualIncome;

    /**
     * Quantidade de funcionários
     */
    @JsonProperty("employees")
    private Long employees;

    /**
     * Tipo de pessoa
     */
    @JsonProperty("personType")
    private PersonTypeDTO personType;

    /**
     * EIN
     */
    @JsonProperty("einNumber")
    private String einNumber;

    /**
     * SSN
     */
    @JsonProperty("ssnNumber")
    private String ssnNumber;

    /**
     * Grupo de empresa
     */
    @JsonProperty("companyGroup")
    private CompanyGroupDTO companyGroup;

    /**
     * Origem
     */
    @JsonProperty("origin")
    private OriginDTO origin;

    /**
     * Data de nascimento/abertura
     */
    @JsonProperty("birthDate")
    private String birthDate;

    /**
     * Status de atividade
     */
    @JsonProperty("active")
    private Long active;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    private String customFields;
}