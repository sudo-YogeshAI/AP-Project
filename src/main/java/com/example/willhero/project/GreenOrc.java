package com.example.willhero.project;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GreenOrc extends Orc{
    public GreenOrc(ArrayList<GamePlatform> platforms, ImageView image, double posX) {
        super(platforms, image, 1, 50, 50, posX, 20);
    }
}
