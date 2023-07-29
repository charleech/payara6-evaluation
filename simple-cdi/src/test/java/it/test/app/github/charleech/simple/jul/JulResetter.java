package it.test.app.github.charleech.simple.jul;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described at
 * {@link JulResettable}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see JulResettable
 * @see JulResettable.Product
 */
public class JulResetter
  implements JulResettable,
             JulResettable.Product {

    /**
     * This is a default serial version {@code UID} as {@value}.
     *
     * @since 1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * This is a default resetting resource as {@value}.
     *
     * @since 1.0.0
     */
    @Getter(value = AccessLevel.PUBLIC)
    private static final String DEFAULT_RESOURCE = "src/test/resources"
                                                 + "/logging.properties";
    /**
     * This is a variable which represents the {@code resetting-resource}.
     *
     * @since 1.0.0
     */
    private String resource;

    /**
     * <p>
     * This is a default constructor.
     * </p>
     * <p>
     * It is a private accessor with purpose to prevent to be instantiated by
     * other with purpose to ensure the {@code singleton-pattern}.
     * </p>
     *
     * @since 1.0.0
     */
    private JulResetter() {
    }

    /**
     * Get the {@code builder} as a {@link JulResettable}.
     *
     * @return The {@code builder} as a {@link JulResettable}
     * @since 1.0.0
     */
    public static final JulResettable builder() {
        return new JulResetter();
    }

    @Override
    public void reset(final JulLogWrappable julLogWrapper) {
        try {

            julLogWrapper.reset(this.resource);

        } catch (final IOException e) {

            throw new IllegalStateException(
                "Cannot set customized JUL logging.",
                e
            );
        }
    }

    @Override
    public Product withDefaultResource() {
        this.withResource(JulResetter.DEFAULT_RESOURCE);
        return this;
    }

    @Override
    public Product withResource(final String settingJulProperty) {
        this.resource = settingJulProperty;

        return this;
    }

}
