package br.com.senior.crm.http.camel.entities.opportunity;

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
 * Entidade de serviços - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityService {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(OpportunityService.class);

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
     * Serviço
     */
    @JsonProperty("service")
    private ServiceDTO serviceDTO;

    /**
     * Quantidade do produto na proposta
     */
    @JsonProperty("quantity")
    private Double quantity;

    /**
     * Tabela de preço do produto
     */
    @JsonProperty("priceTable")
    private PriceTableDTO priceTable;

    /**
     * Cadastro do operador da oportunidade
     */
    @JsonProperty("operatorRegistration")
    private UserDTO operatorRegistration;

    /**
     * Usuário que alterou
     */
    @JsonProperty("operatorChange")
    private UserDTO operatorChange;

    /**
     * Valor da vensa do produto na proposta
     */
    @JsonProperty("saleValue")
    private Double saleValue;

    /**
     * Valor de desconto do produto
     */
    @JsonProperty("discountValue")
    private Double discountValue;

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