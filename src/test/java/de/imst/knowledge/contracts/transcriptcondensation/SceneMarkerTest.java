package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SceneMarker")
class SceneMarkerTest {

    private SceneMarker sceneMarker;

    @BeforeEach
    void setUp() {
        sceneMarker = new SceneMarker("scene-01", "Tavern Introduction", 1, 10, 0.92);
    }

    @Test
    @DisplayName("parameterized constructor sets all fields correctly")
    void parameterizedConstructorSetsAllFields() {
        assertThat(sceneMarker.getSceneId()).isEqualTo("scene-01");
        assertThat(sceneMarker.getLabel()).isEqualTo("Tavern Introduction");
        assertThat(sceneMarker.getStartSegmentNo()).isEqualTo(1);
        assertThat(sceneMarker.getEndSegmentNo()).isEqualTo(10);
        assertThat(sceneMarker.getConfidence()).isEqualTo(0.92);
    }

    @Test
    @DisplayName("default constructor creates instance with zero segment numbers and null fields")
    @SuppressWarnings("DataFlowIssue")
    void defaultConstructorCreatesInstanceWithDefaults() {
        final SceneMarker empty = new SceneMarker();

        assertThat(empty.getSceneId()).isNull();
        assertThat(empty.getLabel()).isNull();
        assertThat(empty.getStartSegmentNo()).isZero();
        assertThat(empty.getEndSegmentNo()).isZero();
        assertThat(empty.getConfidence()).isNull();
    }

    @Test
    @DisplayName("constructor accepts null for optional fields")
    void constructorAcceptsNullOptionalFields() {
        final SceneMarker marker = new SceneMarker("scene-02", null, 5, 15, null);

        assertThat(marker.getLabel()).isNull();
        assertThat(marker.getConfidence()).isNull();
    }

    @Test
    @DisplayName("setters update all fields correctly")
    void settersUpdateAllFields() {
        sceneMarker.setSceneId("scene-99");
        sceneMarker.setLabel("Final Battle");
        sceneMarker.setStartSegmentNo(20);
        sceneMarker.setEndSegmentNo(35);
        sceneMarker.setConfidence(0.75);

        assertThat(sceneMarker.getSceneId()).isEqualTo("scene-99");
        assertThat(sceneMarker.getLabel()).isEqualTo("Final Battle");
        assertThat(sceneMarker.getStartSegmentNo()).isEqualTo(20);
        assertThat(sceneMarker.getEndSegmentNo()).isEqualTo(35);
        assertThat(sceneMarker.getConfidence()).isEqualTo(0.75);
    }
}

