// SettingsPane.java
// Final Project MAD 200
// SettingsPane - button to turn music on or off for app
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SettingsPane extends BorderPane {
    public SettingsPane(){
        this.setBackground(Const.BACKGROUND);

        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("GuessQuest-NoButtons.jpg")));
        image.setFitWidth(1100);
        image.setFitHeight(450);

        Text settings = new Text("SETTINGS");
        Text musicSettings = new Text("MUSIC SETTINGS");

        settings.setFill(Color.WHITE);
        settings.setFont(Font.font("Impact", FontPosture.REGULAR, 60));
        Const.colorFont1(musicSettings);

        CustomButton musicChoiceOn = new CustomButton("ON/OFF MUSIC");

        musicChoiceOn.setOnMouseClicked( e->{

            if (BgMusic.bgMediaPlayer.isMute()) {
                musicChoiceOn.setButtonText(new Text("PLAY"));
                ClickSound.clickMediaPlayer.setMute(false);
                BgMusic.bgMediaPlayer.setMute(false);

            }else{
                musicChoiceOn.setButtonText(new Text("STOP MUSIC"));
                ClickSound.clickMediaPlayer.setMute(true);
                BgMusic.bgMediaPlayer.setMute(true);
            }

        });

        // control music and sound effects on or off // player is in Hello Application
        musicChoiceOn.requestFocus();

        VBox vBox2 = new VBox(settings, musicSettings, musicChoiceOn);
        this.setCenter(vBox2);
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setSpacing(10);

        ImageView back = new ImageView(new Image(getClass().getResourceAsStream("Back.jpg")));
        back.setFitWidth(200);
        back.setFitHeight(60);

        VBox vBox1 = new VBox(image);



        this.setTop(vBox1);
        //this.setCenter(vBox2);
        this.setBottom(back);

        vBox1.setAlignment(Pos.TOP_CENTER);

        // vBox2.setAlignment(Pos.TOP_CENTER);
        //vBox2.setSpacing(10);

        back.setX(10);

        FadeTransition fade1 = new FadeTransition(Duration.seconds(0.5), image);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition(Duration.seconds(0.1), image);
        fade2.setFromValue(1);
        fade2.setToValue(0.6);

        FadeTransition fade3 = new FadeTransition(Duration.seconds(0.3), image);
        fade3.setFromValue(0.6);
        fade3.setToValue(1);

        //TODO MAYBE TAKE THIS OUT? IDK
//        TranslateTransition move = new TranslateTransition(Duration.seconds(3), vBox2);
//        move.setFromY(400);
//        move.setToY(0);
//        move.play();

        SequentialTransition flicker = new SequentialTransition(fade1, fade2, fade3);
        flicker.setCycleCount(1);
        flicker.play();


        back.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new MainScene());
        });
    }
}
