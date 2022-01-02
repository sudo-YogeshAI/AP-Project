package com.example.willhero.project.Chest;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Player.Helmet;
import com.example.willhero.project.Player.Player;
import com.example.willhero.project.Weapons.Hammer;
import com.example.willhero.project.Weapons.Weapon;
import com.example.willhero.project.Weapons.WeaponFactory;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class WeaponChest extends Chest{
    Weapon weapon;

    public WeaponChest(ImageView image) {
        super(image);
        weapon = WeaponFactory.getWeapon(null);
    }

    @Override
    public void collect(Player player) {
        collected = true;
        Animations.TranslateXY(image, -200,200, Duration.millis(500)).play();
        Animations.ScaleXY(image,0.1,0.1,Duration.millis(500)).play();
        Helmet.getInstance(null, null, null, null).collect(weapon);
    }
}
