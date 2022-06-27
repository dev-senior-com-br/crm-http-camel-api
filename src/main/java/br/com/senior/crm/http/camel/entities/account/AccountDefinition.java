package br.com.senior.crm.http.camel.entities.account;

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
 * Entidade referente
 * a definição da conta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDefinition {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountDefinition.class);

    /**
     * Código de identificação
     */
    @JsonProperty("id")
    public Long id;

    /**
     * Empresa Filial da definição da conta
     */
    @JsonProperty("companyBranch")
    public CompanyBranchDTO companyBranch;

    /**
     * A conta da definição
     */
    @JsonProperty("account")
    public BasicAccountDTO account;

    /**
     * Status da definição da conta,
     */
    @JsonProperty("status")
    public StatusDTO status;

    /**
     * Motivo da inativação da definição da conta
     */
    @JsonProperty("inactivationReason")
    public InactivationReasonDTO inactivationReason;

    /**
     * Tipo de conta
     */
    @JsonProperty("accountType")
    public AccountTypeDTO accountType;

    /**
     * Rating da conta por definição
     */
    @JsonProperty("rating")
    public RatingDTO rating;

    /**
     * Tabela de preço padrão para a definição de conta
     */
    @JsonProperty("priceTable")
    public PriceTableDTO priceTable;

    /**
     * Transportadora padrão para a definição de conta
     */
    @JsonProperty("carrier")
    public CarrierDTO carrier;

    /**
     * Transportadora de redespacho padrão para a definição de conta
     */
    @JsonProperty("carrierDispatch")
    public CarrierDispatchDTO carrierDispatch;

    /**
     * Representante padrão para a definição de conta
     */
    @JsonProperty("representative")
    public RepresentativeDTO representative;

    /**
     * Vendedor padrão para a definição de conta
     */
    @JsonProperty("seller")
    public SellerDTO seller;

    /**
     * Prazo de pagamento padrão para a definição de conta
     */
    @JsonProperty("paymentTerm")
    public PaymentTermDTO paymentTerm;

    /**
     * Previsão de meta de vendas para o cliente
     */
    @JsonProperty("salesGoal")
    public Double salesGoal;

    /**
     * Observações da definição de conta
     */
    @JsonProperty("note")
    public String note;

    /**
     * Informa se a conta por definição recebe emails do sistema
     */
    @JsonProperty("receiveEmail")
    public Boolean receiveEmail;

    /**
     * Informa se a conta por definição recebe pesquisas do sistema
     */
    @JsonProperty("receiveSurvey")
    public Boolean receiveSurvey;

    /**
     * Informa se a conta por definição recebe e monitora emails do sistema
     */
    @JsonProperty("receiveTrackEmail")
    public Boolean receiveTrackEmail;

    /**
     * Data de quando a conta virou cliente
     */
    @JsonProperty("clientSince")
    public String clientSince;

    /**
     * Campos customizados desse cadastro
     */
    @JsonProperty("customFields")
    public String customFields;
}
