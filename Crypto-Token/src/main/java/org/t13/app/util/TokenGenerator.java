package org.t13.app.util;

import org.springframework.util.DigestUtils;

import java.util.Base64;
import java.util.UUID;

public class TokenGenerator {
    public static String generateToken(String input) {
        return Base64.getEncoder().encodeToString(
                DigestUtils.md5Digest((input + UUID.randomUUID()).getBytes())
        );
    }
}
