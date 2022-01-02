package com.example.willhero.project.Weapons;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Orcs.Orc;
import com.example.willhero.project.Player.Player;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Weapon {
    protected Integer level;
    private int degradeCounter;
    protected ImageView image;
    protected Rectangle hitArea;
    private Text text;

    public Weapon(ImageView image, Text text, Rectangle hitArea) {
        level = 0;
        degradeCounter = 480;
        this.image = image;
        this.text = text;
        this.hitArea = hitArea;
        text.setText(this.toString());
    }

    public void upgradePerFrame(Player player) {
        if (level>1) {
            degradeCounter--;
            if (degradeCounter<=0) {
                level--;
                degradeCounter=480;
                text.setText(this.toString());
            }
        }
        image.setLayoutY(player.getRectangle().getLayoutY()+202);
    }

    public void upgrade() {
        level++;
        text.setText(this.toString());
    }

    public abstract void attack(Player player, Orc orc);
}
