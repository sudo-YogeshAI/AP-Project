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

    public Player (Group environment, Text scoreText, ImageView img) {
        super(img,50, -50, -200,50);
        this.environment = environment;
        this.scoreText = scoreText;
        location = 0;
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
}
