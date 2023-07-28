package it.test.app.github.charleech.simple;

import java.io.IOException;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

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
        );
    }

}
