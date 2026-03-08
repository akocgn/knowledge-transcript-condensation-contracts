package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ReadableTranscriptMetadata")
class ReadableTranscriptMetadataTest {

    private ReadableTranscriptMetadata metadata;

    @BeforeEach
    void setUp() {
        metadata = new ReadableTranscriptMetadata(
                TranscriptSourceType.YOUTUBE,
                true,
                true,
                "1.4.2",
                true
        );
    }

    @Test
    @DisplayName("parameterized constructor sets all fields correctly")
    void parameterizedConstructorSetsAllFields() {
        assertThat(metadata.getSourceType()).isEqualTo(TranscriptSourceType.YOUTUBE);
        assertThat(metadata.isHasSpeakerIdentification()).isTrue();
        assertThat(metadata.isHasSceneDetection()).isTrue();
        assertThat(metadata.getProcessingVersion()).isEqualTo("1.4.2");
        assertThat(metadata.isContainsContextEnrichment()).isTrue();
    }

    @Test
    @DisplayName("constructor accepts null for processingVersion")
    void constructorAcceptsNullProcessingVersion() {
        final ReadableTranscriptMetadata meta = new ReadableTranscriptMetadata(
                TranscriptSourceType.MANUAL, false, false, null, false
        );

        assertThat(meta.getProcessingVersion()).isNull();
    }

    @Test
    @DisplayName("setters update all fields correctly")
    void settersUpdateAllFields() {
        metadata.setSourceType(TranscriptSourceType.AUDIO_DERIVED);
        metadata.setHasSpeakerIdentification(false);
        metadata.setHasSceneDetection(false);
        metadata.setProcessingVersion("2.0.0");
        metadata.setContainsContextEnrichment(false);

        assertThat(metadata.getSourceType()).isEqualTo(TranscriptSourceType.AUDIO_DERIVED);
        assertThat(metadata.isHasSpeakerIdentification()).isFalse();
        assertThat(metadata.isHasSceneDetection()).isFalse();
        assertThat(metadata.getProcessingVersion()).isEqualTo("2.0.0");
        assertThat(metadata.isContainsContextEnrichment()).isFalse();
    }

    @Test
    @DisplayName("all TranscriptSourceType enum values are present")
    void allSourceTypesPresent() {
        assertThat(TranscriptSourceType.values()).containsExactlyInAnyOrder(
                TranscriptSourceType.YOUTUBE,
                TranscriptSourceType.MANUAL,
                TranscriptSourceType.AUDIO_DERIVED
        );
    }
}

