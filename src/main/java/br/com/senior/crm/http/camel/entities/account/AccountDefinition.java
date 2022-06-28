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
    private Long id;

    /**
     * Empresa Filial da definição da conta
     */
    @JsonProperty("companyBranch")
    private CompanyBranchDTO companyBranch;

    /**
     * A conta da definição
     */
    @JsonProperty("account")
    private BasicAccountDTO account;

    /**
     * Status da definição da conta,
     */
    @JsonProperty("status")
    private StatusDTO status;

    /**
     * Motivo da inativação da definição da conta
     */
    @JsonProperty("inactivationReason")
    private InactivationReasonDTO inactivationReason;

    /**
     * Tipo de conta
     */
    @JsonProperty("accountType")
    private AccountTypeDTO accountType;

    /**
     * Rating da conta por definição
     */
    @JsonProperty("rating")
    private RatingDTO rating;

    /**
     * Tabela de preço padrão para a definição de conta
     */
    @JsonProperty("priceTable")
    private PriceTableDTO priceTable;

    /**
     * Transportadora padrão para a definição de conta
     */
    @JsonProperty("carrier")
    private CarrierDTO carrier;

    /**
     * Transportadora de redespacho padrão para a definição de conta
     */
    @JsonProperty("carrierDispatch")
    private CarrierDispatchDTO carrierDispatch;

    /**
     * Representante padrão para a definição de conta
     */
    @JsonProperty("representative")
    private RepresentativeDTO representative;

    /**
     * Vendedor padrão para a definição de conta
     */
    @JsonProperty("seller")
    private SellerDTO seller;

    /**
     * Prazo de pagamento padrão para a definição de conta
     */
    @JsonProperty("paymentTerm")
    private PaymentTermDTO paymentTerm;

    /**
     * Previsão de meta de vendas para o cliente
     */
    @JsonProperty("salesGoal")
    private Double salesGoal;

    /**
     * Observações da definição de conta
     */
    @JsonProperty("note")
    private String note;

    /**
     * Informa se a conta por definição recebe emails do sistema
     */
    @JsonProperty("receiveEmail")
    private Boolean receiveEmail;

    /**
     * Informa se a conta por definição recebe pesquisas do sistema
     */
    @JsonProperty("receiveSurvey")
    private Boolean receiveSurvey;

    /**
     * Informa se a conta por definição recebe e monitora emails do sistema
     */
    @JsonProperty("receiveTrackEmail")
    private Boolean receiveTrackEmail;

    /**
     * Data de quando a conta virou cliente
     */
    @JsonProperty("clientSince")
    private String clientSince;

    /**
     * Campos customizados desse cadastro
     */
    @JsonProperty("customFields")
    private String customFields;
}
