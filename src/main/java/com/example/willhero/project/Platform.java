package com.example.willhero.project;

import javafx.scene.shape.Rectangle;

public class Platform {
    private Rectangle rectangle;

    public Platform(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
