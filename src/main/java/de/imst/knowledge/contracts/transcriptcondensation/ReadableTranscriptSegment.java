package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.imst.knowledge.contracts.transcriptcondensation.util.ObjectPreconditions;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.util.List;

/**
 * The primary unit of a readable transcript. Represents a single, ordered speech or text segment
 * with optional speaker attribution, scene association, context references and uncertainties.
 */
public class ReadableTranscriptSegment {

    @JsonProperty("segmentId")
    @Nonnull
    private String segmentId;

    @JsonProperty("sequenceNo")
    private int sequenceNo;

    @JsonProperty("timeRange")
    @Nonnull
    private TimeRange timeRange;

    @JsonProperty("text")
    @Nonnull
    private String text;

    @JsonProperty("normalizedText")
    @Nullable
    private String normalizedText;

    @JsonProperty("speakerHint")
    @Nullable
    private SpeakerHint speakerHint;

    @JsonProperty("sceneId")
    @Nullable
    private String sceneId;

    @JsonProperty("contextReferences")
    @Nullable
    private List<ContextReference> contextReferences;

    @JsonProperty("uncertainties")
    @Nullable
    private List<TranscriptUncertainty> uncertainties;

    public ReadableTranscriptSegment(
            @Nonnull final String segmentId,
            final int sequenceNo,
            @Nonnull final TimeRange timeRange,
            @Nonnull final String text,
            @Nullable final String normalizedText,
            @Nullable final SpeakerHint speakerHint,
            @Nullable final String sceneId,
            @Nullable final List<ContextReference> contextReferences,
            @Nullable final List<TranscriptUncertainty> uncertainties) {
        this.segmentId = segmentId;
        this.sequenceNo = sequenceNo;
        this.timeRange = ObjectPreconditions.assertNotNull(timeRange, "timeRange must not be null");
        this.text = text;
        this.normalizedText = normalizedText;
        this.speakerHint = speakerHint;
        this.sceneId = sceneId;
        this.contextReferences = contextReferences;
        this.uncertainties = uncertainties;
    }

    @Nonnull
    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(@Nonnull final String segmentId) {
        this.segmentId = segmentId;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(final int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    @Nonnull
    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(@Nonnull final TimeRange timeRange) {
        this.timeRange = timeRange;
    }

    @Nonnull
    public String getText() {
        return text;
    }

    public void setText(@Nonnull final String text) {
        this.text = text;
    }

    @Nullable
    public String getNormalizedText() {
        return normalizedText;
    }

    public void setNormalizedText(@Nullable final String normalizedText) {
        this.normalizedText = normalizedText;
    }

    @Nullable
    public SpeakerHint getSpeakerHint() {
        return speakerHint;
    }

    public void setSpeakerHint(@Nullable final SpeakerHint speakerHint) {
        this.speakerHint = speakerHint;
    }

    @Nullable
    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(@Nullable final String sceneId) {
        this.sceneId = sceneId;
    }

    @Nullable
    public List<ContextReference> getContextReferences() {
        return contextReferences;
    }

    public void setContextReferences(@Nullable final List<ContextReference> contextReferences) {
        this.contextReferences = contextReferences;
    }

    @Nullable
    public List<TranscriptUncertainty> getUncertainties() {
        return uncertainties;
    }

    public void setUncertainties(@Nullable final List<TranscriptUncertainty> uncertainties) {
        this.uncertainties = uncertainties;
    }
}

