package com.example.willhero.project;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Orc extends Mortal  {
    protected int health;
    ArrayList<GamePlatform> platforms;

    public Orc(ArrayList<GamePlatform> platforms, ImageView image, int health, int size) {
        super(image, size, 0,0, 30);
        this.platforms = platforms;
        this.health = health;
    }

    public void updatePerFrame() {
        super.updatePerFrame(platforms);

    }

    public void push() {
        forwardSteps = stepsPerFrame;
    }
}
