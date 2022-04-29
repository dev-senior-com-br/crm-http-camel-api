package br.com.senior.crm.http.camel.entities.opportunity;

import br.com.senior.crm.http.camel.dtos.OpportunityDTO;
import br.com.senior.crm.http.camel.dtos.PriceTableDTO;
import br.com.senior.crm.http.camel.dtos.ProposalDTO;
import br.com.senior.crm.http.camel.dtos.ServiceDTO;
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
 * Entidade de serviços - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityService extends ErrorResponseEntity {

    public static final JacksonDataFormat OPPORTUNITY_SERVICE_FORMAT = new JacksonDataFormat(OpportunityService.class);

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
    public ServiceDTO service;

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
     * Percential de desconto do produto
     */
    @JsonProperty("discountPercentage")
    public Double discountPercentage;

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