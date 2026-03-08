package de.imst.knowledge.contracts.transcriptcondensation;

import de.imst.knowledge.contracts.transcriptcondensation.util.ObjectPreconditions;
import jakarta.annotation.Nonnull;

import java.time.Instant;
import java.util.List;

/**
 * The complete processed result of a transcript processing.
 *
 * @param transcriptId       The unique identifier of the transcript.
 * @param sourceTranscriptId the unique identifier of the source transcript, if available.
 * @param title              the title of the transcript.
 * @param language           the language of the transcript.
 * @param createdAt          the creation timestamp of the transcript.
 * @param metadata           teh metadata of the transcript, including information about the source, processing details, and any relevant tags or categories.
 * @param segments           the list of segments that make up the transcript, each containing the text, speaker information, timestamps, and any associated metadata.
 * @param scenes             the list of scene markers that indicate significant changes in the transcript, such as topic shifts, scene changes, or other relevant events.
 * @param contextReferences  the list of context references that link segments to external knowledge, documents, or other relevant information that can provide additional context for understanding the transcript.
 * @param uncertainties      the list of uncertainties that indicate any potential issues, ambiguities, or confidence levels associated with the transcript segments, speaker attributions, or other relevant aspects of the transcript.
 */
public record ReadableTranscript(
        @Nonnull String transcriptId,
        @Nonnull String sourceTranscriptId,
        @Nonnull String title,
        @Nonnull String language,
        @Nonnull Instant createdAt,
        @Nonnull ReadableTranscriptMetadata metadata,
        @Nonnull List<ReadableTranscriptSegment> segments,
        @Nonnull List<SceneMarker> scenes,
        @Nonnull List<ContextReference> contextReferences,
        @Nonnull List<TranscriptUncertainty> uncertainties
) {
    public ReadableTranscript {
        ObjectPreconditions.assertNotNull(transcriptId, "transcriptId must not be null");
        ObjectPreconditions.assertNotNull(sourceTranscriptId, "sourceTranscriptId must not be null");
        ObjectPreconditions.assertNotNull(title, "title must not be null");
        ObjectPreconditions.assertNotNull(language, "language must not be null");
        ObjectPreconditions.assertNotNull(createdAt, "createdAt must not be null");
        ObjectPreconditions.assertNotNull(metadata, "metadata must not be null");
        ObjectPreconditions.assertNotNull(segments, "segments must not be null");
        ObjectPreconditions.assertNotNull(scenes, "scenes must not be null");
        ObjectPreconditions.assertNotNull(contextReferences, "contextReferences must not be null");
        ObjectPreconditions.assertNotNull(uncertainties, "uncertainties must not be null");
    }
}