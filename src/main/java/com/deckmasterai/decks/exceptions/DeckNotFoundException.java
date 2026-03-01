package com.deckmasterai.decks.exceptions;

public class DeckNotFoundException extends RuntimeException {

    public DeckNotFoundException(String message) {
        super(message);
    }
}
