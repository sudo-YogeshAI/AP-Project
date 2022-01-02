package com.example.willhero.project.Extra;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
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
        obj.setDuration(Duration.millis(700));
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

    public static ScaleTransition danger(Node node) {
        ScaleTransition obj = new ScaleTransition();
        obj.setNode(node);
        obj.setFromY(1);
        obj.setToY(1.2);
        obj.setFromX(1);
        obj.setToX(1.2);
        obj.setDuration(Duration.millis(500));
        obj.setCycleCount(TranslateTransition.INDEFINITE);
        obj.setAutoReverse(true);
        return obj;
    }
    public static ScaleTransition explode(Node node) {
        ScaleTransition obj = new ScaleTransition();
        obj.setNode(node);
        obj.setFromY(1);
        obj.setToY(5);
        obj.setFromX(1);
        obj.setToX(5);
        obj.setDuration(Duration.millis(500));
        obj.setCycleCount(1);
        obj.setAutoReverse(true);
        return obj;
    }

    public static TranslateTransition TranslateXY(Node node, int X, int Y, Duration duration) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByX(X);
        obj.setByY(Y);
        obj.setDuration(duration);
        return obj;
    }

    public static TranslateTransition TranslateXYrev(Node node, int X, int Y, Duration duration) {
        TranslateTransition obj = new TranslateTransition();
        obj.setNode(node);
        obj.setByX(X);
        obj.setByY(Y);
        obj.setDuration(duration);
        obj.setAutoReverse(true);
        obj.setCycleCount(2);
        return obj;
    }

    public static RotateTransition rotate360(Node node, Duration duration) {
        RotateTransition obj = new RotateTransition();
        obj.setNode(node);
        obj.setAxis(Rotate.Z_AXIS);
        obj.setByAngle(360);
        obj.setCycleCount(RotateTransition.INDEFINITE);
        obj.setDuration(duration);
        return obj;
    }

    public static ScaleTransition ScaleXY(Node node, double X, double Y, Duration duration) {
        ScaleTransition obj = new ScaleTransition();
        obj.setNode(node);
        obj.setFromX(1);
        obj.setFromY(1);
        obj.setToX(X);
        obj.setToY(Y);
        obj.setDuration(duration);
        return obj;
    }
}
