package com.tus.customerorder.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, String> errors; // For validation field-specific feedback

    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    // Getters
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public Map<String, String> getErrors() { return errors; }
}