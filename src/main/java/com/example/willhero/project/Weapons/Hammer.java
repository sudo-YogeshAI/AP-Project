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

public class Hammer extends Weapon{
    public static Hammer hammer;

    private Hammer(ImageView image, Text text) {
        super(image, text, new Rectangle(0,-50,100,50));
    }

    public static Hammer getInstance(ImageView image, Text text) {
        if (hammer==null) {
            hammer = new Hammer(image, text);
        }
        return hammer;
    }

    @Override
    public void attack(Player player, Orc orc) {
        System.out.println("Hammer Attack");
        player.setFreezeAttack(true);
        TranslateTransition a1 = Animations.TranslateXYrev(image, (int) hitArea.getWidth(), -1*(int) hitArea.getHeight(), Duration.millis(500));
        a1.setOnFinished(actionEvent -> player.setFreezeAttack(false));
        a1.play();
        Animations.rotate360(image,Duration.millis(500)).play();
        Rectangle temp = new Rectangle(player.getRectangle().getLayoutX()+hitArea.getLayoutX(), player.getRectangle().getLayoutY()+hitArea.getLayoutY(), hitArea.getWidth(), hitArea.getHeight());
        temp.setLayoutX(player.getRectangle().getLayoutX()+hitArea.getLayoutX());
        temp.setLayoutY(player.getRectangle().getLayoutY()+hitArea.getLayoutY());
        if (Collision.collisionRectRect(temp, orc.getRectangle())) {
            System.out.println("Sword hit");
            orc.damage(2*level);
        }
    }

    @Override
    public String toString() {
        if (level>0) {
            return "Hammer (Level: " + level.toString() + ")";
        } else {
            return ("Hammer: Unavailable");
        }
    }
}
