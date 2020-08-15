package com.test.oauth.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseDto {

    private String code;
    private LocalDateTime timestamp;
    private String message;
    private List<String> details;

    public ErrorResponseDto() {

    }

    public ErrorResponseDto(String code, LocalDateTime timestamp, String message, List<String> details) {
        this.code = code;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorResponseDto(LocalDateTime timestamp, String message, List<String> details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
