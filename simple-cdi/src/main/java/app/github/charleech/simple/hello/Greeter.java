package app.github.charleech.simple.hello;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described at
 * {@link Greetable}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 */
@ApplicationScoped
@Slf4j
public class Greeter implements Greetable {

    /**
     * This is a default serial version {@code UID} as {@value}.
     *
     * @since 1.0.0
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String greet(final String name) {
        Greeter.log.error("====> CDI 001");
        System.out.println("====> CDI 001");
        return "Hello " + name;
    }

}
