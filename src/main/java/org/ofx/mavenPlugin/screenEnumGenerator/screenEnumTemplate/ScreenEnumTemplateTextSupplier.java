package org.ofx.mavenPlugin.screenEnumGenerator.screenEnumTemplate;

import java.util.Optional;
import java.util.function.Supplier;

public class ScreenEnumTemplateTextSupplier implements Supplier<String>
{
    private Optional<String> templateTextOptional = Optional.empty();

    @Override
    public String get()
    {
        if (!templateTextOptional.isPresent())
        {
            templateTextOptional = Optional.of(new ScreenEnumTemplateReader().read());
        }

        return templateTextOptional.get();
    }
}
