package com.example.willhero.project.Orcs;

import com.example.willhero.project.GamePlatform;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class RedOrc extends Orc{
    public RedOrc(ArrayList<GamePlatform> platforms, ImageView image, double posX) {
        super(platforms, image, 3, 50, 100, posX, 50);
    }
}
