package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a time range with a start and end timestamp in milliseconds. Used for defining the temporal boundaries of segments, scenes, or other relevant events within a transcript.
 *
 * @param startMillis the start timestamp of the time range in milliseconds.
 * @param endMillis   the end timestamp of the time range in milliseconds.
 */
public record TimeRange(
        @JsonProperty("startMillis") long startMillis,
        @JsonProperty("endMillis") long endMillis
) {
    @JsonCreator
    public TimeRange {
    }
}