package com.example.willhero.project.Weapons;

import com.example.willhero.project.Chest.Chest;
import com.example.willhero.project.Chest.CoinChest;
import javafx.scene.image.ImageView;

public class WeaponFactory {
    public static Weapon getWeapon(ImageView image) {
        int i= (int) (Math.random()*100)%2;
        if (i==0) {
            return Sword.getInstance(null, null);
        }
        return Hammer.getInstance(null, null);
    }
}
