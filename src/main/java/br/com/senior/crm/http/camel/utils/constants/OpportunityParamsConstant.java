package br.com.senior.crm.http.camel.utils.constants;

import java.util.List;

public class OpportunityParamsConstant extends ErpParamsConstant {

    public static final String PROPOSAL_STATUS = "Proposal-Status";
    public static final String OPPORTUNITY_STAGE = "Opportunity-Stage";

    public static final List<String> PARAMS = List.of(
        BASE_URL_ERP,
        USERNAME_ERP,
        PASSWORD_ERP,
        CONNECTION_ERP,
        PROPOSAL_STATUS,
        OPPORTUNITY_STAGE
    );
}
