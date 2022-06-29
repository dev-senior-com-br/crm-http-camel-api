package br.com.senior.crm.http.camel.entities.opportunity.collections;

import br.com.senior.crm.http.camel.entities.opportunity.OpportunityProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.component.jackson.JacksonDataFormat;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RegisterForReflection(serialization = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpportunityProductCollection {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(OpportunityProductCollection.class);

    @JsonProperty("products")
    private List<OpportunityProduct> products = new ArrayList<>();
}