package com.deckmasterai.decks.controllers;


import com.deckmasterai.decks.dto.DeckRequest;
import com.deckmasterai.decks.dto.DeckResponse;
import com.deckmasterai.decks.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService service;


    @GetMapping
    public ResponseEntity<Page<DeckResponse>> getAll(Pageable pageable,
                                                     @AuthenticationPrincipal Jwt jwt
    ) {
        return ResponseEntity.ok(service.getAll(pageable, jwt.getSubject()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeckResponse> getById(
            @PathVariable String id,
            @AuthenticationPrincipal Jwt jwt
    ) {
        return ResponseEntity.ok(service.getById(id, jwt.getSubject()));
    }

    @PostMapping
    public ResponseEntity<DeckResponse> create(
            @RequestBody DeckRequest request,
            @AuthenticationPrincipal Jwt jwt
    ) {
        return ResponseEntity.status(201)
                .body(service.create(request, jwt.getSubject()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeckResponse> update(
            @PathVariable String id,
            @RequestBody DeckRequest request,
            @AuthenticationPrincipal Jwt jwt
    ) {
        return ResponseEntity.ok(
                service.update(id, request, jwt.getSubject())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id,
            @AuthenticationPrincipal Jwt jwt
    ) {
        service.delete(id, jwt.getSubject());
        return ResponseEntity.noContent().build();
    }
}
