package com.example.willhero.project.Orcs;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.GamePlatform;
import com.example.willhero.project.Player.Player;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class Boss extends Orc {
    private boolean entered;

    public Boss(ArrayList<GamePlatform> platforms, ImageView image, int posX) {
        super(platforms, image, 10, 100, 75, posX, 100);
        entered = false;
    }

    public void entry(Player player) {
        entered = true;
        player.setFreeze(true);
        TranslateTransition a1 = Animations.TranslateXY(image,0,300, Duration.millis(100));
        a1.setOnFinished(actionEvent -> player.setFreeze(false));
        a1.play();
    }

    public boolean isEntered() {
        return entered;
    }
}
