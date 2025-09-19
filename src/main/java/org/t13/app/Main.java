package org.t13.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Base Runner class (or interface)
        abstract class AbstractSpringBootRunner {
            protected Class<?> applicationClass;

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

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
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