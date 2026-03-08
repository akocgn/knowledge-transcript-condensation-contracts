package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.imst.knowledge.contracts.transcriptcondensation.util.ObjectPreconditions;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Metadata about a readable transcript describing its origin and processing characteristics.
 */
public class ReadableTranscriptMetadata {

    @JsonProperty("sourceType")
    @Nonnull
    private TranscriptSourceType sourceType;

    @JsonProperty("hasSpeakerIdentification")
    private boolean hasSpeakerIdentification;

    @JsonProperty("hasSceneDetection")
    private boolean hasSceneDetection;

    @JsonProperty("processingVersion")
    @Nullable
    private String processingVersion;

    @JsonProperty("containsContextEnrichment")
    private boolean containsContextEnrichment;

    public ReadableTranscriptMetadata(
            @Nonnull final TranscriptSourceType sourceType,
            final boolean hasSpeakerIdentification,
            final boolean hasSceneDetection,
            @Nullable final String processingVersion,
            final boolean containsContextEnrichment) {
        this.sourceType = ObjectPreconditions.assertNotNull(sourceType, "sourceType must not be null");
        this.processingVersion = processingVersion;
        this.hasSpeakerIdentification = hasSpeakerIdentification;
        this.hasSceneDetection = hasSceneDetection;
        this.containsContextEnrichment = containsContextEnrichment;
    }

    @Nonnull
    public TranscriptSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(@Nonnull final TranscriptSourceType sourceType) {
        this.sourceType = sourceType;
    }

    public boolean isHasSpeakerIdentification() {
        return hasSpeakerIdentification;
    }

    public void setHasSpeakerIdentification(final boolean hasSpeakerIdentification) {
        this.hasSpeakerIdentification = hasSpeakerIdentification;
    }

    public boolean isHasSceneDetection() {
        return hasSceneDetection;
    }

    public void setHasSceneDetection(final boolean hasSceneDetection) {
        this.hasSceneDetection = hasSceneDetection;
    }

    @Nullable
    public String getProcessingVersion() {
        return processingVersion;
    }

    public void setProcessingVersion(@Nullable final String processingVersion) {
        this.processingVersion = processingVersion;
    }

    public boolean isContainsContextEnrichment() {
        return containsContextEnrichment;
    }

    public void setContainsContextEnrichment(final boolean containsContextEnrichment) {
        this.containsContextEnrichment = containsContextEnrichment;
    }
}

