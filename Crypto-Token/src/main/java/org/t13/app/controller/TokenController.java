package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.t13.app.model.TokenEntry;
import org.t13.app.service.TokenService;

import java.util.Map;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    private TokenService service;

    @PostMapping("/generate")
    public ResponseEntity<TokenEntry> generate(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(service.tokenize(payload.get("data")));
    }

    @GetMapping("/retrieve/{token}")
    public ResponseEntity<TokenEntry> retrieve(@PathVariable String token) {
        return service.retrieve(token)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

