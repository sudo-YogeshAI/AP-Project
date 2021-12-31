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
    private ImageView platform1;
    @FXML
    private ImageView platform2;
    @FXML
    private ImageView platform3;
    @FXML
    private ImageView platform4;
    @FXML
    private ImageView platform5;
    @FXML
    private ImageView platform6;
    @FXML
    private ImageView platform7;
    @FXML
    private ImageView platform8;
    @FXML
    private ImageView platform9;
    @FXML
    private ImageView platform10;
    @FXML
    private ImageView platform11;
    @FXML
    private ImageView platform12;
    @FXML
    private ImageView platform13;
    @FXML
    private ImageView platform14;
    @FXML
    private ImageView platform15;
    @FXML
    private ImageView platform16;
    @FXML
    private ImageView platform17;
    @FXML
    private ImageView platform18;
    @FXML
    private ImageView platform19;
    @FXML
    private ImageView platform20;
    @FXML
    private ImageView platform21;
    @FXML
    private ImageView platform22;
    @FXML
    private ImageView platform23;

    public Group getEnvironment() {
        return environment;
    }

    public Text getScoreText() {
        return scoreText;
    }

    // getPlatform() //
    public ImageView getPlatform1() {
        return platform1;
    }
    public ImageView getPlatform2() {
        return platform2;
    }
    public ImageView getPlatform3() {
        return platform3;
    }
    public ImageView getPlatform4() {
        return platform4;
    }
    public ImageView getPlatform5() {
        return platform5;
    }
    public ImageView getPlatform6() {
        return platform6;
    }
    public ImageView getPlatform7() {
        return platform7;
    }
    public ImageView getPlatform8() {
        return platform8;
    }
    public ImageView getPlatform9() {
        return platform9;
    }
    public ImageView getPlatform10() {
        return platform10;
    }
    public ImageView getPlatform11() {
        return platform11;
    }
    public ImageView getPlatform12() {
        return platform12;
    }
    public ImageView getPlatform13() {
        return platform13;
    }
    public ImageView getPlatform14() {
        return platform14;
    }
    public ImageView getPlatform15() {
        return platform15;
    }
    public ImageView getPlatform16() {
        return platform16;
    }
    public ImageView getPlatform17() {
        return platform17;
    }
    public ImageView getPlatform18() {
        return platform18;
    }
    public ImageView getPlatform19() {
        return platform19;
    }
    public ImageView getPlatform20() {
        return platform20;
    }
    public ImageView getPlatform21() {
        return platform21;
    }
    public ImageView getPlatform22() {
        return platform22;
    }
    public ImageView getPlatform23() {
        return platform23;
    }

    private boolean gameActive = false;

    public boolean isGameActive() {
        return gameActive;
    }

    public ImageView getPlayerImg() {
        return playerImg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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