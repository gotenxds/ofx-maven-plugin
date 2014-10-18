package org.ofx.mavenPlugin.screenEnumGenerator.screenEnumTemplate;

import java.util.Map;

public class ScreenEnumsFactory
{
    public String createFullFileFrom(String packageName, Map<String, String> enumData)
    {
        String template = getTemplate();

        String enums = createEnumsString(enumData);

        return String.format(template, packageName, enums);
    }

    private String getTemplate()
    {
        return new ScreenEnumTemplateTextSupplier().get();
    }

    private String createEnumsString(Map<String, String> enumData)
    {
        StringBuilder stringBuilder = new StringBuilder();

        enumData.forEach((name, path) ->
                stringBuilder
                .append(name)
                .append("(\"")
                .append(name)
                .append(" Screen \", \"")
                .append(path.replace('\\', '.'))
                .append("\"),\n"));

        stringBuilder.setCharAt(stringBuilder.length() - 2, ';');

        return stringBuilder.toString();
    }
}
