package de.imst.knowledge.contracts.transcriptcondensation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranscriptCondensationResponse {

    @JsonProperty("transcriptId")
    private String transcriptId;

    @JsonProperty("condensedContent")
    private String condensedContent;

    @JsonProperty("status")
    private CondensationStatus status;

    public TranscriptCondensationResponse() {
    }

    public TranscriptCondensationResponse(String transcriptId, String condensedContent, CondensationStatus status) {
        this.transcriptId = transcriptId;
        this.condensedContent = condensedContent;
        this.status = status;
    }

    public String getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(String transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getCondensedContent() {
        return condensedContent;
    }

    public void setCondensedContent(String condensedContent) {
        this.condensedContent = condensedContent;
    }

    public CondensationStatus getStatus() {
        return status;
    }

    public void setStatus(CondensationStatus status) {
        this.status = status;
    }
}
