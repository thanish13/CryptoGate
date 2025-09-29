package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.t13.app.service.EncryptionService;


@RestController
@RequestMapping("/api/key")
public class KeyController {

    @Autowired
    EncryptionService encryptionService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestHeader String plainText) {
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    };

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody EncryptedPayload encryptedPayload) throws Exception {
        return encryptionService.decrypt(encryptedPayload);
    };


}

