package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ReadableTranscript")
class ReadableTranscriptTest {

    public static final TimeRange TIME_RANGE = new TimeRange(100000L, 200000L);
    private ReadableTranscriptMetadata metadata;
    private ReadableTranscriptSegment segment;
    private SceneMarker scene;
    private ContextReference contextReference;
    private TranscriptUncertainty uncertainty;
    private Instant createdAt;

    @BeforeEach
    void setUp() {
        metadata = new ReadableTranscriptMetadata(TranscriptSourceType.YOUTUBE, true, true, "1.0.0", false);
        segment = new ReadableTranscriptSegment(
                "seg-001", 1, TIME_RANGE,
                "You enter a dimly lit tavern.", null, null, null, null, null
        );
        scene = new SceneMarker("scene-01", "Act I", 1, 10, 0.9);
        contextReference = new ContextReference(ContextReferenceType.LOCATION, "loc-01", "The Tavern", 0.85);
        uncertainty = new TranscriptUncertainty(TranscriptUncertaintyType.SPEAKER_UNCERTAIN, "Unclear speaker", UncertaintySeverity.LOW);
        createdAt = Instant.parse("2026-03-08T12:00:00Z");
    }

    @DisplayName("constructor sets all fields correctly")
    @Test
    void constructorSetsAllFields() {
        final ReadableTranscript transcript = new ReadableTranscript(
                "transcript-001",
                "source-001",
                "Session 1 – The Beginning",
                "en",
                createdAt,
                metadata,
                List.of(segment),
                List.of(scene),
                List.of(contextReference),
                List.of(uncertainty)
        );

        assertThat(transcript.transcriptId()).isEqualTo("transcript-001");
        assertThat(transcript.sourceTranscriptId()).isEqualTo("source-001");
        assertThat(transcript.title()).isEqualTo("Session 1 – The Beginning");
        assertThat(transcript.language()).isEqualTo("en");
        assertThat(transcript.createdAt()).isEqualTo(createdAt);
        assertThat(transcript.metadata()).isEqualTo(metadata);
        assertThat(transcript.segments()).containsExactly(segment);
        assertThat(transcript.scenes()).containsExactly(scene);
        assertThat(transcript.contextReferences()).containsExactly(contextReference);
        assertThat(transcript.uncertainties()).containsExactly(uncertainty);
    }

    @Test
    @DisplayName("constructor accepts empty lists for collections")
    void constructorAcceptsEmptyLists() {
        final ReadableTranscript transcript = new ReadableTranscript(
                "transcript-002", "source-002", "Empty Session", "de",
                createdAt, metadata, List.of(), List.of(), List.of(), List.of()
        );

        assertThat(transcript.segments()).isEmpty();
        assertThat(transcript.scenes()).isEmpty();
        assertThat(transcript.contextReferences()).isEmpty();
        assertThat(transcript.uncertainties()).isEmpty();
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when transcriptId is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullTranscriptId() {
        assertThatThrownBy(() -> new ReadableTranscript(
                null, "source-001", "Title", "en",
                createdAt, metadata, List.of(), List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("transcriptId must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when title is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullTitle() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", null, "en",
                createdAt, metadata, List.of(), List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("title must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when language is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullLanguage() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", null,
                createdAt, metadata, List.of(), List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("language must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when createdAt is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullCreatedAt() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                null, metadata, List.of(), List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("createdAt must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when metadata is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullMetadata() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                createdAt, null, List.of(), List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("metadata must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when segments is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullSegments() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                createdAt, metadata, null, List.of(), List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("segments must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when scenes is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullScenes() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                createdAt, metadata, List.of(), null, List.of(), List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("scenes must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when contextReferences is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullContextReferences() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                createdAt, metadata, List.of(), List.of(), null, List.of()
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("contextReferences must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when uncertainties is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullUncertainties() {
        assertThatThrownBy(() -> new ReadableTranscript(
                "transcript-001", "source-001", "Title", "en",
                createdAt, metadata, List.of(), List.of(), List.of(), null
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("uncertainties must not be null");
    }
}

