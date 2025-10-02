package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.t13.app.service.EncryptionService;


@RestController
@RequestMapping("/api/cert")
public class CertController {

    @Autowired
    EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public void encrypt(@RequestHeader String plainText) throws Exception {
        return ;

    };

    @PostMapping("/decrypt")
    public String decrypt() throws Exception {
        return "";
    };


}

