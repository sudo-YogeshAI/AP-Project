package com.example.willhero.project;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private Group environment;

    @FXML
    private ImageView playerImg;

    @FXML
    private Text scoreText;

    @FXML
    private ImageView greenOrc1;

    @FXML
    private Group playButton;

    @FXML
    private Group menu;
    @FXML
    private Group loadButton;
    @FXML
    private Group saveButton;

    @FXML
    private Rectangle platform1;
    @FXML
    private Rectangle platform2;
    @FXML
    private Rectangle platform3;
    @FXML
    private Rectangle platform4;
    @FXML
    private Rectangle platform5;
    @FXML
    private Rectangle platform6;
    @FXML
    private Rectangle platform7;
    @FXML
    private Rectangle platform8;
    @FXML
    private Rectangle platform9;
    @FXML
    private Rectangle platform10;
    @FXML
    private Rectangle platform11;
    @FXML
    private Rectangle platform12;
    @FXML
    private Rectangle platform13;
    @FXML
    private Rectangle platform14;
    @FXML
    private Rectangle platform15;
    @FXML
    private Rectangle platform16;
    @FXML
    private Rectangle platform17;
    @FXML
    private Rectangle platform18;
    @FXML
    private Rectangle platform19;
    @FXML
    private Rectangle platform20;
    @FXML
    private Rectangle platform21;
    @FXML
    private Rectangle platform22;
    @FXML
    private Rectangle platform23;

    public Group getEnvironment() {
        return environment;
    }

    public Text getScoreText() {
        return scoreText;
    }

    private boolean gameActive = false;

    public boolean isGameActive() {
        return gameActive;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jumpInfinite(playerImg).play();
        jumpInfinite(greenOrc1).play();
    }

    private TranslateTransition jumpInfinite(Node node) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByY(-75);
        obj.setDuration(Duration.millis(500));
        obj.setCycleCount(TranslateTransition.INDEFINITE);
        obj.setAutoReverse(true);
        return obj;
    }

    private TranslateTransition slideUp(Node node, int dir) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByY(-400*dir);
        obj.setDuration(Duration.millis(500));
        return obj;
    }

    public void play() {
        gameActive = true;
        slideUp(menu, -1).play();
        saveButton.setDisable(false);
        saveButton.setVisible(true);
    }

    public void pause() {
        gameActive = false;
        slideUp(menu, 1).play();
    }
}