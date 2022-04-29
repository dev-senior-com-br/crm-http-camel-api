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
 * Entidade de propostas - Entrada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityProposal extends ErrorResponseEntity {

    public static final JacksonDataFormat OPPORTUNITY_PROPOSAL_FORMAT = new JacksonDataFormat(OpportunityProposal.class);

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
     * Data e hora da criação da abertura da oportunidade
     */
    @JsonProperty("dateTime")
    public String dateTime;

    /**
     * Número da proposta no CRM
     */
    @JsonProperty("proposalNumber")
    public String proposalNumber;

    /**
     * Número do pedido no sistema terceiro
     */
    @JsonProperty("orderNumber")
    public String orderNumber;

    /**
     * Número de revisão da proposta
     */
    @JsonProperty("revisionNumber")
    public Long revisionNumber;

    /**
     * Nome resumido da proposta
     */
    @JsonProperty("shortName")
    public String shortName;

    /**
     * Template de relatório da proposta
     */
    @JsonProperty("template")
    public TemplateDTO template;

    /**
     * Idioma do layout de proposta
     */
    @JsonProperty("languageLayout")
    public Long languageLayout;

    /**
     * Emissor/criador da proposta
     */
    @JsonProperty("issuer")
    public IssuerDTO issuer;

    /**
     * Status da proposta
     */
    @JsonProperty("proposalStatus")
    public Long proposalStatus;

    /**
     * Prazo de pagamento
     */
    @JsonProperty("paymentTerm")
    public PaymentTermDTO paymentTerm;

    /**
     * Valor ou porcentagem de IPI da proposta
     */
    @JsonProperty("ipi")
    public String ipi;

    /**
     * Valor ou porcentagem de ICMS da proposta
     */
    @JsonProperty("icms")
    public String icms;

    /**
     * Valor ou porcentagem de PIS da proposta
     */
    @JsonProperty("pis")
    public String pis;

    /**
     * Valor ou porcentagem de COFINS da proposta
     */
    @JsonProperty("cofins")
    public String cofins;

    /**
     * Valor ou porcentagem de SUFRAMA da proposta
     */
    @JsonProperty("suframa")
    public String suframa;

    /**
     * Valor ou porcentagem de ZONA FRANCA da proposta
     */
    @JsonProperty("zonaFranca")
    public String zonaFranca;

    /**
     * Transportadora
     */
    @JsonProperty("carrier")
    public CarrierDTO carrier;

    /**
     * Transportadora de redespacho
     */
    @JsonProperty("carrierDispatch")
    public CarrierDispatchDTO carrierDispatch;

    /**
     * Tipo de frete
     */
    @JsonProperty("shippingType")
    public Long shippingType;

    /**
     * Descritivo do outro tipo de frete
     */
    @JsonProperty("otherShippingType")
    public String otherShippingType;

    /**
     * Valor do frete
     */
    @JsonProperty("shippingValue")
    public Double shippingValue;

    /**
     * Garantia oferecida na prospota
     */
    @JsonProperty("warranty")
    public String warranty;

    /**
     * Validade da proposta
     */
    @JsonProperty("validity")
    public String validity;

    /**
     * Prazo de entrega dos produtos/serviços
     */
    @JsonProperty("deadlineShipping")
    public String deadlineShipping;

    /**
     * Informativo para agrupar os produtos/serviços por categoria
     */
    @JsonProperty("groupProductCategory")
    public Boolean groupProductCategory;

    /**
     * Informativo para enviar uma cópia por email ao responsável da oportunidade
     */
    @JsonProperty("sendProposalCopy")
    public Boolean sendProposalCopy;

    /**
     * Informativo se os valores dos produtos e serviços serão exibidos na proposta impressa
     */
    @JsonProperty("showValues")
    public Boolean showValues;

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