package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranscriptCondensationRequest {

    @JsonProperty("transcriptId")
    private String transcriptId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("language")
    private String language;

    public TranscriptCondensationRequest() {
    }

    public TranscriptCondensationRequest(String transcriptId, String content, String language) {
        this.transcriptId = transcriptId;
        this.content = content;
        this.language = language;
    }

    public String getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(String transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
