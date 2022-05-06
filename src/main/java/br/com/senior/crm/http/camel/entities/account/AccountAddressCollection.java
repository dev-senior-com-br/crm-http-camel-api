package br.com.senior.crm.http.camel.entities.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAddressCollection {
    
    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(AccountPhone.class);

    @JsonProperty("addresses")
    public List<AccountAddress> addresses;
}
