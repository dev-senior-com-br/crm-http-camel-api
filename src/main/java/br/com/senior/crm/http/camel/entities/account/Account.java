package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.*;
import br.com.senior.crm.http.camel.entities.ErrorResponseEntity;
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
public class Account extends ErrorResponseEntity {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(Account.class);

    /**
     * Id de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Código de identificação
     */
    @JsonProperty("idErp")
    public String idErp;

    /**
     * Nome da conta
     */
    @JsonProperty("name")
    public String name;

    /**
     * Nome fantasia
     */
    @JsonProperty("fantasyName")
    public String fantasyName;

    /**
     * CNPJ da conta
     */
    @JsonProperty("cnpj")
    public String cnpj;

    /**
     * CPF da conta
     */
    @JsonProperty("cpf")
    public String cpf;

    /**
     * RG da conta
     */
    @JsonProperty("rg")
    public String rg;

    /**
     * Nit (Novasoft)
     */
    @JsonProperty("nit")
    public String nit;

    /**
     * Cedula de Ciudadania (Novasoft)
     */
    @JsonProperty("citizenshipCard")
    public String citizenshipCard;

    /**
     * Passaporte (Novasoft)
     */
    @JsonProperty("passport")
    public String passport;

    /**
     * Ramo de atividade
     */
    @JsonProperty("activityBranch")
    public ActivityBranchDTO activityBranch;

    /**
     * Inscrição estadual
     */
    @JsonProperty("stateRegistration")
    public String stateRegistration;

    /**
     * Inscrição municipal
     */
    @JsonProperty("municipalRegistration")
    public String municipalRegistration;

    /**
     * Porte da empresa
     */
    @JsonProperty("companySize")
    public CompanySizeDTO companySize;

    /**
     * URL do site da conta
     */
    @JsonProperty("url")
    public String url;

    /**
     * E-mail geral
     */
    @JsonProperty("generalEmail")
    public String generalEmail;

    /**
     * E-mail financeiro
     */
    @JsonProperty("financialEmail")
    public String financialEmail;

    /**
     * Data do cadastro
     */
    @JsonProperty("registerDate")
    public String registerDate;

    /**
     * Receita anual
     */
    @JsonProperty("annualIncome")
    public Double annualIncome;

    /**
     * Quantidade de funcionários
     */
    @JsonProperty("employees")
    public Long employees;

    /**
     * Tipo de pessoa
     */
    @JsonProperty("personType")
    public PersonTypeDTO personType;

    /**
     * EIN
     */
    @JsonProperty("einNumber")
    public String einNumber;

    /**
     * SSN
     */
    @JsonProperty("ssnNumber")
    public String ssnNumber;

    /**
     * Grupo de empresa
     */
    @JsonProperty("companyGroup")
    public CompanyGroupDTO companyGroup;

    /**
     * Origem
     */
    @JsonProperty("origin")
    public OriginDTO origin;

    /**
     * Data de nascimento/abertura
     */
    @JsonProperty("birthDate")
    public String birthDate;

    /**
     * Status de atividade
     */
    @JsonProperty("active")
    public Long active;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    public String customFields;
}