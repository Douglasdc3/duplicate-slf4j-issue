package org.example.test;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainPreloader extends Preloader {
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;

    private Stage preloaderStage;
    private Scene scene;

    private int totalSteps = 1;
    private Label step;
    private Label progress;
    private Label message;

    public MainPreloader() {
    }


    @Override
    public void init() {
        // If preloader has complex UI it's initialization can be done in MyPreloader#init
        Platform.runLater(() -> {
            Label title = new Label("Showing preloader stage!\nLoading, please wait...");
            title.setTextAlignment(TextAlignment.CENTER);
            step = new Label("0/" + totalSteps);
            progress = new Label("0/0");
            message = new Label("...");

            VBox root = new VBox(title, step, progress, message);
            root.setAlignment(Pos.CENTER);

            scene = new Scene(root, WIDTH, HEIGHT);
        });
    }

    @Override
    public void start(Stage primaryStage) {
        this.preloaderStage = primaryStage;

        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);
        preloaderStage.show();
    }

    public void handleStateChangeNotification(StateChangeNotification info) {
        // Handle state change notifications.
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                // Called after MyPreloader#start is called.
                break;
            case BEFORE_INIT:
                // Called before MyApplication#init is called.
                break;
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                preloaderStage.hide();
                break;
        }
    }
}
