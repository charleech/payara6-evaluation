package it.test.app.github.charleech.simple;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

/**
 * <p>
 * This is a concrete implementing class which provides the feature for
 * supporting the {@code JBoss: Arquillian - TestSuite}, the single deployment
 * across all {@code JUnit: TestSuite}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 */
@ArquillianSuiteDeployment
public class ArquillianSuiteDeployments {

    /**
     * Create the {@code JBoss: Arquillian} archive for testing.
     *
     * @return The {@code JBoss: Arquillian} archive for testing
     * @throws IOException
     *             If there is any error during loading resource
     */
    @Deployment(
        name = "simple-cdi"
    )
    public static WebArchive createDeployment() throws IOException {
        return ShrinkWrap.create(
            WebArchive.class,
            "myweb.war"
        ).
        addPackages(
            true,
            "app.github.charleech.simple"
            ).
        addPackages(
            true,
            "it.test.app.github.charleech.simple"
        ).
        addAsWebInfResource(
            EmptyAsset.INSTANCE,
            "beans.xml"
        ).
        addAsLibraries(ArquillianSuiteDeployments.getDependencies());
    }

    /**
     * Get required dependencies as file.
     *
     * @return The files
     * @since 1.0.0
     */
    protected static File[] getDependencies() {
        return Maven.resolver().
               resolve(ArquillianSuiteDeployments.getGAVs()).
               withTransitivity().
               asFile();
    }

    /**
     * Get required dependencies as Maven Coordinates.
     *
     * @return The Maven Coordinates
     * @since 1.0.0
     */
    private static String[] getGAVs() {
        List<String> gavs;

        gavs = new ArrayList<>();

        ArquillianSuiteDeployments.readDependenciesProps().entrySet().forEach(
            e -> gavs.add(String.valueOf(e.getValue()))
        );

        return gavs.toArray(new String[]{});
    }

    /**
     * Get required dependencies from properties.
     *
     * @return The loaded properties
     * @since 1.0.0
     */
    private static Properties readDependenciesProps() {
        Properties props = null;

        try {
            props = new Properties();
            props.load(
                ArquillianSuiteDeployments.class.getResourceAsStream(
                    "/dependencies.properties"
                )
            );
            return props;
        } catch (final IOException e) {
            throw new IllegalStateException(
                "Cannot load properties.",
                e
            );
        }
    }
}
