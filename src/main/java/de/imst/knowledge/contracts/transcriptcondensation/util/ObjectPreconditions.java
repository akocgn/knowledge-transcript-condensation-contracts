package de.imst.knowledge.contracts.transcriptcondensation.util;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * A static utility class that provides methods for checking preconditions on objects, such as null checks.
 */
public final class ObjectPreconditions {
    private ObjectPreconditions() {
        // Private constructor to prevent instantiation
    }

    /**
     * Checks that the provided object is not null. If it is null, an IllegalArgumentException is thrown with the given message.
     *
     * @param obj     the object to check for nullity
     * @param message the error message to include in the exception if the object is null
     * @throws IllegalArgumentException if the object is null
     */
    public static <T> T assertNotNull(@Nullable T obj, @Nonnull String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
        return obj;
    }
}
