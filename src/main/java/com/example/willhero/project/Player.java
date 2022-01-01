package com.example.willhero.project;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Player extends Mortal {
    private Group environment;
    private Text scoreText;
    private Integer location;
    private Integer coins;
    private Text coinsText;

    public Player (Group environment, Text scoreText, ImageView img, Text coinsText) {
        super(img,50, -50, -200,100,0);
        this.environment = environment;
        this.scoreText = scoreText;
        this.coinsText = coinsText;
        location = 0;
        coins = 0;
    }

    @Override
    public void updatePerFrame(ArrayList<GamePlatform> platforms) {
        super.updatePerFrame(platforms);
        if (forwardSteps>0) {
            environment.setTranslateX(environment.getTranslateX()-stepsPerFrame);
            location = (int) posX/50;
        }
    }

    public void move() {
        forwardSteps = 50;
        scoreText.setText(location.toString());
    }

    public void addCoin(int coins) {
        this.coins += coins;
        this.coinsText.setText("Coins: "+this.coins.toString());
    }

    public Integer getLocation() {
        return location;
    }
}
