package com.example.willhero.project.Orcs;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.GamePlatform;
import com.example.willhero.project.Mortal;
import com.example.willhero.project.Player.Player;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Orc extends Mortal {
    protected int health;
    ArrayList<GamePlatform> platforms;
    private int killPoints;
    public int size;
    private boolean forceKill;

    public Orc(ArrayList<GamePlatform> platforms, ImageView image, int health, int size, double jumpHeight, double posX, int killPoints) {
        super(image, size, 0,0, jumpHeight, posX);
        this.platforms = platforms;
        this.health = health;
        this.killPoints = killPoints;
        this.size = size;
        forceKill = false;
    }

    public void updatePerFrame(Player player) {
        boolean temp = isAlive;
        super.updatePerFrame(platforms);
        if (forwardSteps>0) {
            image.setLayoutX(image.getLayoutX()+stepsPerFrame);
            System.out.println(rectangle.getLayoutX()+" "+rectangle.getLayoutY()+" "+rectangle.getWidth()+" "+rectangle.getHeight());
        }
        if (temp!=isAlive) {
            kill(player);
        }
        if (forceKill) {
            kill(player);
            forceKill = false;
        }
    }

    public void push() {
        forwardSteps = 2*stepsPerFrame;
    }

    public void damage(int damage) {
        health-=damage;
        if (health<=0) {
            isAlive = false;
            forceKill = true;
        }
    }

    public int getKillPoints() {
        return killPoints;
    }

    public void kill(Player player) {
        Animations.orcDieScale(this.getImage()).play();
        Animations.orcDieTranslate(this.getImage(), size).play();
        player.addCoin(this.getKillPoints());
    }
}
