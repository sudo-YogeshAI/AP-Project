package com.example.willhero.project;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Player {
    private Group environment;
    private Text scoreText;
    private double posX;
    private Integer location;

    public Player (Group environment, Text scoreText) {
        this.environment = environment;
        this.scoreText = scoreText;
        posX = 0;
    }

    public void move() {
        posX+=50;
        environment.setTranslateX(-1*posX);
        location = (int) posX/50;
        scoreText.setText(location.toString());
    }
}
