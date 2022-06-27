package br.com.senior.crm.http.camel.services.impl;

import br.com.senior.crm.http.camel.services.ValidateSettings.ValidateSettingsInterface;
import br.com.senior.crm.http.camel.utils.enums.ValidateSettingsDirectEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class ValidateSettings {
    @NonNull
    private RouteBuilder builder;
    private final String id = UUID.randomUUID().toString();
    @Getter
    private final String directImpl = "direct:crm-validate-settings-impl-".concat(id);
    @Getter
    private final String directResponse = "direct:crm-validate-settings-response-".concat(id);

    public void prepare(String classValidateSettings, ValidateSettingsDirectEnum directValidateSettings) throws Exception {
        Class<?> c;

        try {
            c = Class.forName(classValidateSettings);
        } catch (Exception e) {
            throw new Exception(String.format("Class ValidatorSettings %s not found", classValidateSettings));
        }

        ValidateSettingsInterface validateSettings;

        try {
            validateSettings = (ValidateSettingsInterface) c.newInstance();
        } catch (Exception e) {
            throw new Exception(String.format("Class ValidatorSettings %s not implemented interface %s", classValidateSettings, ValidateSettingsInterface.class));
        }

        validateSettings.prepare();

        builder
            .from(directImpl)
            .to(directValidateSettings.getValue())
        ;

        builder
            .from(validateSettings.getDirectResponse())
            .to(directResponse)
        ;
    }
}
