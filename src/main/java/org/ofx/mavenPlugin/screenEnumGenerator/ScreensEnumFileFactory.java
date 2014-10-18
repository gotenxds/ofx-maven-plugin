package org.ofx.mavenPlugin.screenEnumGenerator;

import org.ofx.mavenPlugin.screenEnumGenerator.screenEnumTemplate.ScreenEnumsFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ScreensEnumFileFactory
{
    public String createFrom(String outputPackage, PathRelativizer pathRelativizer, Stream<Path> screens)
    {
        Map<String, String> enumData = createEnumMap(pathRelativizer, screens);

        return new ScreenEnumsFactory().createFullFileFrom(outputPackage, enumData);
    }

    private Map<String, String> createEnumMap(PathRelativizer pathRelativizer, Stream<Path> screens)
    {
        Function<String, String> trimFileType = s -> s.split(".fxml")[0];
        Function<Path, String> getFileName = p -> p.getFileName().toString();

        return screens.filter(Files::isRegularFile)
                      .collect(Collectors.toMap(getFileName.andThen(trimFileType), pathRelativizer.andThen(trimFileType)));
    }
}

