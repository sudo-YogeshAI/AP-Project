package com.example.willhero.project.Obstacles;

import com.example.willhero.project.Player.Player;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Obstacle {
    protected ImageView image;
    protected Rectangle rectangle;

    public Obstacle(ImageView image, double width, double height) {
        this.image = image;
        this.rectangle = new Rectangle(image.getLayoutX(),image.getLayoutY(),width,height);
        rectangle.setLayoutX(image.getLayoutX());
        rectangle.setLayoutY(image.getLayoutY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public abstract void onCollision();
    public abstract void updatePerFrame(Player player);
}
