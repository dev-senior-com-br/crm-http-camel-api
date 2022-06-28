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
public class OpportunityProduct {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(OpportunityProduct.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Oportunidade
     */
    @JsonProperty("opportunity")
    private OpportunityDTO opportunity;

    /**
     * Proposta
     */
    @JsonProperty("proposal")
    private ProposalDTO proposal;

    /**
     * Sequencial do produto no pedido
     */
    @JsonProperty("sequenceErp")
    private Long sequenceErp;

    /**
     * Produto da proposta
     */
    @JsonProperty("product")
    private ProductDTO product;

    /**
     * Quantidade do produto na proposta
     */
    @JsonProperty("quantity")
    private Double quantity;

    /**
     * Depósito do produto
     */
    @JsonProperty("deposit")
    private DepositDTO deposit;

    /**
     * Tabela de preço do produto
     */
    @JsonProperty("priceTable")
    private PriceTableDTO priceTable;

    /**
     * Tipo de venda
     */
    @JsonProperty("saleType")
    private Long saleType;

    /**
     * Valor da vensa do produto na proposta
     */
    @JsonProperty("saleValue")
    private Double saleValue;

    /**
     * Informativo se deve aplicar o valor de correção no valor do produto
     */
    @JsonProperty("applyCorrectionFactor")
    private Boolean applyCorrectionFactor;

    /**
     * Valor de desconto do produto
     */
    @JsonProperty("discountValue")
    private Double discountValue;

    /**
     * Percential de desconto do produto
     */
    @JsonProperty("discountPercentage")
    private Double discountPercentage;

    /**
     * Informativo de exibe o valor do produto na proposta
     */
    @JsonProperty("showValues")
    private Boolean showValues;

    /**
     * Informativo se exibe as fotos do produto na proposta
     */
    @JsonProperty("showPhotos")
    private Boolean showPhotos;

    /**
     * Informativo se apresenta os anexos do produto na proposta
     */
    @JsonProperty("showAttachment")
    private Boolean showAttachment;

    /**
     * Observações da proposta
     */
    @JsonProperty("note")
    private String note;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    private String customFields;
}
