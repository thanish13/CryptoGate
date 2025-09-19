package org.t13.app;

import lombok.extern.slf4j.Slf4j;
import org.t13.app.runner.AbstractSpringBootRunner;
import org.t13.app.runner.TokenizationRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {

        System.out.print("Hello and welcome!");

        List<AbstractSpringBootRunner> runners = new ArrayList<>();

        // Initialize and add runners for each application

        runners.add(new TokenizationRunner());

        // Assuming you have ApplicationB and ApplicationC
        // ApplicationBRunner appBRunner = new ApplicationBRunner();
        // runners.add(appBRunner);

        // Start all applications
        for (AbstractSpringBootRunner runner : runners) {
            runner.start();
            log.info("Started: {}", runner.getClass().getSimpleName());
        }

        // You can add logic here to wait or interact with the running applications
        // For example, a shutdown hook to stop them gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (AbstractSpringBootRunner runner : runners) {
                runner.stop();
                log.info("Stopped: {}", runner.getClass().getSimpleName());
            }
        }));

    }
}