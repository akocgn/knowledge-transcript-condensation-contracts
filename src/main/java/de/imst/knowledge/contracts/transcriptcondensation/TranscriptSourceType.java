package de.imst.knowledge.contracts.transcriptcondensation;

/**
 * Represents the source type of a readable transcript.
 */
public enum TranscriptSourceType {
    /**
     * Indicates that the transcript was generated from a YouTube video, likely using YouTube's automatic captioning or a similar service.
     */
    YOUTUBE,
    /**
     * Indicates that the transcript was generated from an audio recording, possibly using a speech-to-text service or software.
     */
    MANUAL,
    /**
     * Indicates that the transcript was generated from a video recording, possibly using a combination of speech-to-text and video analysis techniques.
     */
    AUDIO_DERIVED
}

