package com.example.willhero.project;

import com.example.willhero.project.Chest.Chest;
import com.example.willhero.project.Chest.ChestFactory;
import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Extra.Collision;
import com.example.willhero.project.Obstacles.Obstacle;
import com.example.willhero.project.Obstacles.TNT;
import com.example.willhero.project.Orcs.Boss;
import com.example.willhero.project.Orcs.GreenOrc;
import com.example.willhero.project.Orcs.Orc;
import com.example.willhero.project.Orcs.RedOrc;
import com.example.willhero.project.Player.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends Application {
    private Player player;
    private int coins;
    private boolean isRunning;
    private ArrayList<GamePlatform> platforms;
    private ArrayList<Orc> orcs;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Chest> chests;
    private Boss boss;
    private Orc currentOrc;
    private Obstacle currentObstacle;
    private Chest currentChest;


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
                if (keyEvent.getCode()== KeyCode.RIGHT && !player.isFreeze()) {
                    if (gameActive) {
                        player.move();
                        System.out.println("Right");
                        System.out.println(player.getRectangle().getLayoutX()+" "+player.getRectangle().getLayoutY()+" "+player.getRectangle().getWidth()+" "+player.getRectangle().getHeight());
                    }
                }
                if (keyEvent.getCode()== KeyCode.P && !player.isFreeze()) {
                    if (gameActive) {
                        controller.pause();
                        System.out.println("Right");
                    }
                }
                if (keyEvent.getCode()== KeyCode.SPACE && !player.isFreezeAttack()) {
                    if (gameActive) {
                        player.attack(currentOrc);
                        System.out.println("Attack");
                    }
                }
            }
        });
        currentOrc = orcs.get(0);
        currentObstacle = obstacles.get(0);
        currentChest = chests.get(0);
        AnimationTimer fps = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (!player.getIsAlive()) {
                    stop();
                    controller.pause();
                }
                updatePerFrame();
            }
        };
        fps.start();

    }

    private void updatePerFrame() {
        // Updating Players and Orcs
        player.updatePerFrame(platforms);
        for (Orc orc: orcs) {
            orc.updatePerFrame(player);
        }
        boss.updatePerFrame(player);
        if (currentObstacle!=null) {
            currentObstacle.updatePerFrame(player);
        }


        // Collision with orc
        if (orcs.size()>0) {
            if (currentOrc!=null && currentOrc.getIsAlive()) {
                // Player Pushes Orc
                boolean orcPush = Collision.collisionFromLeft(currentOrc.getRectangle(), player.getRectangle());
                if (orcPush) {
                    System.out.println("Yo");
                    currentOrc.push();
                }
                // Player Kills Orc
                else if (Collision.collisionFromBottom(currentOrc.getRectangle(), player.getRectangle())) {
                    System.out.println("Killed");
                    currentOrc.damage(100);
                }
                if (!currentOrc.getIsAlive()) {
                    currentOrc.kill(player);
                    currentOrc = null;
                }
                // Orc Kills Player
                if ( currentOrc!=null && Collision.collisionFromBottom(player.getRectangle(), currentOrc.getRectangle())) {
                    player.setIsAlive(false);
                    System.out.println("Dead");
                }
            }
        }

        // Collision with obstacles
        if (obstacles.size()>0) {
            if (currentObstacle!=null) {
                if (!((TNT) currentObstacle).isActive() && Collision.collisionRectRect(currentObstacle.getRectangle(), player.getRectangle())) {
                    System.out.println("BOOM");
                    currentObstacle.onCollision();
                }
            }
        }

        // Collision with chest
        if (chests.size()>0) {
            if (currentChest!=null) {
                if (!currentChest.isCollected() && Collision.collisionRectRect(currentChest.getRectangle(), player.getRectangle())) {
                    System.out.println("Collected");
                    currentChest.collect(player);
                }
            }
        }

        // Update current Objects
        // Update currentOrc
        int pos = player.getLocation();
        if (pos<20) {
            currentOrc = orcs.get(0);
        } else if (pos<30) {
            currentOrc = orcs.get(1);
        } else if (pos<45) {
            currentOrc = orcs.get(2);
        } else if (pos<65) {
            currentOrc = orcs.get(3);
        } else if (pos<80) {
            currentOrc = orcs.get(4);
        } else if (pos<90) {
            currentOrc = orcs.get(5);
        } else if (pos<105) {
            currentOrc = orcs.get(6);
        } else {
            currentOrc = boss;
        }
        if (pos==106) {
            if (!boss.isEntered()) {
                boss.entry(player);
            }
        }

        // Update Chest
        if (pos<60) {
            currentChest = chests.get(0);
        } else if (pos<80) {
            currentChest = chests.get(1);
        } else {
            currentChest = chests.get(2);
        }

    }

    private void setup(GameController controller) {
        // Setting up player
        this.player = new Player(controller.getEnvironment(), controller.getScoreText(), controller.getPlayerImg(), controller.getCoinsText(), controller.getSword(), controller.getHammer(), controller.getSwordText(), controller.getHammerText());
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
        temp.add(platforms.get(4));
        this.orcs.add(new GreenOrc(platforms,controller.getGreenOrc1(), 630));
        this.orcs.add(new RedOrc(platforms,controller.getRedOrc1(), 1200));
        this.orcs.add(new GreenOrc(platforms,controller.getGreenOrc2(), 2050));
        this.orcs.add(new GreenOrc(platforms,controller.getGreenOrc3(), 3000));
        this.orcs.add(new RedOrc(platforms,controller.getRedOrc2(), 3700));
        this.orcs.add(new GreenOrc(platforms,controller.getGreenOrc4(), 4250));
        this.orcs.add(new RedOrc(platforms,controller.getRedOrc3(), 5050));
        this.boss = new Boss(platforms, controller.getBoss(), 5450);

        // Setting up obstacles
        this.obstacles = new ArrayList<Obstacle>();
        obstacles.add(new TNT(controller.getTnt3(), controller.getExplosion()));

        // Setting up chests
        this.chests = new ArrayList<Chest>();
        this.chests.add(ChestFactory.getChest(controller.getChest1()));
        this.chests.add(ChestFactory.getChest(controller.getChest2()));
        this.chests.add(ChestFactory.getChest(controller.getChest3()));

    }

    public static void main(String[] args) {

        launch();
    }
}
