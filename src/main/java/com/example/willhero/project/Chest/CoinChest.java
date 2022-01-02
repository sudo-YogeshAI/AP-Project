package com.example.willhero.project.Chest;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Player.Player;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class CoinChest extends Chest {
    private int coins;

    public CoinChest(ImageView image) {
        super(image);
        coins = 10+ (int)((Math.random()*100)%20);
    }

    @Override
    public void collect(Player player) {
        System.out.println("Collected");
        player.addCoin(coins);
        collected = true;
        Animations.TranslateXY(image, 500,-200, Duration.millis(500)).play();
        Animations.ScaleXY(image,0.1,0.1,Duration.millis(500)).play();
    }
}
