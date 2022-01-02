package com.example.willhero.project.Chest;

import com.example.willhero.project.Player.Player;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Chest {
    protected ImageView image;
    protected Rectangle rectangle;
    protected boolean collected;

    public Chest(ImageView image) {
        this.image = image;
        this.rectangle = new Rectangle(image.getLayoutX(),image.getLayoutY(),70,50);
        rectangle.setLayoutX(image.getLayoutX());
        rectangle.setLayoutY(image.getLayoutY());
        collected = false;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isCollected() {
        return collected;
    }

    public abstract void collect(Player player);
}
