package org.ofx.mavenPlugin.screenEnumGenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileTruncator
{
    public void writeFile(Path enumLocation, Iterable<? extends CharSequence> lines)
    {
        try
        {
            Files.write(enumLocation, lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

