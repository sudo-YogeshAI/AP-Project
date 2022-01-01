package com.example.willhero.project;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Orc extends Mortal  {
    protected int health;
    ArrayList<GamePlatform> platforms;
    private int killPoints;

    public Orc(ArrayList<GamePlatform> platforms, ImageView image, int health, int size, double jumpHeight, double posX, int killPoints) {
        super(image, size, 0,0, jumpHeight, posX);
        this.platforms = platforms;
        this.health = health;
        this.killPoints = killPoints;
    }

    public void updatePerFrame() {
        super.updatePerFrame(platforms);
        if (forwardSteps>0) {
            image.setLayoutX(image.getLayoutX()+stepsPerFrame);
            //image.setX(image.getX()+stepsPerFrame);
            System.out.println(rectangle.getLayoutX()+" "+rectangle.getLayoutY()+" "+rectangle.getWidth()+" "+rectangle.getHeight());
        }
    }

    public void push() {
        forwardSteps = 5*stepsPerFrame;
    }

    public void damage(int damage) {
        health-=damage;
        if (health<=0) {
            isAlive = false;
        }
    }

    public int getKillPoints() {
        return killPoints;
    }
}
