package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SpeakerHint")
class SpeakerHintTest {

    private SpeakerHint speakerHint;

    @BeforeEach
    void setUp() {
        speakerHint = new SpeakerHint(
                SpeakerType.GAME_MASTER,
                "Dungeon Master Dave",
                "player-ref-01",
                0.87,
                List.of("INTRO_PHRASE", "NARRATIVE_STYLE")
        );
    }

    @Test
    @DisplayName("parameterized constructor sets all fields correctly")
    void parameterizedConstructorSetsAllFields() {
        assertThat(speakerHint.getSpeakerType()).isEqualTo(SpeakerType.GAME_MASTER);
        assertThat(speakerHint.getDisplayName()).isEqualTo("Dungeon Master Dave");
        assertThat(speakerHint.getCandidateReference()).isEqualTo("player-ref-01");
        assertThat(speakerHint.getConfidence()).isEqualTo(0.87);
        assertThat(speakerHint.getReasonCodes()).containsExactly("INTRO_PHRASE", "NARRATIVE_STYLE");
    }

    @Test
    @DisplayName("default constructor creates instance with null fields")
    @SuppressWarnings("DataFlowIssue")
    void defaultConstructorCreatesInstanceWithNullFields() {
        final SpeakerHint empty = new SpeakerHint();

        assertThat(empty.getSpeakerType()).isNull();
        assertThat(empty.getDisplayName()).isNull();
        assertThat(empty.getCandidateReference()).isNull();
        assertThat(empty.getConfidence()).isNull();
        assertThat(empty.getReasonCodes()).isNull();
    }

    @Test
    @DisplayName("constructor accepts all null optional fields")
    void constructorAcceptsNullOptionalFields() {
        final SpeakerHint hint = new SpeakerHint(SpeakerType.UNKNOWN, null, null, null, null);

        assertThat(hint.getSpeakerType()).isEqualTo(SpeakerType.UNKNOWN);
        assertThat(hint.getDisplayName()).isNull();
        assertThat(hint.getCandidateReference()).isNull();
        assertThat(hint.getConfidence()).isNull();
        assertThat(hint.getReasonCodes()).isNull();
    }

    @Test
    @DisplayName("setters update all fields correctly")
    void settersUpdateAllFields() {
        speakerHint.setSpeakerType(SpeakerType.PLAYER);
        speakerHint.setDisplayName("Alice");
        speakerHint.setCandidateReference("player-ref-02");
        speakerHint.setConfidence(0.60);
        speakerHint.setReasonCodes(List.of("CHARACTER_VOICE"));

        assertThat(speakerHint.getSpeakerType()).isEqualTo(SpeakerType.PLAYER);
        assertThat(speakerHint.getDisplayName()).isEqualTo("Alice");
        assertThat(speakerHint.getCandidateReference()).isEqualTo("player-ref-02");
        assertThat(speakerHint.getConfidence()).isEqualTo(0.60);
        assertThat(speakerHint.getReasonCodes()).containsExactly("CHARACTER_VOICE");
    }

    @Test
    @DisplayName("all SpeakerType enum values are present")
    void allSpeakerTypesPresent() {
        assertThat(SpeakerType.values()).containsExactlyInAnyOrder(
                SpeakerType.GAME_MASTER,
                SpeakerType.PLAYER,
                SpeakerType.CHARACTER,
                SpeakerType.UNKNOWN,
                SpeakerType.MIXED
        );
    }
}

