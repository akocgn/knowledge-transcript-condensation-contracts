package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ReadableTranscriptSegment")
class ReadableTranscriptSegmentTest {

    public static final TimeRange TIME_RANGE = new TimeRange(10000L, 15000L);
    private SpeakerHint speakerHint;
    private ContextReference contextReference;
    private TranscriptUncertainty uncertainty;
    private ReadableTranscriptSegment segment;

    @BeforeEach
    void setUp() {
        speakerHint = new SpeakerHint(SpeakerType.GAME_MASTER, "DM", null, 0.9, null);
        contextReference = new ContextReference(ContextReferenceType.LOCATION, "loc-01", "The Tavern", 0.85);
        uncertainty = new TranscriptUncertainty(TranscriptUncertaintyType.SPEAKER_UNCERTAIN, "Unclear speaker", UncertaintySeverity.LOW);

        segment = new ReadableTranscriptSegment(
                "seg-001",
                1,
                TIME_RANGE,
                "You enter a dimly lit tavern.",
                "You enter a dimly lit tavern.",
                speakerHint,
                "scene-01",
                List.of(contextReference),
                List.of(uncertainty)
        );
    }

    @Test
    @DisplayName("parameterized constructor sets all fields correctly")
    void parameterizedConstructorSetsAllFields() {
        assertThat(segment.getSegmentId()).isEqualTo("seg-001");
        assertThat(segment.getSequenceNo()).isEqualTo(1);
        assertThat(segment.getTimeRange()).isEqualTo(TIME_RANGE);
        assertThat(segment.getText()).isEqualTo("You enter a dimly lit tavern.");
        assertThat(segment.getNormalizedText()).isEqualTo("You enter a dimly lit tavern.");
        assertThat(segment.getSpeakerHint()).isEqualTo(speakerHint);
        assertThat(segment.getSceneId()).isEqualTo("scene-01");
        assertThat(segment.getContextReferences()).containsExactly(contextReference);
        assertThat(segment.getUncertainties()).containsExactly(uncertainty);
    }

    @DisplayName("constructor accepts null for all optional fields")
    @Test
    void constructorAcceptsNullOptionalFields() {
        final ReadableTranscriptSegment seg = new ReadableTranscriptSegment(
                "seg-002", 2, TIME_RANGE,
                "Some text", null, null, null, null, null
        );
        assertThat(seg.getTimeRange()).isEqualTo(TIME_RANGE);
        assertThat(seg.getNormalizedText()).isNull();
        assertThat(seg.getSpeakerHint()).isNull();
        assertThat(seg.getSceneId()).isNull();
        assertThat(seg.getContextReferences()).isNull();
        assertThat(seg.getUncertainties()).isNull();
    }

    @DisplayName("setters update all fields correctly")
    @Test
    void settersUpdateAllFields() {
        final SpeakerHint newHint = new SpeakerHint(SpeakerType.PLAYER, "Alice", null, null, null);

        segment.setSegmentId("seg-099");
        segment.setSequenceNo(5);
        segment.setTimeRange(TIME_RANGE);
        segment.setText("Updated text");
        segment.setNormalizedText("updated text");
        segment.setSpeakerHint(newHint);
        segment.setSceneId("scene-02");
        segment.setContextReferences(List.of());
        segment.setUncertainties(List.of());

        assertThat(segment.getSegmentId()).isEqualTo("seg-099");
        assertThat(segment.getSequenceNo()).isEqualTo(5);
        assertThat(segment.getTimeRange()).isEqualTo(TIME_RANGE);
        assertThat(segment.getText()).isEqualTo("Updated text");
        assertThat(segment.getNormalizedText()).isEqualTo("updated text");
        assertThat(segment.getSpeakerHint()).isEqualTo(newHint);
        assertThat(segment.getSceneId()).isEqualTo("scene-02");
        assertThat(segment.getContextReferences()).isEmpty();
        assertThat(segment.getUncertainties()).isEmpty();
    }
}

