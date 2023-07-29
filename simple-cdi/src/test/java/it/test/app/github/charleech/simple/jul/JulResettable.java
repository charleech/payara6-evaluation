package it.test.app.github.charleech.simple.jul;

import java.io.Serializable;

/**
 * <p>
 * This is an interface which provides the feature for resetting the
 * {@code Java: utility logging framework (JUL)}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see Serializable
 */
public interface JulResettable extends Serializable {

    /**
     * <p>
     * This is an interface which describes the feature for building the final
     * product as resetting the {@code JUL}.
     * </p>
     *
     * @author charlee.ch
     * @version 1.1.0
     * @since 1.0.0
     */
    interface Product extends Serializable {

        /**
         * Build the final product as resetting the {@code JUL}.
         *
         * @param julLogWrapper The {@link JulLogWrappable}
         * @since 1.0.0
         */
        void reset(JulLogWrappable julLogWrapper);
    }

    /**
     * Set to use the default resetting resource as
     * {@code src/test/resources/arquillian/gf/gf-log.properties}.
     *
     * @return The next builder as {@link Product}
     * @since 1.0.0
     */
    Product withDefaultResource();

    /**
     * Set the resetting resource.
     *
     * @param settingJulProperty
     *            The setting resetting resource
     * @return The next builder as {@link Product}
     * @since 1.0.0
     */
    Product withResource(String settingJulProperty);

}
