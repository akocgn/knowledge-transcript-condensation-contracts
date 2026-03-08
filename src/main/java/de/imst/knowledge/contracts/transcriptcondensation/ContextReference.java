package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Represents a reference to a known context entity (e.g. a character, location or item)
 * found within a transcript segment.
 */
public class ContextReference {

    @JsonProperty("referenceType")
    @Nonnull
    private ContextReferenceType referenceType;

    @JsonProperty("referenceKey")
    @Nonnull
    private String referenceKey;

    @JsonProperty("displayText")
    @Nullable
    private String displayText;

    @JsonProperty("confidence")
    @Nullable
    private Double confidence;

    public ContextReference() {
    }

    public ContextReference(
            @Nonnull final ContextReferenceType referenceType,
            @Nonnull final String referenceKey,
            @Nullable final String displayText,
            @Nullable final Double confidence) {
        this.referenceType = referenceType;
        this.referenceKey = referenceKey;
        this.displayText = displayText;
        this.confidence = confidence;
    }

    @Nonnull
    public ContextReferenceType getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(@Nonnull final ContextReferenceType referenceType) {
        this.referenceType = referenceType;
    }

    @Nonnull
    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(@Nonnull final String referenceKey) {
        this.referenceKey = referenceKey;
    }

    @Nullable
    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(@Nullable final String displayText) {
        this.displayText = displayText;
    }

    @Nullable
    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(@Nullable final Double confidence) {
        this.confidence = confidence;
    }
}

