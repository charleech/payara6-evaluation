package it.test.app.github.charleech.simple.jul;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * This is a concrete implementing class which provides the feature described at
 * {@link JulLogWrappable}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see JulLogWrappable
 */
@Slf4j
public class JulLogWrapper implements JulLogWrappable {

    /**
     * This is a default serial version {@code UID} as {@value}.
     *
     * @since 1.0.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * This is a self instance which represents and implements the singleton
     * pattern.
     * </p>
     *
     * @since 1.0.0
     */
    @Getter(value = AccessLevel.PUBLIC)
    private static final JulLogWrappable INSTANCE;

    static {
        INSTANCE = new JulLogWrapper();
    }

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
    protected JulLogWrapper() {
    }

    @Override
    public synchronized void reset(final String resource) throws IOException {
        File log = null;
        JulLogWrapper.log.info(
            "The resetting properties is {}",
            resource
        );

        log = new File(resource);
        this.reset(log);
    }

    @Override
    public synchronized void reset(final File resource) throws IOException {
        try (InputStream ins = this.toInputStream(resource)) {
            this.reset(ins);
        }
    }

    @Override
    public synchronized void reset(final InputStream resource)
                             throws IOException {
        LogManager manager = null;

        manager = this.getJulLogManager();

        manager.readConfiguration(resource);

    }

    /**
     * Convert to {@link FileInputStream}.
     *
     * @param resource
     *            The converting source
     * @return The converted
     * @throws FileNotFoundException
     *             If there is any error.
     * @since 1.0.0
     */
    protected FileInputStream toInputStream(final File resource)
                              throws FileNotFoundException {
        return new FileInputStream(resource);
    }

    /**
     * Get the {@code JUL}: {@link LogManager}.
     *
     * @return The {@link LogManager}
     * @since 1.0.0
     */
    protected LogManager getJulLogManager() {
        return LogManager.getLogManager();
    }

}
