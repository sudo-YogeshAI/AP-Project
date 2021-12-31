package com.example.willhero.project;

import com.example.willhero.project.GameController;
import com.example.willhero.project.HelloApplication;
import com.example.willhero.project.Player;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends Application {
    private Player player;
    private int coins;
    private boolean isRunning;
    private ArrayList<GamePlatform> platforms;
    private ArrayList<Orc> orcs;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        GameController controller = ((GameController) fxmlLoader.getController());
        setup(controller);
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
        AnimationTimer fps = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // Updating Players and Orcs
                player.updatePerFrame(platforms);
                for (Orc orc: orcs) {
                    orc.updatePerFrame();
                }
                if (!player.getIsAlive()) {
                    stop();
                    controller.pause();
                }

                // Collision with orc
                if (orcs.size()>0) {
                    Orc orc = orcs.get(0);
                    boolean orcPush = Collision.collisionFromLeft(player.getRectangle(), orc.getRectangle());
                    if (orcPush) {
                        System.out.println("Yo");
                        orc.push();
                    }
                }
            }
        };
        fps.start();

    }

    private void setup(GameController controller) {
        // Setting up player
        this.player = new Player(controller.getEnvironment(), controller.getScoreText(), controller.getPlayerImg());
        // Setting up platforms
        this.platforms = new ArrayList<GamePlatform>();
        this.platforms.add(new GamePlatform(controller.getPlatform1()));
        this.platforms.add(new GamePlatform(controller.getPlatform2()));
        this.platforms.add(new GamePlatform(controller.getPlatform3()));
        this.platforms.add(new GamePlatform(controller.getPlatform4()));
        this.platforms.add(new GamePlatform(controller.getPlatform5()));
        this.platforms.add(new GamePlatform(controller.getPlatform6()));
        this.platforms.add(new GamePlatform(controller.getPlatform7()));
        this.platforms.add(new GamePlatform(controller.getPlatform8()));
        this.platforms.add(new GamePlatform(controller.getPlatform9()));
        this.platforms.add(new GamePlatform(controller.getPlatform10()));
        this.platforms.add(new GamePlatform(controller.getPlatform11()));
        this.platforms.add(new GamePlatform(controller.getPlatform12()));
        this.platforms.add(new GamePlatform(controller.getPlatform13()));
        this.platforms.add(new GamePlatform(controller.getPlatform14()));
        this.platforms.add(new GamePlatform(controller.getPlatform15()));
        this.platforms.add(new GamePlatform(controller.getPlatform16()));
        this.platforms.add(new GamePlatform(controller.getPlatform17()));
        this.platforms.add(new GamePlatform(controller.getPlatform18()));
        this.platforms.add(new GamePlatform(controller.getPlatform19()));
        this.platforms.add(new GamePlatform(controller.getPlatform20()));
        this.platforms.add(new GamePlatform(controller.getPlatform21()));
        this.platforms.add(new GamePlatform(controller.getPlatform22()));
        this.platforms.add(new GamePlatform(controller.getPlatform23()));

        // Setting up orcs
        this.orcs = new ArrayList<Orc>();
        ArrayList<GamePlatform> temp = new ArrayList<GamePlatform>();
        temp.add(platforms.get(2));
        temp.add(platforms.get(3));
        this.orcs.add(new GreenOrc(temp,controller.getGreenOrc1()));

    }

    public static void main(String[] args) {

        launch();
    }
}
