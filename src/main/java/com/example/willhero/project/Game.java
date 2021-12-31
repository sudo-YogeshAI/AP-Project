package com.example.willhero.project;

import com.example.willhero.project.GameController;
import com.example.willhero.project.HelloApplication;
import com.example.willhero.project.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    private Player player;
    private int coins;
    private boolean isRunning;
    private Platform[] platforms;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        GameController controller = ((GameController) fxmlLoader.getController());
        this.player = new Player(controller.getEnvironment(), controller.getScoreText());
        boolean gameActive = true;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode()== KeyCode.RIGHT) {
                    if (gameActive) {
                        player.move();
                        System.out.println("Right");
                    }
                }
                if (keyEvent.getCode()== KeyCode.P) {
                    if (gameActive) {
                        controller.pause();
                        System.out.println("Right");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        launch();
    }
}
