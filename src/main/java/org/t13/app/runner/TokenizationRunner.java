package org.t13.app.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.t13.app.TokenizationApp;

public class TokenizationRunner extends AbstractSpringBootRunner{

    public TokenizationRunner() {
        super(TokenizationApp.class); // ApplicationA is your main Spring Boot class
    }

}
