package org.t13.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.print("Hello and welcome!");

        // Base Runner class (or interface)
        abstract class AbstractSpringBootRunner {
            protected final Class<?> applicationClass;

            public AbstractSpringBootRunner(Class<?> applicationClass) {
                this.applicationClass = applicationClass;
            }

            public abstract void start();
            public abstract void stop();
        }

        // Specific Runner for Application A
        class ApplicationARunner extends AbstractSpringBootRunner {
            private ConfigurableApplicationContext context;

            public ApplicationARunner() {
                super(TokenizationApp.class); // ApplicationA is your main Spring Boot class
            }

            @Override
            public void start() {
                context = SpringApplication.run(applicationClass);
            }

            @Override
            public void stop() {
                if (context != null) {
                    context.close();
                }
            }
        }

        List<AbstractSpringBootRunner> runners = new ArrayList<>();

        // Initialize and add runners for each application
        ApplicationARunner appARunner = new ApplicationARunner();
        runners.add(appARunner);

        // Assuming you have ApplicationB and ApplicationC
        // ApplicationBRunner appBRunner = new ApplicationBRunner();
        // runners.add(appBRunner);

        // Start all applications
        for (AbstractSpringBootRunner runner : runners) {
            runner.start();
            System.out.println("Started: " + runner.applicationClass.getSimpleName());
        }

        // You can add logic here to wait or interact with the running applications
        // For example, a shutdown hook to stop them gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (AbstractSpringBootRunner runner : runners) {
                runner.stop();
                System.out.println("Stopped: " + runner.applicationClass.getSimpleName());
            }
        }));

    }
}