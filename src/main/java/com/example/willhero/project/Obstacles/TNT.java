package com.example.willhero.project.Obstacles;

import com.example.willhero.project.Extra.Animations;
import com.example.willhero.project.Player.Player;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TNT extends Obstacle{
    private boolean isActive;
    private int activeTimer;
    private boolean isExploded;
    private boolean isExplosionActive;
    private int explodedTimer;
    private boolean enabled;
    private ScaleTransition active;
    private ScaleTransition explode;
    private Image explosionImage;

    public TNT(ImageView image, Image explosionImage) {
        super(image, 35, 25);
        this.explosionImage = explosionImage;
        isActive = false;
        isExploded = false;
        isExplosionActive = false;
        enabled = true;
        activeTimer = 60;
        explodedTimer = 60;
        active = null;
        explode = null;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isExploded() {
        return isExploded;
    }

    public void onCollision() {
        isActive = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void updatePerFrame(Player player) {
        if (isActive) {
            System.out.println("Active");
            if (active==null) {
                active = Animations.danger(image);
                active.play();
                player.setFreeze(true);
            }
            activeTimer--;
            if (activeTimer<=0) {
                active.stop();
                isExplosionActive = true;
                isActive = false;
                image.setImage(explosionImage);
            }
        }
        else if (isExplosionActive) {
            System.out.println("Explosion");
            if (explode==null) {
                explode = Animations.explode(image);
                explode.play();
            }
            explodedTimer--;
            if (explodedTimer==0) {
                isExploded = true;
                player.setIsAlive(false);
            }
        }
    }
}
