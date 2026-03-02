package com.deckmasterai.decks.controllers;


import com.deckmasterai.decks.dto.DeckRequest;
import com.deckmasterai.decks.dto.DeckResponse;
import com.deckmasterai.decks.models.Deck;
import com.deckmasterai.decks.services.DeckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(DeckController.class)
public class DeckControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    DeckService service;


    @Autowired
    ObjectMapper objectMapper;

    DeckRequest deckRequest;
    DeckResponse deckResponse;
    Deck deck;

    @BeforeEach
    void setup(){

    }

    @Test
    @DisplayName("GET /api/v1/decks - Success")
    @WithMockUser
    void testGetAllDecksSuccess() throws Exception {

    }
}
