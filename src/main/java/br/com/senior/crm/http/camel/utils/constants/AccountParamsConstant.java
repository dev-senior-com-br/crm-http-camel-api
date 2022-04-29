package br.com.senior.crm.http.camel.utils.constants;

import java.util.List;

public class AccountParamsConstant extends ErpParamsConstant {

    public static final String TYPE_ACCOUNT   = "Type-Account";
    public static final String ACTION_REMOVE = "Action-Remove";
    public static final String FIELDS_ACCOUNT = "Fields-Account";
    public static final String FIELDS_ADDRESS = "Fields-Address";
    public static final String FIELDS_PHONE   = "Fields-Phone";
    public static final String FIELDS_CONTACT = "Fields-Contact";

    public static final List<String> PARAMS = List.of(
        BASE_URL_ERP,
        USERNAME_ERP,
        PASSWORD_ERP,
        TYPE_ACCOUNT,
        ACTION_REMOVE,
        FIELDS_ACCOUNT,
        FIELDS_ADDRESS,
        FIELDS_PHONE,
        FIELDS_CONTACT
    );
}
