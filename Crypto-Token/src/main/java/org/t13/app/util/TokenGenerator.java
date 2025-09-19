package org.t13.app.util;

import java.util.Base64;
import java.util.UUID;

public class TokenGenerator {
    public static String generateToken(String input) {
        return Base64.getEncoder().encodeToString((input + UUID.randomUUID()).getBytes()
        );
    }
}
