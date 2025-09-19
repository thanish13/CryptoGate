package org.t13.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.t13.app.model.TokenEntry;

public interface TokenRepository  extends JpaRepository<TokenEntry, String> {
}
