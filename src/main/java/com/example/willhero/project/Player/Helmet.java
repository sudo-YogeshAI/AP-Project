package com.example.willhero.project.Player;

import com.example.willhero.project.Weapons.Hammer;
import com.example.willhero.project.Weapons.Sword;
import com.example.willhero.project.Weapons.Weapon;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Helmet {
    private ArrayList<Weapon> weapons;
    private Weapon activeWeapon;
    private static Helmet helmet=null;

    private Helmet(ImageView sword, ImageView hammer, Text swordText, Text hammerText) {
        weapons = new ArrayList<Weapon>();
        weapons.add(Sword.getInstance(sword, swordText));
        weapons.add(Hammer.getInstance(hammer, hammerText));
    }

    public static Helmet getInstance(ImageView sword, ImageView hammer, Text swordText, Text hammerText) {
        if (helmet==null) {
            helmet = new Helmet(sword, hammer, swordText, hammerText);
        }
        return helmet;
    }

    public void collect(Weapon weapon) {
        weapon.upgrade();
        activeWeapon = weapon;
    }

    public void updatePerFrame(Player player) {
        for (Weapon weapon: weapons) {
            weapon.upgradePerFrame(player);
        }
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }
}
