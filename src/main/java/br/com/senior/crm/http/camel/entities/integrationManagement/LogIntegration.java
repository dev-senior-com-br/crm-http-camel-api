package br.com.senior.crm.http.camel.entities.integrationManagement;

import br.com.senior.crm.http.camel.entities.ErrorResponseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogIntegration extends ErrorResponseEntity {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(LogIntegration.class);

    @JsonProperty("id")
    private String id;

    @JsonProperty("integration")
    private String integration;

    @JsonProperty("payloadSent")
    private String payloadSent;

    @JsonProperty("payloadReceived")
    private String payloadReceived;

    @JsonProperty("statusCode")
    private Long statusCode;

    @JsonProperty("usuger")
    private String usuger;

    @JsonProperty("dthger")
    private String dthger;

    @JsonProperty("usualt")
    private String usualt;

    @JsonProperty("dthalt")
    private String dthalt;
}