package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Marks the boundary of a scene within a transcript, spanning a range of segments.
 */
public class SceneMarker {

    @JsonProperty("sceneId")
    @Nonnull
    private String sceneId;

    @JsonProperty("label")
    @Nullable
    private String label;

    @JsonProperty("startSegmentNo")
    private int startSegmentNo;

    @JsonProperty("endSegmentNo")
    private int endSegmentNo;

    @JsonProperty("confidence")
    @Nullable
    private Double confidence;

    public SceneMarker() {
    }

    public SceneMarker(
            @Nonnull final String sceneId,
            @Nullable final String label,
            final int startSegmentNo,
            final int endSegmentNo,
            @Nullable final Double confidence) {
        this.sceneId = sceneId;
        this.label = label;
        this.startSegmentNo = startSegmentNo;
        this.endSegmentNo = endSegmentNo;
        this.confidence = confidence;
    }

    @Nonnull
    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(@Nonnull final String sceneId) {
        this.sceneId = sceneId;
    }

    @Nullable
    public String getLabel() {
        return label;
    }

    public void setLabel(@Nullable final String label) {
        this.label = label;
    }

    public int getStartSegmentNo() {
        return startSegmentNo;
    }

    public void setStartSegmentNo(final int startSegmentNo) {
        this.startSegmentNo = startSegmentNo;
    }

    public int getEndSegmentNo() {
        return endSegmentNo;
    }

    public void setEndSegmentNo(final int endSegmentNo) {
        this.endSegmentNo = endSegmentNo;
    }

    @Nullable
    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(@Nullable final Double confidence) {
        this.confidence = confidence;
    }
}

