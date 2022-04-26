package br.com.senior.crm.http.camel.utils.contants;

import java.util.List;

public class AccountParamsConstant extends ErpParamsConstant
{
    public final static String TYPE_ACCOUNT   = "Type-Account";
    public final static String ACTION_REMOVE = "Action-Remove";
    public final static String FIELDS_ACCOUNT = "Fields-Account";
    public final static String FIELDS_ADDRESS = "Fields-Address";
    public final static String FIELDS_PHONE   = "Fields-Phone";
    public final static String FIELDS_CONTACT = "Fields-Contact";

    public final static List<String> PARAMS = List.of(
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
