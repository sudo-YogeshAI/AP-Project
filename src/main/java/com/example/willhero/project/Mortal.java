package com.example.willhero.project;

import com.example.willhero.project.Extra.Collision;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Mortal {
    protected double posX;
    private double posY;
    protected ImageView image;
    protected Rectangle rectangle;
    protected boolean isAlive;
    private boolean isMovingUp;
    protected double forwardSteps;
    private double size;
    protected double stepsPerFrame;
    private double jumpHeight;
    private double offsetY;

    public Mortal(ImageView img, double size, double offsetX, double offsetY, double jumpHeight, double posX) {
        this.image = img;
        this.size = size;
        this.jumpHeight = jumpHeight;
        this.offsetY = offsetY;
        this.posX = posX;
        this.rectangle = new Rectangle(image.getLayoutX()+offsetX,image.getLayoutY()+offsetY,size,size);
        rectangle.setLayoutX(image.getLayoutX()+offsetX);
        rectangle.setLayoutY(image.getLayoutY()+offsetY);
        System.out.println(rectangle.getLayoutX()+" "+rectangle.getLayoutY()+" "+rectangle.getWidth()+" "+rectangle.getHeight());
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
        for(GamePlatform platform: platforms) {
            boolean temp = Collision.collisionFromBottom(platform.getRectangle(),rectangle);
            if (temp==true) {
//                System.out.println(platform.getRectangle().getLayoutX()+" "+ platform.getRectangle().getLayoutY()+" "+ platform.getRectangle().getWidth()+" "+ platform.getRectangle().getHeight());
//                System.out.println(rectangle.getLayoutX()+" "+ rectangle.getLayoutY()+" "+ rectangle.getWidth()+" "+ rectangle.getHeight()+"\n");
                isMovingUp = true;
                break;
            }
        }

        // Forward Movement
        if (forwardSteps>0) {
            posX += stepsPerFrame;
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

    public ImageView getImage() {
        return image;
    }
}
