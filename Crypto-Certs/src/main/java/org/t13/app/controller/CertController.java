package org.t13.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.t13.app.runner.KeytoolRunner;
import org.t13.app.service.KeyGenService;


@RestController
@RequestMapping("/api/cert")
public class CertController {

    @Autowired
    KeyGenService keyGenService;

    @PostMapping("/genkeypair")
    public void genkeypair(@RequestHeader String plainText) throws Exception {
         KeytoolRunner.main(new String[]{});

    };

    @PostMapping("/decrypt")
    public String decrypt() throws Exception {
        return "";
    };


}

