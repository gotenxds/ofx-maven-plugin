package org.ofx.mavenPlugin.screenEnumGenerator;

import java.nio.file.Path;
import java.util.function.Function;

public class PathRelativizer implements Function<Path, String>
{
    private final Path fxmlPath;

    PathRelativizer(Path fxmlPath)
    {
        this.fxmlPath = fxmlPath;
    }

    @Override
    public String apply(Path path)
    {
        return fxmlPath.relativize(path).toString();
    }
}

