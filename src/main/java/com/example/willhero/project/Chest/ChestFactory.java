package com.example.willhero.project.Chest;

import javafx.scene.image.ImageView;

public class ChestFactory {
    public static Chest getChest(ImageView image) {
        int i= (int) (Math.random()*100)%2;
        if (i==0) {
            return new CoinChest(image);
        }
        return new WeaponChest(image);
    }
}
