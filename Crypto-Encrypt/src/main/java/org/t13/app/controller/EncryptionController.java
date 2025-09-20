package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.t13.app.model.EncryptedPayload;
import org.t13.app.service.EncryptionService;


@RestController
@RequestMapping("/api/crypto")
public class EncryptionController {

    @Autowired
    EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public EncryptedPayload encrypt(@RequestHeader String plainText) throws Exception {
        return encryptionService.encrypt(plainText);

    };

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody EncryptedPayload encryptedPayload) throws Exception {
        return encryptionService.decrypt(encryptedPayload);
    };


}

