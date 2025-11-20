package org.t13.app;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class PrivateKeyRunner {

    public static void main(String[] args) {
        try {
            // Define the keytool command and its arguments
            // Replace with your actual keytool command and desired arguments

            String[] command = {
                    "openssl",
                    "genrsa" ,
                    "-out", "private.pem",
                    "2048"
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