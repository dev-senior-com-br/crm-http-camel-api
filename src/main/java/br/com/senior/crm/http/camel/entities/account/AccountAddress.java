package br.com.senior.crm.http.camel.entities.account;

import br.com.senior.crm.http.camel.dtos.AddressTypeDTO;
import br.com.senior.crm.http.camel.dtos.BasicAccountDTO;
import br.com.senior.crm.http.camel.dtos.CityDTO;
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
public class AccountAddress {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountAddress.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Conta do endereço
     */
    @JsonProperty("account")
    private BasicAccountDTO account;

    /**
     * É o endereço principal da conta
     */
    @JsonProperty("mainAddress")
    private Boolean mainAddress;

    /**
     * Tipo de endereço
     */
    @JsonProperty("addressType")
    private AddressTypeDTO addressType;

    /**
     * Endereço
     */
    @JsonProperty("address")
    private String address;

    /**
     * Número
     */
    @JsonProperty("number")
    private String number;

    /**
     * Complemento
     */
    @JsonProperty("complement")
    private String complement;

    /**
     * Bairro
     */
    @JsonProperty("district")
    private String district;

    /**
     * Cidade
     */
    @JsonProperty("city")
    private CityDTO city;

    /**
     * CEP
     */
    @JsonProperty("cepCode")
    private String cepCode;

    /**
     * ZIP
     */
    @JsonProperty("zipCode")
    private String zipCode;

    /**
     * Latitude
     */
    @JsonProperty("latitude")
    private Double latitude;

    /**
     * Longitude
     */
    @JsonProperty("longitude")
    private Double longitude;

    /**
     * Status do endereço
     */
    @JsonProperty("active")
    private Boolean active;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    private String customFields;
}
