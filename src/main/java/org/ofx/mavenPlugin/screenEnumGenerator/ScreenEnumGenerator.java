package org.ofx.mavenPlugin.screenEnumGenerator;

import com.google.common.collect.Lists;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Mojo(name = "generateScreensEnum")
public class ScreenEnumGenerator extends AbstractMojo
{
    @Parameter(property = "project")
    private MavenProject project;

    @Parameter(property = "generateScreensEnum.outputPackage")
    private String outputPackage;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException
    {
        Path projectPath = project.getBasedir().toPath();
        ScreensFinder screensFinder = new ScreensFinder();

        Stream<Path> screens = screensFinder.getScreensFrom(projectPath);

        Path savePath = Paths.get(project.getBuild().getSourceDirectory()).resolve(outputPackage.replace(".", "\\") + "\\Screens.java");

        String screesEnumFile = new ScreensEnumFileFactory().createFrom(outputPackage, new PathRelativizer(screensFinder.getFxmlDir(projectPath)), screens);

        new FileTruncator().writeFile(savePath, Lists.newArrayList(screesEnumFile));
    }
}
