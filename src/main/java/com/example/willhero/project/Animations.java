package com.example.willhero.project;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animations {
    public static TranslateTransition slideUp(Node node, int dir) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByY(-400*dir);
        obj.setDuration(Duration.millis(500));
        return obj;
    }

    public static TranslateTransition jumpInfinite(Node node) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByY(-75);
        obj.setDuration(Duration.millis(500));
        obj.setCycleCount(TranslateTransition.INDEFINITE);
        obj.setAutoReverse(true);
        return obj;
    }

    public static ScaleTransition orcDieScale(Node node) {
        ScaleTransition obj = new ScaleTransition();
        obj.setNode(node);
        obj.setDuration(Duration.millis(500));
        obj.setFromY(1);
        obj.setToY(0);
        obj.setCycleCount(1);
        return obj;
    }

    public static TranslateTransition orcDieTranslate(Node node, double size) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setDuration(Duration.millis(500));
        obj.setByY(size);
        obj.setCycleCount(1);
        return obj;
    }
}
