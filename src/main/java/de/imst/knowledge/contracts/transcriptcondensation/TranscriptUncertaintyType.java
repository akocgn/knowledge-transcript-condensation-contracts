package de.imst.knowledge.contracts.transcriptcondensation;

/**
 * Represents the type of a transcript uncertainty.
 */
public enum TranscriptUncertaintyType {
    /**
     * Indicates that the system is uncertain about the identity of a speaker, e.g., whether a certain line of dialogue was spoken by one character or another.
     */
    SPEAKER_UNCERTAIN,
    /**
     * Indicates that the system is uncertain about the content of a segment, e.g., whether a certain line of dialogue was actually spoken or not.
     */
    POSSIBLE_SEGMENT_BREAK_ERROR,
    /**
     * Indicates that the system is uncertain about the normalization of a name, e.g., whether a certain name should be normalized to a known character or not.
     */
    NAME_NORMALIZATION_UNCERTAIN,
    /**
     * Indicates that the system is uncertain about the boundary of a segment, e.g., whether a segment break should be placed at a certain point or not.
     */
    SCENE_BOUNDARY_UNCERTAIN
}

