package org.example.test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MainApplication extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setOnCloseRequest((e) -> Platform.exit());

        Map<String, String> args = parseArguments(Main.args);

        try {
            primaryStage.show();
        } catch (Exception ex) {
            LoggerFactory.getLogger(MainApplication.class).error("Something went wrong while starting the application");
            LoggerFactory.getLogger(MainApplication.class).error(ex.toString());

            ex.printStackTrace();
        }
    }

    private Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();

        LoggerFactory.getLogger(getClass()).info("Application arguments: ");
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].startsWith("-D")) {
                i++;
            }

            String key = args[i].replace("--", "").toLowerCase();
            String value = args[i + 1];

            LoggerFactory.getLogger(getClass()).info("{} => {}", key, value);
            arguments.put(key, value);
        }

        return arguments;
    }
}
