package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.BasicAccountDTO;
import br.com.senior.crm.http.camel.dtos.enums.EnumOperatorDTO;
import br.com.senior.crm.http.camel.dtos.enums.EnumPhoneTypeDTO;
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
 * Entidade da conta de telefone
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountPhone extends ErrorResponseEntity {

    public static final JacksonDataFormat ACCOUNT_PHONE_FORMAT = new JacksonDataFormat(AccountPhone.class);

    /**
     * Código de identificação da definição da conta no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * A conta da definição
     */
    @JsonProperty("account")
    public BasicAccountDTO account;

    /**
     * Número de telefone da conta
     */
    @JsonProperty("phoneNumber")
    public String phoneNumber;

    /**
     * Tipo de telefone da conta
     */
    @JsonProperty("phoneType")
    public EnumPhoneTypeDTO phoneType;

    /**
     * Operadora de telefone da conta
     */
    @JsonProperty("phoneOperator")
    public EnumOperatorDTO phoneOperator;

    /**
     * É o principal telefone da conta
     */
    @JsonProperty("mainPhone")
    public Boolean mainPhone;
}