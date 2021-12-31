package com.example.willhero.project;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Collision {
    public static boolean collisionFromLeft(Rectangle rect1, Rectangle rect2) {
        if (rect1==null || rect2==null) {
            return false;
        }
        Rectangle temp = new Rectangle(rect2.getX(),rect2.getY(), 1,rect2.getHeight());
        return (rect1.getBoundsInParent().intersects(temp.getBoundsInParent()));
    }
    public static boolean collisionFromBottom(Rectangle rect1, Rectangle rect2) {
        if (rect1==null || rect2==null) {
            return false;
        }
        Rectangle temp = new Rectangle(rect2.getX(),rect2.getY(),rect2.getWidth(),1);
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
