package br.com.senior.crm.http.camel.dtos;

import br.com.senior.crm.http.camel.dtos.enums.ComparatorEnum;
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
public class FilterQueryDTO {

    public static final JacksonDataFormat JACKSON_DATA_FORMAT = new JacksonDataFormat(FilterQueryDTO.class);

    @JsonProperty("comparator")
    private ComparatorEnum comparator;

    @JsonProperty("value")
    private String value;
}