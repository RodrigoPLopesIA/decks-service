package com.deckmasterai.decks.repositories;

import com.deckmasterai.decks.models.Deck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DeckRepository extends MongoRepository<Deck, String> {

    Page<Deck> findAllByProfileId(Pageable pageable, String profileId);

    Optional<Deck> findByIdAndProfileId(String id, String profileId);
}
