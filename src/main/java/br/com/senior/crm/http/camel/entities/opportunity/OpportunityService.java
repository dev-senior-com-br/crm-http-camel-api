package br.com.senior.crm.http.camel.entities.opportunity;

import org.apache.camel.component.jackson.JacksonDataFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.senior.crm.http.camel.dtos.OpportunityDTO;
import br.com.senior.crm.http.camel.dtos.PriceTableDTO;
import br.com.senior.crm.http.camel.dtos.ProposalDTO;
import br.com.senior.crm.http.camel.dtos.ServiceDTO;
import br.com.senior.crm.http.camel.dtos.UserDTO;
import br.com.senior.crm.http.camel.entities.ErrorResponseEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Entidade de serviços - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityService extends ErrorResponseEntity {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(OpportunityService.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Oportunidade
     */
    @JsonProperty("opportunity")
    public OpportunityDTO opportunity;

    /**
     * Proposta
     */
    @JsonProperty("proposal")
    public ProposalDTO proposal;

    /**
     * Sequencial do produto no pedido
     */
    @JsonProperty("sequenceErp")
    public Long sequenceErp;

    /**
     * Serviço
     */
    @JsonProperty("service")
    public ServiceDTO serviceDTO;

    /**
     * Quantidade do produto na proposta
     */
    @JsonProperty("quantity")
    public Double quantity;

    /**
     * Tabela de preço do produto
     */
    @JsonProperty("priceTable")
    public PriceTableDTO priceTable;

    /**
     * Cadastro do operador da oportunidade
     */
    @JsonProperty("operatorRegistration")
    public UserDTO operatorRegistration;

    /**
     * Usuário que alterou
     */
    @JsonProperty("operatorChange")
    public UserDTO operatorChange;

    /**
     * Valor da vensa do produto na proposta
     */
    @JsonProperty("saleValue")
    public Double saleValue;

    /**
     * Valor de desconto do produto
     */
    @JsonProperty("discountValue")
    public Double discountValue;

    /**
     * Informativo de exibe o valor do produto na proposta
     */
    @JsonProperty("showValues")
    public Boolean showValues;

    /**
     * Informativo se exibe as fotos do produto na proposta
     */
    @JsonProperty("showPhotos")
    public Boolean showPhotos;

    /**
     * Informativo se apresenta os anexos do produto na proposta
     */
    @JsonProperty("showAttachment")
    public Boolean showAttachment;

    /**
     * Observações da proposta
     */
    @JsonProperty("note")
    public String note;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    public String customFields;
}