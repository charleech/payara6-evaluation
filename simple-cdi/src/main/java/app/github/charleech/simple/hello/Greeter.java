package app.github.charleech.simple.hello;

import jakarta.enterprise.context.ApplicationScoped;

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
public class Greeter implements Greetable {

    /**
     * This is a default serial version {@code UID} as {@value}.
     *
     * @since 1.0.0
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String greet(final String name) {
        return "Hello " + name;
    }

}
