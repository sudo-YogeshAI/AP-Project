package com.example.willhero.project;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Collision {
    public static boolean collisionFromLeft(Rectangle rect1, Rectangle rect2) {
        if (rect1==null || rect2==null) {
            return false;
        }
        boolean returnValue;
        returnValue = (rect1.getLayoutY()<=rect2.getLayoutY() && rect2.getLayoutY()<=rect1.getLayoutY()+rect1.getHeight()) || (rect1.getLayoutY()<=rect2.getLayoutY()+ rect2.getHeight() && rect2.getLayoutY()+rect2.getHeight()<=rect1.getLayoutY()+rect1.getHeight());
        returnValue = returnValue && ( Math.abs(rect2.getLayoutX()+rect2.getWidth()-rect1.getLayoutX())<=0);
        return returnValue;
    }
    public static boolean collisionFromBottom(Rectangle rect1, Rectangle rect2) {
        if (rect1==null || rect2==null) {
            return false;
        }
        boolean returnValue;
        returnValue = (rect1.getLayoutX()<=rect2.getLayoutX() && rect2.getLayoutX()<=rect1.getLayoutX()+rect1.getWidth());
        returnValue = returnValue && ( Math.abs(rect2.getLayoutY()+rect2.getHeight()-rect1.getLayoutY())<=0);
        return returnValue;
//        Rectangle temp = new Rectangle(rect2.getLayoutX(),rect2.getLayoutY()+rect2.getHeight(),rect2.getWidth(),10);
//        return (rect1.getBoundsInParent().intersects(temp.getBoundsInParent()));
    }
    public static boolean collisionFromBottom(ImageView rect1, ImageView rect2) {
        if (rect1==null || rect2==null) {
            return false;
        }
        boolean returnValue = true;
        Rectangle temp = new Rectangle(rect2.getLayoutX(),rect2.getLayoutY()+rect2.getFitHeight(),rect2.getFitWidth(),10);
        return (rect1.getBoundsInParent().intersects(temp.getBoundsInParent()));
    }
    public static boolean collisionRectRect(Rectangle rect1, Rectangle rect2) {
        if (rect1 == null || rect2 == null) {
            return false;
        }
        return (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent()));
    }
    public static boolean collisionRectCircle(Rectangle rect1, Circle circle) {
        if (rect1 == null || circle == null) {
            return false;
        }
        return (rect1.getBoundsInParent().intersects(circle.getBoundsInParent()));
    }
}
