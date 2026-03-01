package com.deckmasterai.decks.services;

import com.deckmasterai.decks.dto.DeckRequest;
import com.deckmasterai.decks.dto.DeckResponse;
import com.deckmasterai.decks.mapper.DeckMapper;
import com.deckmasterai.decks.models.Deck;
import com.deckmasterai.decks.repositories.DeckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckService {

    private final DeckRepository repository;
    private final DeckMapper mapper;

    public Page<DeckResponse> getAll(Pageable pageable, String profileId) {
        return repository.findAllByProfileId(pageable, profileId)
                .map(mapper::toResponse);
    }

    public DeckResponse getById(String id, String profileId) {
        Deck deck = repository.findByIdAndProfileId(id, profileId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));

        return mapper.toResponse(deck);
    }

    public DeckResponse create(DeckRequest request, String profileId) {
        Deck deck = mapper.toEntity(request);
        deck.setProfileId(profileId);

        return mapper.toResponse(repository.save(deck));
    }

    public DeckResponse update(String id, DeckRequest request, String profileId) {
        Deck deck = repository.findByIdAndProfileId(id, profileId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));

        mapper.updateEntityFromDto(request, deck);

        return mapper.toResponse(repository.save(deck));
    }

    public void delete(String id, String profileId) {
        Deck deck = repository.findByIdAndProfileId(id, profileId)
                .orElseThrow(() -> new RuntimeException("Deck not found"));

        repository.delete(deck);
    }
}