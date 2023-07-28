package app.github.charleech.simple.hello;

import java.io.Serializable;

/**
 * <p>
 * This is an interface which describes the feature to greet.
 * It is a {@code CDI: ApplicationScoped} bean.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see Serializable
 */
public interface Greetable extends Serializable {

    /**
     * Greet to the {@code name}.
     *
     * @param name The greeting name.
     * @return The greeting message.
     * @since 1.0.0
     */
    String greet(String name);

}
