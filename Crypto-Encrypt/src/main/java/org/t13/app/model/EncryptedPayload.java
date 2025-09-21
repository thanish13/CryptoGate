package org.t13.app.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class EncryptedPayload {

    private String encryptedData;
    private String encryptedKey;

}