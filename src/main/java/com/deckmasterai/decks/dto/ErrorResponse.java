package com.deckmasterai.decks.dto;

import lombok.Builder;

import java.util.Map;

@Builder
public record ErrorResponse(String path, String message, int statusCode, Map<String, String> details) {

    public ErrorResponse(String path, String message, int statusCode) {
        this(path, message, statusCode, null);
    }
}