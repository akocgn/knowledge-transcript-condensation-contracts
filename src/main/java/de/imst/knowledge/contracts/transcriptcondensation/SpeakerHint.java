package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.List;

/**
 * A hint about the speaker of a transcript segment. Deliberately named "hint" to reflect
 * that speaker attribution may be uncertain or derived heuristically.
 */
public class SpeakerHint {

    @JsonProperty("speakerType")
    @Nonnull
    private SpeakerType speakerType;

    @JsonProperty("displayName")
    @Nullable
    private String displayName;

    @JsonProperty("candidateReference")
    @Nullable
    private String candidateReference;

    @JsonProperty("confidence")
    @Nullable
    private Double confidence;

    @JsonProperty("reasonCodes")
    @Nullable
    private List<String> reasonCodes;

    public SpeakerHint() {
    }

    public SpeakerHint(
            @Nonnull final SpeakerType speakerType,
            @Nullable final String displayName,
            @Nullable final String candidateReference,
            @Nullable final Double confidence,
            @Nullable final List<String> reasonCodes) {
        this.speakerType = speakerType;
        this.displayName = displayName;
        this.candidateReference = candidateReference;
        this.confidence = confidence;
        this.reasonCodes = reasonCodes;
    }

    @Nonnull
    public SpeakerType getSpeakerType() {
        return speakerType;
    }

    public void setSpeakerType(@Nonnull final SpeakerType speakerType) {
        this.speakerType = speakerType;
    }

    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(@Nullable final String displayName) {
        this.displayName = displayName;
    }

    @Nullable
    public String getCandidateReference() {
        return candidateReference;
    }

    public void setCandidateReference(@Nullable final String candidateReference) {
        this.candidateReference = candidateReference;
    }

    @Nullable
    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(@Nullable final Double confidence) {
        this.confidence = confidence;
    }

    @Nullable
    public List<String> getReasonCodes() {
        return reasonCodes;
    }

    public void setReasonCodes(@Nullable final List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
    }
}

