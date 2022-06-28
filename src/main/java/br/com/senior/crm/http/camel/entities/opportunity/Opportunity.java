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
 * Entidade referente a Oportunidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Opportunity {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(Opportunity.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    private Long id;

    /**
     * Empresa filial da oportunidade
     */
    @JsonProperty("companyBranch")
    private CompanyBranchDTO companyBranch;

    /**
     * Conta da oportunidade
     */
    @JsonProperty("account")
    private BasicAccountDTO account;

    /**
     * Contato da oportunidade
     */
    @JsonProperty("contact")
    private ContactDTO contact;

    /**
     * Nome da oportunidade
     */
    @JsonProperty("opportunityName")
    private String opportunityName;

    /**
     * Tipo da oportunidade
     */
    @JsonProperty("opportunityType")
    private OpportunityTypeDTO opportunityType;

    /**
     * Subtipo da oportunidade
     */
    @JsonProperty("opportunitySubtype")
    private OpportunitySubtypeDTO opportunitySubtype;

    /**
     * Modalidade de negócio
     */
    @JsonProperty("businessType")
    private BusinessTypeDTO businessType;

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
     * Origem da oportunidade
     */
    @JsonProperty("opportunityOrigin")
    private OpportunityOriginDTO opportunityOrigin;

    /**
     * Responsável pela oportunidade
     */
    @JsonProperty("responsible")
    private UserDTO responsible;

    /**
     * Estágio da oportunidade
     */
    @JsonProperty("negotiationStage")
    private NegotiationStageDTO negotiationStage;

    /**
     * Motivo da perda da oportunidade
     */
    @JsonProperty("lossReason")
    private LossReasonDTO lossReason;

    /**
     * Motivo da venda da oportunidade
     */
    @JsonProperty("salesReasons")
    private SalesReasonsDTO salesReasons;

    /**
     * Usuário que cadastrou
     */
    @JsonProperty("operatorRegistration")
    private UserDTO operatorRegistration;

    /**
     * Usuário que alterou
     */
    @JsonProperty("operatorChange")
    private UserDTO operatorChange;

    /**
     * Probabilidade de fechamento da oportunidade
     */
    @JsonProperty("probability")
    private Long probability;

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
     * Data da previsão de fechamento da oportunidade
     */
    @JsonProperty("expectedClosingString")
    private String expectedClosingString;

    /**
     * Data efetiva do fechamento da oportunidade
     */
    @JsonProperty("effectiveClosingString")
    private String effectiveClosingString;

    /**
     * Data prevista para a entrega dos produtos
     */
    @JsonProperty("expectedDeliveryString")
    private String expectedDeliveryString;

    /**
     * Valor previsto da oportunidade
     */
    @JsonProperty("expectedValue")
    private Double expectedValue;

    /**
     * Valor fechado da oportunidade
     */
    @JsonProperty("effectiveClosingValue")
    private Double effectiveClosingValue;

    /**
     * Quantidade prevista para a oportunidade
     */
    @JsonProperty("expectedQuantity")
    private Double expectedQuantity;

    /**
     * Quantidade realizada para a oportunidade
     */
    @JsonProperty("achievedQuantity")
    private Double achievedQuantity;

    /**
     * Histórico de negociação da oportunidade
     */
    @JsonProperty("history")
    private String history;

    /**
     * Descrição da oportunidade
     */
    @JsonProperty("description")
    private String description;

    /**
     * Se notifica por email a criação da oportunidade e demais interações
     */
    @JsonProperty("notifyEmail")
    private Boolean notifyEmail;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    private String customFields;
}