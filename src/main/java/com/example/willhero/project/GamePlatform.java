package com.example.willhero.project;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class GamePlatform {
    private ImageView image;
    private Rectangle rectangle;

    public GamePlatform(ImageView image) {
        this.image = image;
        this.rectangle = new Rectangle(image.getLayoutX(),image.getLayoutY(),image.getFitWidth(),image.getFitHeight());
        System.out.println(image.getLayoutX()+" "+image.getLayoutY()+" "+image.getFitWidth()+" "+image.getFitHeight());
        rectangle.setX(image.getLayoutX());
        rectangle.setLayoutX(image.getLayoutX());
        rectangle.setY(image.getLayoutY());
        rectangle.setLayoutY(image.getLayoutY());
    }

    public ImageView getImage() {
        return image;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
