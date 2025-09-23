package org.t13.app.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class EncryptedPayload {

    private String data;
    private String key;

}