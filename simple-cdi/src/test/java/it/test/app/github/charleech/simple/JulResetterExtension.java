package it.test.app.github.charleech.simple;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import it.test.app.github.charleech.simple.jul.JulLogWrappable;
import it.test.app.github.charleech.simple.jul.JulLogWrapper;
import it.test.app.github.charleech.simple.jul.JulResetter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * This is a concrete implementing class which provides the feature to reset the
 * {@code Java Util Logger}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see BeforeAllCallback
 */
public class JulResetterExtension
  implements BeforeAllCallback,
             BeforeEachCallback {

    /**
     * This is a constant which represents the {@link JulLogWrappable}.
     *
     * @since 1.0.0
     */
    private static final JulLogWrappable LOG_WRAPPER;

    static {
        LOG_WRAPPER = JulLogWrapper.getINSTANCE();
    }

    /**
     * Create a builder to build this extension.
     *
     * @return The builder
     * @since 1.0.0
     */
    public static Builder builder() {
        return new JulResetterExtension.JulResetterExtensionBuilder();
    }

    /**
     * This is a variable which represent the flag to identifies if it is done
     * already or not.
     *
     * @since 1.0.0
     */
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private boolean done;

    /**
     * This is a variable which represents the {@code JUL properties file}.
     *
     * @since 1.0.0
     */
    private final String julConfig;

    /**
     * This is constructor which creates this extension with default value.
     *
     * @since 1.0.0
     * @see JulResetter
     */
    public JulResetterExtension() {
        this(JulResetter.getDEFAULT_RESOURCE());
    }

    /**
     * This is a constructor which create this extenstion with the specifying
     * {@code JUL properties file}.
     *
     * @param settingJulConfig The {@code JUL properties file}
     * @since 1.0.0
     */
    public JulResetterExtension(final String settingJulConfig) {
        this.julConfig = settingJulConfig;
    }

    @Override
    public void beforeAll(final ExtensionContext context) throws Exception {

        if (this.isDone()) {
            return;
        }

        JulResetter.builder().
            withResource(this.julConfig).
            reset(JulResetterExtension.LOG_WRAPPER);

        this.setDone(true);
    }

    @Override
    public void beforeEach(final ExtensionContext context) throws Exception {
        this.beforeAll(context);
    }

    /**
     * This is a concrete implementing class which provides the feature
     * described at {@link Builder}.
     *
     * @since 1.0.0
     * @see Builder
     */
    static class JulResetterExtensionBuilder implements Builder {

        /**
         * This is a variable which represents the building
         * {@code JUL properties file}.
         *
         * @since 1.0.0
         */
        private String config;

        @Override
        public JulResetterExtension build() {
            return new JulResetterExtension(this.config);
        }

        @Override
        public Builder withJulConfiguration(final String settingJulConfig) {
            this.config = settingJulConfig;
            return this;
        }

    }

    /**
     * This is an interface which describes the feature for building the
     * {@link JulResetterExtension}.
     *
     * @since 1.0.0
     * @see JulResetterExtension
     */
    public interface Builder {

        /**
         * Build the final product as {@link JulResetterExtension}.
         *
         * @return The {@link JulResetterExtension}
         * @since 1.0.0
         */
        JulResetterExtension build();

        /**
         * Set the {@code JUL properties file}.
         *
         * @param settingJulConfig
         *            The setting {@code JUL properties file}
         * @return Self instance for receiving next parameters.
         * @since 1.0.0
         */
        Builder withJulConfiguration(String settingJulConfig);
    }

}
