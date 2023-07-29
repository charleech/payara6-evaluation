package it.test.app.github.charleech.simple.jul;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * <p>
 * This is an interface which describes the feature for resetting the
 * {@code Java: Standard Logging}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see Serializable
 */
public interface JulLogWrappable extends Serializable {

    /**
     * Get the {@code Java: Standard Logging Manager}.
     *
     * @param resource
     *            The resetting resource
     * @throws IOException
     *             If the resource is not existed.
     * @since 1.0.0
     */
    void reset(String resource) throws IOException;

    /**
     * Get the {@code Java: Standard Logging Manager}.
     *
     * @param resource
     *            The resetting resource
     * @throws IOException
     *             If the resource is not existed.
     * @since 1.0.0
     */
    void reset(File resource) throws IOException;

    /**
     * Get the {@code Java: Standard Logging Manager}.
     *
     * @param resource
     *            The resetting resource
     * @throws IOException
     *             If the resource is not existed.
     * @since 1.0.0
     */
    void reset(InputStream resource) throws IOException;

}
