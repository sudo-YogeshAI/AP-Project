package com.example.willhero.project;

import com.example.willhero.project.Extra.Animations;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    // Importing Player
    @FXML
    private ImageView playerImg;
    @FXML
    private Group environment;
    @FXML
    private Text scoreText;
    @FXML
    private Text coinsText;
    @FXML
    private ImageView sword;
    @FXML
    private ImageView hammer;
    @FXML
    private Text swordText;
    @FXML
    private Text hammerText;

    @FXML
    private Group playButton;

    @FXML
    private Group menu;
    @FXML
    private Group loadButton;
    @FXML
    private Group saveButton;

    // Importing Platforms //
    @FXML
    private ImageView platform1;
    @FXML
    private ImageView platform2;
    @FXML
    private ImageView platform3;
    @FXML
    private ImageView platform4;
    @FXML
    private ImageView platform5;
    @FXML
    private ImageView platform6;
    @FXML
    private ImageView platform7;
    @FXML
    private ImageView platform8;
    @FXML
    private ImageView platform9;
    @FXML
    private ImageView platform10;
    @FXML
    private ImageView platform11;
    @FXML
    private ImageView platform12;
    @FXML
    private ImageView platform13;
    @FXML
    private ImageView platform14;
    @FXML
    private ImageView platform15;
    @FXML
    private ImageView platform16;
    @FXML
    private ImageView platform17;
    @FXML
    private ImageView platform18;
    @FXML
    private ImageView platform19;
    @FXML
    private ImageView platform20;
    @FXML
    private ImageView platform21;
    @FXML
    private ImageView platform22;
    @FXML
    private ImageView platform23;

    // Importing Orcs //
    @FXML
    private ImageView greenOrc1;
    @FXML
    private ImageView greenOrc2;
    @FXML
    private ImageView greenOrc3;
    @FXML
    private ImageView greenOrc4;
    @FXML
    private ImageView redOrc1;
    @FXML
    private ImageView redOrc2;
    @FXML
    private ImageView redOrc3;
    @FXML
    private ImageView boss;


    // Importing TNTs //
    @FXML
    private ImageView tnt3;
    @FXML
    private ImageView explosion;

    // Importing Chests //
    @FXML
    private ImageView chest1;
    @FXML
    private ImageView chest2;
    @FXML
    private ImageView chest3;

    // get Player //
    public ImageView getPlayerImg() {
        return playerImg;
    }
    public Group getEnvironment() {
        return environment;
    }
    public Text getScoreText() {
        return scoreText;
    }
    public Text getCoinsText() {
        return coinsText;
    }
    public ImageView getSword() {
        return sword;
    }
    public ImageView getHammer() { return hammer; }
    public Text getSwordText() { return swordText; }
    public Text getHammerText() { return hammerText; }

    // getPlatform() //
    public ImageView getPlatform1() {
        return platform1;
    }
    public ImageView getPlatform2() {
        return platform2;
    }
    public ImageView getPlatform3() {
        return platform3;
    }
    public ImageView getPlatform4() {
        return platform4;
    }
    public ImageView getPlatform5() {
        return platform5;
    }
    public ImageView getPlatform6() {
        return platform6;
    }
    public ImageView getPlatform7() {
        return platform7;
    }
    public ImageView getPlatform8() {
        return platform8;
    }
    public ImageView getPlatform9() {
        return platform9;
    }
    public ImageView getPlatform10() {
        return platform10;
    }
    public ImageView getPlatform11() {
        return platform11;
    }
    public ImageView getPlatform12() {
        return platform12;
    }
    public ImageView getPlatform13() {
        return platform13;
    }
    public ImageView getPlatform14() {
        return platform14;
    }
    public ImageView getPlatform15() {
        return platform15;
    }
    public ImageView getPlatform16() {
        return platform16;
    }
    public ImageView getPlatform17() {
        return platform17;
    }
    public ImageView getPlatform18() {
        return platform18;
    }
    public ImageView getPlatform19() {
        return platform19;
    }
    public ImageView getPlatform20() {
        return platform20;
    }
    public ImageView getPlatform21() {
        return platform21;
    }
    public ImageView getPlatform22() {
        return platform22;
    }
    public ImageView getPlatform23() {
        return platform23;
    }

    // getOrc() //
    public ImageView getGreenOrc1() {
        return greenOrc1;
    }
    public ImageView getGreenOrc2() {
        return greenOrc2;
    }
    public ImageView getGreenOrc3() {
        return greenOrc3;
    }
    public ImageView getGreenOrc4() {
        return greenOrc4;
    }
    public ImageView getRedOrc1() {
        return redOrc1;
    }
    public ImageView getRedOrc2() {
        return redOrc2;
    }
    public ImageView getRedOrc3() {
        return redOrc3;
    }

    public ImageView getBoss() {
        return boss;
    }

    // getTNT() //
    public ImageView getTnt3() {
        return tnt3;
    }
    public Image getExplosion() {
        return explosion.getImage();
    }

    // getChest() //
    public ImageView getChest1() {
        return chest1;
    }
    public ImageView getChest2() {
        return chest2;
    }
    public ImageView getChest3() {
        return chest3;
    }

    private boolean gameActive = false;

    public boolean isGameActive() {
        return gameActive;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }



    public void play() {
        gameActive = true;
        Animations.slideUp(menu, -1).play();
        saveButton.setDisable(false);
        saveButton.setVisible(true);
    }

    public void pause() {
        gameActive = false;
        Animations.slideUp(menu, 1).play();
    }
}