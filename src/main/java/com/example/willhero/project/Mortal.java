package com.example.willhero.project;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Mortal {
    protected double posX;
    private double posY;
    private ImageView image;
    private Rectangle rectangle;
    private boolean isAlive;
    private boolean isMovingUp;
    protected double forwardSteps;
    private double size;
    protected double stepsPerFrame;
    private double jumpHeight;
    private double offsetY;

    public Mortal(ImageView img, double size, double offsetX, double offsetY, double jumpHeight) {
        this.image = img;
        this.size = size;
        this.jumpHeight = jumpHeight;
        this.offsetY = offsetY;
        this.rectangle = new Rectangle(image.getLayoutX()+offsetX,image.getLayoutY()+offsetY,size,size);
        rectangle.setLayoutX(image.getLayoutX()+offsetX);
        rectangle.setLayoutY(image.getLayoutY()+offsetY);
        posX = 0;
        posY = -1*size;
        forwardSteps = 0;
        stepsPerFrame = 5;
        isAlive = true;
        isMovingUp = true;

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void updatePerFrame(ArrayList<GamePlatform> platforms) {
        // Animation
        if (isMovingUp) {
            posY-=1;
            image.setLayoutY(image.getLayoutY()-1);
            if (posY<=-1*size-jumpHeight) {
                isMovingUp=false;
            }
        }
        else {
            posY+=1;
            image.setLayoutY(image.getLayoutY()+1);
//            if (posY>=-50) {
//                isMovingUp=true;
//            }
            if (posY>=0) {
                isAlive = false;
            }
        }
        rectangle.setLayoutY(posY);

        // Fall Detection
        boolean onPlatform = false;
        for(GamePlatform platform: platforms) {
            boolean temp = Collision.collisionFromBottom(platform.getRectangle(),rectangle);
            onPlatform = onPlatform | temp;
            if (temp==true) {
                System.out.println(platform.getRectangle().getLayoutX()+" "+ platform.getRectangle().getLayoutY()+" "+ platform.getRectangle().getWidth()+" "+ platform.getRectangle().getHeight());
                System.out.println(rectangle.getLayoutX()+" "+ rectangle.getLayoutY()+" "+ rectangle.getWidth()+" "+ rectangle.getHeight()+"\n");
                isMovingUp = true;
                break;
            }
        }

        // Forward Movement
        if (forwardSteps>0) {
            posX+=stepsPerFrame;
            rectangle.setLayoutX(posX);
            forwardSteps -= stepsPerFrame;
        }
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public double getPosX() {
        return posX;
    }
}
