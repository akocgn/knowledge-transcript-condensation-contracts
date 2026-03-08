package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("TranscriptUncertainty")
class TranscriptUncertaintyTest {

    @Test
    @DisplayName("constructor sets all fields correctly")
    void constructorSetsAllFields() {
        final TranscriptUncertainty uncertainty = new TranscriptUncertainty(
                TranscriptUncertaintyType.SPEAKER_UNCERTAIN,
                "Speaker could not be identified",
                UncertaintySeverity.HIGH
        );

        assertThat(uncertainty.getType()).isEqualTo(TranscriptUncertaintyType.SPEAKER_UNCERTAIN);
        assertThat(uncertainty.getMessage()).isEqualTo("Speaker could not be identified");
        assertThat(uncertainty.getSeverity()).isEqualTo(UncertaintySeverity.HIGH);
    }

    @Test
    @DisplayName("constructor accepts null message")
    void constructorAcceptsNullMessage() {
        final TranscriptUncertainty uncertainty = new TranscriptUncertainty(
                TranscriptUncertaintyType.NAME_NORMALIZATION_UNCERTAIN,
                null,
                UncertaintySeverity.LOW
        );

        assertThat(uncertainty.getMessage()).isNull();
    }

    @Test
    @DisplayName("setters update fields correctly")
    void settersUpdateFields() {
        final TranscriptUncertainty uncertainty = new TranscriptUncertainty(
                TranscriptUncertaintyType.SPEAKER_UNCERTAIN,
                "initial message",
                UncertaintySeverity.LOW
        );

        uncertainty.setType(TranscriptUncertaintyType.SCENE_BOUNDARY_UNCERTAIN);
        uncertainty.setMessage("updated message");
        uncertainty.setSeverity(UncertaintySeverity.MEDIUM);

        assertThat(uncertainty.getType()).isEqualTo(TranscriptUncertaintyType.SCENE_BOUNDARY_UNCERTAIN);
        assertThat(uncertainty.getMessage()).isEqualTo("updated message");
        assertThat(uncertainty.getSeverity()).isEqualTo(UncertaintySeverity.MEDIUM);
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when type is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullType() {
        assertThatThrownBy(() -> new TranscriptUncertainty(null, "msg", UncertaintySeverity.LOW))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("type must not be null");
    }

    @Test
    @DisplayName("constructor throws IllegalArgumentException when severity is null")
    @SuppressWarnings("DataFlowIssue")
    void constructorThrowsOnNullSeverity() {
        assertThatThrownBy(() -> new TranscriptUncertainty(TranscriptUncertaintyType.SPEAKER_UNCERTAIN, "msg", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("severity must not be null");
    }

    @Test
    @DisplayName("all TranscriptUncertaintyType enum values are present")
    void allUncertaintyTypesPresent() {
        assertThat(TranscriptUncertaintyType.values()).containsExactlyInAnyOrder(
                TranscriptUncertaintyType.SPEAKER_UNCERTAIN,
                TranscriptUncertaintyType.POSSIBLE_SEGMENT_BREAK_ERROR,
                TranscriptUncertaintyType.NAME_NORMALIZATION_UNCERTAIN,
                TranscriptUncertaintyType.SCENE_BOUNDARY_UNCERTAIN
        );
    }

    @Test
    @DisplayName("all UncertaintySeverity enum values are present")
    void allSeverityValuesPresent() {
        assertThat(UncertaintySeverity.values()).containsExactlyInAnyOrder(
                UncertaintySeverity.LOW,
                UncertaintySeverity.MEDIUM,
                UncertaintySeverity.HIGH
        );
    }
}

