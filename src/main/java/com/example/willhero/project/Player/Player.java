package com.example.willhero.project.Player;

import com.example.willhero.project.GamePlatform;
import com.example.willhero.project.Mortal;
import com.example.willhero.project.Orcs.Orc;
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
    private boolean isFreeze;
    private boolean freezeAttack;
    private Helmet boarHelmet;

    public Player (Group environment, Text scoreText, ImageView img, Text coinsText, ImageView sword, ImageView hammer, Text swordText, Text hammerText) {
        super(img,50, -50, -200,75,0);
        this.environment = environment;
        this.scoreText = scoreText;
        this.coinsText = coinsText;
        location = 0;
        coins = 0;
        boarHelmet = Helmet.getInstance(sword, hammer, swordText, hammerText);
        freezeAttack = false;
    }

    @Override
    public void updatePerFrame(ArrayList<GamePlatform> platforms) {
        if (!isFreeze) {
            if (forwardSteps > 0) {
                environment.setTranslateX(environment.getTranslateX() - stepsPerFrame);
                location = (int) posX / 50;
            }
            boarHelmet.updatePerFrame(this);
            super.updatePerFrame(platforms);
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

    public void setIsAlive(boolean value) {
        isAlive = value;
    }

    public boolean isFreeze() {
        return isFreeze;
    }

    public void setFreeze(boolean value) {
        isFreeze = value;
    }

    public void attack(Orc orc) {
        if (boarHelmet.getActiveWeapon()!=null) {
            boarHelmet.getActiveWeapon().attack(this, orc);
        }
    }

    public boolean isFreezeAttack() {
        return freezeAttack;
    }

    public void setFreezeAttack(boolean freezeAttack) {
        this.freezeAttack = freezeAttack;
    }
}
