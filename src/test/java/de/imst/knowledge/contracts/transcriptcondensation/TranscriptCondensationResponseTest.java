package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranscriptCondensationResponseTest {

    @Test
    void testDefaultConstructor() {
        TranscriptCondensationResponse response = new TranscriptCondensationResponse();
        assertNull(response.getTranscriptId());
        assertNull(response.getCondensedContent());
        assertNull(response.getStatus());
    }

    @Test
    void testParameterizedConstructor() {
        TranscriptCondensationResponse response = new TranscriptCondensationResponse(
                "id-1", "Condensed content", CondensationStatus.COMPLETED);
        assertEquals("id-1", response.getTranscriptId());
        assertEquals("Condensed content", response.getCondensedContent());
        assertEquals(CondensationStatus.COMPLETED, response.getStatus());
    }

    @Test
    void testSetters() {
        TranscriptCondensationResponse response = new TranscriptCondensationResponse();
        response.setTranscriptId("id-2");
        response.setCondensedContent("Another condensed content");
        response.setStatus(CondensationStatus.FAILED);

        assertEquals("id-2", response.getTranscriptId());
        assertEquals("Another condensed content", response.getCondensedContent());
        assertEquals(CondensationStatus.FAILED, response.getStatus());
    }

    @Test
    void testAllCondensationStatuses() {
        assertEquals(4, CondensationStatus.values().length);
        assertNotNull(CondensationStatus.valueOf("PENDING"));
        assertNotNull(CondensationStatus.valueOf("IN_PROGRESS"));
        assertNotNull(CondensationStatus.valueOf("COMPLETED"));
        assertNotNull(CondensationStatus.valueOf("FAILED"));
    }
}
