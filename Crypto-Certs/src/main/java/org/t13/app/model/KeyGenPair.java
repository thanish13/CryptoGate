package org.t13.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class KeyGenPair {

    private String algorithm;
    private String keySize;
    private String publicKey;
    private String privateKey;

}