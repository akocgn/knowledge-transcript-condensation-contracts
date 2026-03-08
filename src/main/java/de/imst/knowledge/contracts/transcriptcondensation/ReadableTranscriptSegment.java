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
    @Nullable
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

    /**
     * Creates a new instance of ReadableTranscriptSegment.
     *
     * @param segmentId         stable unique identifier for the segment, e.g. "segment-1"
     * @param sequenceNo        the order of the segment within the transcript, starting from 1. Must be a positive integer.
     * @param timeRange         optional time range indicating the start and end timestamps of the segment within the
     *                          source media, in milliseconds. Must have non-negative start and end times,
     *                          and end time must be greater than or equal to start time.
     * @param text              The readable text content of the segment, as extracted from the source transcript. Must not be null or empty.
     * @param normalizedText    optional normalized version of the text content. Can be null if no normalization was applied or if the normalized text is identical to the original text.
     * @param speakerHint       optional hint about the speaker of the segment, if available. Can be null if no speaker information is available or if the speaker cannot be determined.
     * @param sceneId           optional identifier of the scene to which this segment belongs, if applicable.
     *                          Can be null if the segment is not associated with any specific scene or if scene segmentation was not performed.
     * @param contextReferences optional list of context references that link this segment to known entities, locations, items or other relevant information. Can be null if no context references were identified for this segment.
     * @param uncertainties     optional list of uncertainties associated with this segment, indicating any potential issues,
     *                          ambiguities or confidence levels related to the segment's content, speaker attribution, timestamps or other relevant aspects. Can be null if no uncertainties were identified for this segment.
     */
    public ReadableTranscriptSegment(
            @Nonnull final String segmentId,
            final int sequenceNo,
            @Nullable final TimeRange timeRange,
            @Nonnull final String text,
            @Nullable final String normalizedText,
            @Nullable final SpeakerHint speakerHint,
            @Nullable final String sceneId,
            @Nullable final List<ContextReference> contextReferences,
            @Nullable final List<TranscriptUncertainty> uncertainties) {
        this.segmentId = segmentId;
        this.sequenceNo = sequenceNo;
        this.timeRange = timeRange;
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

    @Nullable
    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(@Nullable final TimeRange timeRange) {
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

