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
 * Entidade de propostas - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityProposal {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(OpportunityProposal.class);

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
     * Data da criação da abertura da oportunidade
     */
    @JsonProperty("date")
    private String date;

    /**
     * Hora da criação da abertura da oportunidade
     */
    @JsonProperty("hour")
    private String hour;

    /**
     * Número da proposta no CRM
     */
    @JsonProperty("proposalNumber")
    private String proposalNumber;

    /**
     * Número do pedido no sistema terceiro
     */
    @JsonProperty("orderNumber")
    private String orderNumber;

    /**
     * Número de revisão da proposta
     */
    @JsonProperty("revisionNumber")
    private Long revisionNumber;

    /**
     * Nome resumido da proposta
     */
    @JsonProperty("shortName")
    private String shortName;

    /**
     * Template de relatório da proposta
     */
    @JsonProperty("template")
    private TemplateDTO template;

    /**
     * Idioma do layout de proposta
     */
    @JsonProperty("languageLayout")
    private Long languageLayout;

    /**
     * Emissor/criador da proposta
     */
    @JsonProperty("issuer")
    private UserDTO issuer;

    /**
     * Status da proposta
     */
    @JsonProperty("proposalStatus")
    private Long proposalStatus;

    /**
     * Prazo de pagamento
     */
    @JsonProperty("paymentTerm")
    private PaymentTermDTO paymentTerm;

    /**
     * Valor ou porcentagem de IPI da proposta
     */
    @JsonProperty("ipi")
    private String ipi;

    /**
     * Valor ou porcentagem de ICMS da proposta
     */
    @JsonProperty("icms")
    private String icms;

    /**
     * Valor ou porcentagem de PIS da proposta
     */
    @JsonProperty("pis")
    private String pis;

    /**
     * Valor ou porcentagem de COFINS da proposta
     */
    @JsonProperty("cofins")
    private String cofins;

    /**
     * Valor ou porcentagem de SUFRAMA da proposta
     */
    @JsonProperty("suframa")
    private String suframa;

    /**
     * Valor ou porcentagem de ZONA FRANCA da proposta
     */
    @JsonProperty("zonaFranca")
    private String freeZone;

    /**
     * Transportadora
     */
    @JsonProperty("carrier")
    private CarrierDTO carrier;

    /**
     * Transportadora de redespacho
     */
    @JsonProperty("carrierDispatch")
    private CarrierDispatchDTO carrierDispatch;

    /**
     * Tipo de frete
     */
    @JsonProperty("shippingType")
    private Long shippingType;

    /**
     * Descritivo do outro tipo de frete
     */
    @JsonProperty("otherShippingType")
    private String otherShippingType;

    /**
     * Valor do frete
     */
    @JsonProperty("shippingValue")
    private Double shippingValue;

    /**
     * Garantia oferecida na prospota
     */
    @JsonProperty("warranty")
    private String warranty;

    /**
     * Validade da proposta
     */
    @JsonProperty("validity")
    private String validity;

    /**
     * Prazo de entrega dos produtos/serviços
     */
    @JsonProperty("deadlineShipping")
    private String deadlineShipping;

    /**
     * Informativo para agrupar os produtos/serviços por categoria
     */
    @JsonProperty("groupProductCategory")
    private Boolean groupProductCategory;

    /**
     * Informativo para enviar uma cópia por email ao responsável da oportunidade
     */
    @JsonProperty("sendProposalCopy")
    private Boolean sendProposalCopy;

    /**
     * Informativo se os valores dos produtos e serviços serão exibidos na proposta impressa
     */
    @JsonProperty("showValues")
    private Boolean showValues;

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