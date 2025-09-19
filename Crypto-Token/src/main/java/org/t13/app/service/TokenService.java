package org.t13.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.t13.app.model.TokenEntry;
import org.t13.app.repository.TokenRepository;
import org.t13.app.util.TokenGenerator;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenService {

    @Autowired
    private TokenRepository repo;

    public TokenEntry tokenize(String data) {
        String token = TokenGenerator.generateToken(data);
        TokenEntry entry = TokenEntry.builder().build();
        entry.setOriginalData(data);
        entry.setToken(token);
        entry.setCreatedAt(LocalDateTime.now());
        return repo.save(entry);
    }

    public Optional<TokenEntry> retrieve(String token) {
        return repo.findById(token);
    }
}
