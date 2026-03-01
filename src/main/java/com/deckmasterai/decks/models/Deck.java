package com.deckmasterai.decks.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "decks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Deck {


    @Id
    private String id;
    private String name;
    private String description;
    private String profileId;
    private String deckImage;
    private List<String> cardIds = new ArrayList<>();

}
