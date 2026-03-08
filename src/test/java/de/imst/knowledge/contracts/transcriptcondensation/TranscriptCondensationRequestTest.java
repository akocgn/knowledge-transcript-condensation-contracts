package de.imst.knowledge.contracts.transcriptcondensation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranscriptCondensationRequestTest {

    @Test
    void testDefaultConstructor() {
        TranscriptCondensationRequest request = new TranscriptCondensationRequest();
        assertNull(request.getTranscriptId());
        assertNull(request.getContent());
        assertNull(request.getLanguage());
    }

    @Test
    void testParameterizedConstructor() {
        TranscriptCondensationRequest request = new TranscriptCondensationRequest("id-1", "Some content", "en");
        assertEquals("id-1", request.getTranscriptId());
        assertEquals("Some content", request.getContent());
        assertEquals("en", request.getLanguage());
    }

    @Test
    void testSetters() {
        TranscriptCondensationRequest request = new TranscriptCondensationRequest();
        request.setTranscriptId("id-2");
        request.setContent("Other content");
        request.setLanguage("de");

        assertEquals("id-2", request.getTranscriptId());
        assertEquals("Other content", request.getContent());
        assertEquals("de", request.getLanguage());
    }
}
