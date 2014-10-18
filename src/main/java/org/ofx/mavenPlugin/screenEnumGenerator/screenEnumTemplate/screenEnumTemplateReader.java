package org.ofx.mavenPlugin.screenEnumGenerator.screenEnumTemplate;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

class ScreenEnumTemplateReader
{
    public String read()
    {
        try
        {
            return Resources.toString(Resources.getResource("screenEnumTemplate"), Charsets.UTF_8);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
