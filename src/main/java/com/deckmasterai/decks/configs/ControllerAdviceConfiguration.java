package com.deckmasterai.decks.configs;

import com.deckmasterai.decks.dto.ErrorResponse;
import com.deckmasterai.decks.exceptions.DeckNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceConfiguration {


    @ExceptionHandler(DeckNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDeckNotFoundException(DeckNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder().path(request.getRequestURI()).message(ex.getMessage()).statusCode(404).build();
        return ResponseEntity.status(404).body(errorResponse);
    }
}
