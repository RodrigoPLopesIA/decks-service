package com.deckmasterai.decks.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/decks")
public class DeckController {

    @GetMapping
    public ResponseEntity<String> getDecks() {
        // Placeholder for actual logic to retrieve decks
        return ResponseEntity.ok("List of decks will be returned here.");
    }
}
