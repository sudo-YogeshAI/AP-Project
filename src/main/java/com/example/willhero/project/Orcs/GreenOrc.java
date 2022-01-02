package com.example.willhero.project.Orcs;

import com.example.willhero.project.GamePlatform;
import com.example.willhero.project.Orcs.Orc;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GreenOrc extends Orc {
    public GreenOrc(ArrayList<GamePlatform> platforms, ImageView image, double posX) {
        super(platforms, image, 1, 50, 0, posX, 20);
    }
}
