package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.t13.app.entity.TokenEntry;
import org.t13.app.model.DataPayload;
import org.t13.app.service.TokenService;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    private TokenService service;

    @PostMapping("/generate")
    public ResponseEntity<TokenEntry> generate(@RequestBody DataPayload payload) {
        return ResponseEntity.ok(service.tokenize(payload.getData()));
    }

    @GetMapping("/retrieve/{token}")
    public ResponseEntity<TokenEntry> retrieve(@PathVariable String token) {
        return service.retrieve(token)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

