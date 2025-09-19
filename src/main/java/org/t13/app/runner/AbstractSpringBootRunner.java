package org.t13.app.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class AbstractSpringBootRunner {

    protected final Class<?> applicationClass;

    private ConfigurableApplicationContext context;

    public AbstractSpringBootRunner(Class<?> applicationClass) {
        this.applicationClass = applicationClass;
    }

    public void start() {
        context = SpringApplication.run(applicationClass);
    }

    public void stop() {
        if (context != null) {
            context.close();
        }
    }
}