package it.test.app.github.charleech.simple.hello;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import app.github.charleech.simple.hello.Greetable;
import it.test.app.github.charleech.simple.IntegrationTestExtension;
import jakarta.inject.Inject;

/**
 * <p>
 * This is a concrete implementing class which provides the unit test for
 * testing the {@link Greetable}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 */

@IntegrationTestExtension
@DisplayName(
    "GreeterIT Integration Test"
)
class GreeterIT {

    /**
     * This is  variable which represents the {@link Greetable}.
     *
     * @since 1.0.0
     */
    @Inject
    private Greetable greeter;
    /**
     * This is a success test case when mocking the closed inputstream.
     *
     * @since 1.0.0
     */
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName(
        "When greeting by Jakarta EE should be success."
    )
    void whenGreet() {
        String expected = null;
        String actual   = null;

        expected = "Hello JUnit";

        actual   = this.greeter.greet("JUnit");

        BDDAssertions.then(actual).
            as("The greeting must be valid.").
            isNotNull().
            isNotEmpty().
            isEqualTo(expected);
    }
}
