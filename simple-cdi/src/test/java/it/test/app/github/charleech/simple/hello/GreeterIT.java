package it.test.app.github.charleech.simple.hello;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import app.github.charleech.simple.hello.Greetable;
import it.test.app.github.charleech.simple.IntegrationTestExtension;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
class GreeterIT {

    /**
     * This is  variable which represents the {@link Greetable}.
     *
     * @since 1.0.0
     */
    @Inject
    private Greetable greeter;

    /**
     * This is a success test case when greeting.
     *
     * @since 1.0.0
     */
    @Test
    @Order(1)
    @DisplayName(
        "When greeting by Jakarta EE should be success."
    )
    void whenGreet() {
        String expected = null;
        String actual   = null;

        GreeterIT.log.info("===> whenGreet");

        expected = "Hello JUnit";

        actual   = this.greeter.greet("JUnit");

        BDDAssertions.then(actual).
            as("The greeting must be valid.").
            isNotNull().
            isNotEmpty().
            isEqualTo(expected);
    }

    /**
     * This is a failure test case when greeting.
     *
     * @since 1.0.0
     */
    @Test
    @Order(2)
    @DisplayName(
        "When greeting as failure by Jakarta EE should be failed."
    )
    void whenGreetAsFailure() {
        String expected = null;
        String actual   = null;

        GreeterIT.log.info("===> whenGreetAsFailure");

        expected = "Hello JUnit";

        actual   = this.greeter.greet("UNKNOWN");

        BDDAssertions.then(actual).
            as("The greeting must be valid.").
            isNotNull().
            isNotEmpty().
            isEqualTo(expected);
    }
}
