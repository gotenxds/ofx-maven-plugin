package org.ofx.mavenPlugin.screenEnumGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class ScreensFinder
{
    public Stream<Path> getScreensFrom(Path porjectPath)
    {
        try
        {
            return Files.walk(getFxmlDir(porjectPath));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Path getFxmlDir(Path projectPath)
    {
        try
        {
            return Files.find(projectPath, 10, (path, basicFileAttributes) -> basicFileAttributes.isDirectory() && path.endsWith("fxml"))
                        .findAny()
                        .get();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not find the fxml directory.");
        }
    }
}
