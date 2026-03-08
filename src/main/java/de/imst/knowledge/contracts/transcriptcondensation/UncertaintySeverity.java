package de.imst.knowledge.contracts.transcriptcondensation;

/**
 * Represents the severity level of a transcript uncertainty.
 */
public enum UncertaintySeverity {
    /**
     * Indicates a low level of uncertainty, where the information is likely to be correct but there is some doubt.
     */
    LOW,
    /**
     * Indicates a medium level of uncertainty, where the information is somewhat questionable and should be treated with caution.
     */
    MEDIUM,
    /**
     * Indicates a high level of uncertainty, where the information is likely to be incorrect and should be treated with skepticism.
     */
    HIGH
}

