package com.deckmasterai.decks.mapper;

import com.deckmasterai.decks.dto.DeckRequest;
import com.deckmasterai.decks.dto.DeckResponse;
import com.deckmasterai.decks.models.Deck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeckMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profileId", ignore = true)
    Deck toEntity(DeckRequest request);

    DeckResponse toResponse(Deck deck);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(DeckRequest dto, @MappingTarget Deck entity);
}
