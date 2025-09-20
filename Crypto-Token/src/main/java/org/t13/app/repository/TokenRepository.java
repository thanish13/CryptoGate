package org.t13.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.t13.app.entity.TokenEntry;

public interface TokenRepository  extends JpaRepository<TokenEntry, String> {
}
