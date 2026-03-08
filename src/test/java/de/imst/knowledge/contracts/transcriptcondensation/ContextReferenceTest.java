package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ContextReference")
class ContextReferenceTest {

    private ContextReference reference;

    @BeforeEach
    void setUp() {
        reference = new ContextReference(
                ContextReferenceType.CHARACTER,
                "char-007",
                "Aragorn",
                0.95
        );
    }

    @Test
    @DisplayName("parameterized constructor sets all fields correctly")
    void parameterizedConstructorSetsAllFields() {
        assertThat(reference.getReferenceType()).isEqualTo(ContextReferenceType.CHARACTER);
        assertThat(reference.getReferenceKey()).isEqualTo("char-007");
        assertThat(reference.getDisplayText()).isEqualTo("Aragorn");
        assertThat(reference.getConfidence()).isEqualTo(0.95);
    }

    @Test
    @DisplayName("default constructor creates instance with null fields")
    @SuppressWarnings("DataFlowIssue")
    void defaultConstructorCreatesInstanceWithNullFields() {
        final ContextReference empty = new ContextReference();

        assertThat(empty.getReferenceType()).isNull();
        assertThat(empty.getReferenceKey()).isNull();
        assertThat(empty.getDisplayText()).isNull();
        assertThat(empty.getConfidence()).isNull();
    }

    @Test
    @DisplayName("constructor accepts null for optional fields")
    void constructorAcceptsNullOptionalFields() {
        final ContextReference ref = new ContextReference(ContextReferenceType.LOCATION, "loc-01", null, null);

        assertThat(ref.getDisplayText()).isNull();
        assertThat(ref.getConfidence()).isNull();
    }

    @Test
    @DisplayName("setters update all fields correctly")
    void settersUpdateAllFields() {
        reference.setReferenceType(ContextReferenceType.NPC);
        reference.setReferenceKey("npc-042");
        reference.setDisplayText("Gandalf");
        reference.setConfidence(0.80);

        assertThat(reference.getReferenceType()).isEqualTo(ContextReferenceType.NPC);
        assertThat(reference.getReferenceKey()).isEqualTo("npc-042");
        assertThat(reference.getDisplayText()).isEqualTo("Gandalf");
        assertThat(reference.getConfidence()).isEqualTo(0.80);
    }

    @Test
    @DisplayName("all ContextReferenceType enum values are present")
    void allContextReferenceTypesPresent() {
        assertThat(ContextReferenceType.values()).containsExactlyInAnyOrder(
                ContextReferenceType.PLAYER,
                ContextReferenceType.CHARACTER,
                ContextReferenceType.NPC,
                ContextReferenceType.LOCATION,
                ContextReferenceType.FACTION,
                ContextReferenceType.ITEM,
                ContextReferenceType.LORE_DOCUMENT
        );
    }
}

