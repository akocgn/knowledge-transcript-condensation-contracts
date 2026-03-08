package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.imst.knowledge.contracts.transcriptcondensation.util.ObjectPreconditions;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Represents an uncertainty detected within a transcript or one of its segments.
 */
public class TranscriptUncertainty {

    @JsonProperty("type")
    @Nonnull
    private TranscriptUncertaintyType type;

    @JsonProperty("message")
    @Nullable
    private String message;

    @JsonProperty("severity")
    @Nonnull
    private UncertaintySeverity severity;

    public TranscriptUncertainty(
            @Nonnull final TranscriptUncertaintyType type,
            @Nullable final String message,
            @Nonnull final UncertaintySeverity severity) {
        ObjectPreconditions.assertNotNull(type, "type must not be null");
        ObjectPreconditions.assertNotNull(severity, "severity must not be null");
        this.type = type;
        this.message = message;
        this.severity = severity;
    }

    @Nonnull
    public TranscriptUncertaintyType getType() {
        return type;
    }

    public void setType(@Nonnull final TranscriptUncertaintyType type) {
        this.type = type;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    public void setMessage(@Nullable final String message) {
        this.message = message;
    }

    @Nonnull
    public UncertaintySeverity getSeverity() {
        return severity;
    }

    public void setSeverity(@Nonnull final UncertaintySeverity severity) {
        this.severity = severity;
    }
}

