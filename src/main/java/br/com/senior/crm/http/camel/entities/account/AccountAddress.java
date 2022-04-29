package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.AddressTypeDTO;
import br.com.senior.crm.http.camel.dtos.BasicAccountDTO;
import br.com.senior.crm.http.camel.dtos.CityDTO;
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
 * Entidade referente
 * ao endereço da conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAddress extends ErrorResponseEntity {

    public static final JacksonDataFormat ACCOUNT_ADDRESS_FORMAT = new JacksonDataFormat(AccountAddress.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Conta do endereço
     */
    @JsonProperty("account")
    public BasicAccountDTO account;

    /**
     * É o endereço principal da conta
     */
    @JsonProperty("mainAddress")
    public Boolean mainAddress;

    /**
     * Tipo de endereço
     */
    @JsonProperty("addressType")
    public AddressTypeDTO addressType;

    /**
     * Endereço
     */
    @JsonProperty("address")
    public String address;

    /**
     * Número
     */
    @JsonProperty("number")
    public Long number;

    /**
     * Complemento
     */
    @JsonProperty("complement")
    public String complement;

    /**
     * Bairro
     */
    @JsonProperty("district")
    public String district;

    /**
     * Cidade
     */
    @JsonProperty("city")
    public CityDTO city;

    /**
     * CEP
     */
    @JsonProperty("cepCode")
    public String cepCode;

    /**
     * ZIP
     */
    @JsonProperty("zipCode")
    public String zipCode;

    /**
     * Latitude
     */
    @JsonProperty("latitude")
    public Double latitude;

    /**
     * Longitude
     */
    @JsonProperty("longitude")
    public Double longitude;

    /**
     * Status do endereço
     */
    @JsonProperty("active")
    public Long active;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    public String customFields;
}
