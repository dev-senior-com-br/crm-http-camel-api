package br.com.senior.crm.http.camel.entities.opportunity;

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
 * Entidade de produtos - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityProduct extends ErrorResponseEntity {

    public static final JacksonDataFormat OPPORTUNITY_PRODUCT_FORMAT = new JacksonDataFormat(OpportunityProduct.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Oportunidade
     */
    @JsonProperty("id")
    public OpportunityDTO opportunity;

    /**
     * Proposta
     */
    @JsonProperty("id")
    public ProposalDTO proposal;

    /**
     * Sequencial do produto no pedido
     */
    @JsonProperty("id")
    public Long sequenceErp;

    /**
     * Produto da proposta
     */
    @JsonProperty("id")
    public ProductDTO product;

    /**
     * Quantidade do produto na proposta
     */
    @JsonProperty("id")
    public Double quantity;

    /**
     * Depósito do produto
     */
    @JsonProperty("id")
    public DepositDTO deposit;

    /**
     * Tabela de preço do produto
     */
    @JsonProperty("id")
    public PriceTableDTO priceTable;

    /**
     * Tipo de venda
     */
    @JsonProperty("saleType")
    public Long saleType;

    /**
     * Valor da vensa do produto na proposta
     */
    @JsonProperty("saleValue")
    public Double saleValue;

    /**
     * Informativo se deve aplicar o valor de correção no valor do produto
     */
    @JsonProperty("applyCorrectionFactor")
    public Boolean applyCorrectionFactor;

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
