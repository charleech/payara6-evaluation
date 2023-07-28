package it.test.app.github.charleech.simple;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

/**
 * <p>
 * This is an annotation which combines two {@code JUnit 5: Extension} for
 * integration testing.
 * </p>
 *
 * @author charlee.ch
 * @version 1.1.0
 * @since 1.1.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.TYPE,
    ElementType.METHOD
})
@ExtendWith({
    SystemStubsExtension.class,
    ArquillianExtension.class,
    MockitoExtension.class
})
@MockitoSettings(strictness = Strictness.LENIENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public @interface IntegrationTestExtension {

}
