package com.example.willhero.project.Weapons;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Extra.Collision;
import com.example.willhero.project.Orcs.Orc;
import com.example.willhero.project.Player.Player;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Sword extends Weapon{
    private static Sword sword = null;

    private Sword(ImageView image, Text text) {
        super(image, text, new Rectangle(0,-50,100,50));
    }

    public static Sword getInstance(ImageView image, Text text) {
        if (sword==null) {
            sword = new Sword(image, text);
        }
        return sword;
    }

    @Override
    public void attack(Player player, Orc orc) {
        System.out.println("Sword Attack");
        player.setFreezeAttack(true);
        TranslateTransition a1 = Animations.TranslateXYrev(image, (int) hitArea.getWidth(), 0, Duration.millis(500));
        a1.setOnFinished(actionEvent -> player.setFreezeAttack(false));
        a1.play();
        Rectangle temp = new Rectangle(player.getRectangle().getLayoutX()+hitArea.getLayoutX(), player.getRectangle().getLayoutY()+hitArea.getLayoutY(), hitArea.getWidth(), hitArea.getHeight());
        temp.setLayoutX(player.getRectangle().getLayoutX()+hitArea.getLayoutX());
        temp.setLayoutY(player.getRectangle().getLayoutY()+hitArea.getLayoutY());
        System.out.println(temp.getLayoutX()+" "+temp.getLayoutY()+" "+temp.getWidth()+" "+temp.getHeight());
        if (Collision.collisionRectRect(temp, orc.getRectangle())) {
            System.out.println("Sword hit");
            orc.damage(level);
        }
    }

    @Override
    public String toString() {
        if (level>0) {
            return "Sword (Level: " + level.toString() + ")";
        } else {
            return ("Sword: Unavailable");
        }
    }
}
