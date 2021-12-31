package com.example.willhero.project;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

public abstract class Orc {
    protected double positionX;
    protected Platform platform;
    protected int moveFrameCounter;
    protected int size;
    protected boolean isMoving;
    protected boolean isAlive;
    protected Rectangle rectangle;
    protected int health;

    public Orc(Platform platform,double positionX, Rectangle rectangle, int health) {
        this.platform = platform;
        this.positionX = positionX;
        this.isMoving = false;
        this.isAlive = true;
        this.health = health;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public double getPositionX() {
        return positionX;
    }
    public void damage(int value) {
        this.health-=value;
        if (this.health<=0) {
            this.isAlive = false;
        }
    }
}
