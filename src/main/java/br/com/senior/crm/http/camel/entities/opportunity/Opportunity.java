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
 * Entidade referente a Oportunidade
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Opportunity extends ErrorResponseEntity {

    public static final JacksonDataFormat OPPORTUNITY_FORMAT = new JacksonDataFormat(Opportunity.class);

    /**
     * Código de identificação no CRM
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Empresa filial da oportunidade
     */
    @JsonProperty("companyBranch")
    public CompanyBranchDTO companyBranch;

    /**
     * Conta da oportunidade
     */
    @JsonProperty("account")
    public BasicAccountDTO account;

    /**
     * Contato da oportunidade
     */
    @JsonProperty("contact")
    public ContactDTO contact;

    /**
     * Nome da oportunidade
     */
    @JsonProperty("opportunityName")
    public String opportunityName;

    /**
     * Tipo da oportunidade
     */
    @JsonProperty("opportunityType")
    public OpportunityTypeDTO opportunityType;

    /**
     * Subtipo da oportunidade
     */
    @JsonProperty("opportunitySubtype")
    public OpportunitySubtypeDTO opportunitySubtype;

    /**
     * Modalidade de negócio
     */
    @JsonProperty("businessType")
    public BusinessTypeDTO businessType;

    /**
     * Data e hora da criação da abertura da oportunidade
     */
    @JsonProperty("dateTime")
    public String dateTime;

    /**
     * Origem da oportunidade
     */
    @JsonProperty("opportunityOrigin")
    public OpportunityOriginDTO opportunityOrigin;

    /**
     * Responsável pela oportunidade
     */
    @JsonProperty("responsable")
    public ResponsibleDTO responsible;

    /**
     * Estágio da oportunidade
     */
    @JsonProperty("negotiationStage")
    public NegotiationStageDTO negotiationStage;

    /**
     * Motivo da perda da oportunidade
     */
    @JsonProperty("lossReason")
    public LossReasonDTO lossReason;

    /**
     * Motivo da venda da oportunidade
     */
    @JsonProperty("salesReasons")
    public SalesReasonsDTO salesReasons;

    /**
     * Probabilidade de fechamento da oportunidade
     */
    @JsonProperty("probability")
    public Long probability;

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
     * Data da previsão de fechamento da oportunidade
     */
    @JsonProperty("expectedClosingString")
    public String expectedClosingString;

    /**
     * Data efetiva do fechamento da oportunidade
     */
    @JsonProperty("effectiveClosingString")
    public String effectiveClosingString;

    /**
     * Data prevista para a entrega dos produtos
     */
    @JsonProperty("expectedDeliveryString")
    public String expectedDeliveryString;

    /**
     * Data efetiva para a entrega dos produtos
     */
    @JsonProperty("effectiveDeliveryString")
    public String effectiveDeliveryString;

    /**
     * Valor previsto da oportunidade
     */
    @JsonProperty("expectedValue")
    public Double expectedValue;

    /**
     * Valor fechado da oportunidade
     */
    @JsonProperty("effectiveClosingValue")
    public Double effectiveClosingValue;

    /**
     * Quantidade prevista para a oportunidade
     */
    @JsonProperty("expectedQuantity")
    public Double expectedQuantity;

    /**
     * Quantidade realizada para a oportunidade
     */
    @JsonProperty("achievedQuantity")
    public Double achievedQuantity;

    /**
     * Histórico de negociação da oportunidade
     */
    @JsonProperty("history")
    public String history;

    /**
     * Descrição da oportunidade
     */
    @JsonProperty("description")
    public String description;

    /**
     * Se notifica por email a criação da oportunidade e demais interações
     */
    @JsonProperty("notifyEmail")
    public Boolean notifyEmail;

    /**
     * Campos customizados
     */
    @JsonProperty("customFields")
    public String customFields;
}
