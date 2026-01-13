package org.t13.app.runner;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

@Slf4j
public class KeytoolRunner {

    public static void main(String[] args) {
        try {
            // Define the keytool command and its arguments
            // Replace with your actual keytool command and desired arguments
            String[] command = {
                    "keytool",
                    "-genkeypair",
                    "-alias", "mykey",
                    "-keyalg", "RSA",
                    "-keysize", "2048",
                    "-dname", "CN=MyName, OU=MyOrgUnit, O=MyOrg, L=MyCity, ST=MyState, C=US",
                    "-validity", "365",
                    "-keystore", "mykeystore.jks",
                    "-storepass", "password",
                    "-keypass", "password"
            };

            // Create a ProcessBuilder instance
            ProcessBuilder pb = new ProcessBuilder(command);

            // Redirect error stream to output stream for easier debugging
            pb.redirectErrorStream(true);

            // Start the process
            Process process = pb.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Keytool process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}