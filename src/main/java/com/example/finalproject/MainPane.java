// MainPane.java
// Final Project MAD 200
// MainPane - display links to app main navigation
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class MainPane extends BorderPane {
    //mediaplayer
    public static boolean musicOnOff = true;
    static String song1 = new File("Music/flickering-neon-316717.mp3").toURI().toString();
    public static MediaPlayer mediaPlayer = new MediaPlayer(new Media(song1));

    public MainPane(){
        this.setBackground(Const.BACKGROUND);

        //mainlogo
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("GuessQuest-NoButtons.jpg")));
        image.setFitWidth(1100);
        image.setFitHeight(400);

        CustomButton play = new CustomButton("PLAY");
        CustomButton create = new CustomButton("CREATE");
        CustomButton score = new CustomButton("SCORE");
        CustomButton settings = new CustomButton("SETTINGS");
        CustomButton credits = new CustomButton("CREDITS");

        //mute image
        ImageView unmute = new ImageView(new Image(getClass().getResourceAsStream("unmute.png")));
        unmute.setFitWidth(50);
        unmute.setFitHeight(50);

        VBox buttonBox = new VBox(image, play, create, score, settings, credits);

        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setSpacing(5);

        this.setCenter(buttonBox);
        this.setBottom(unmute);

        //play flickering sound
        mediaPlayer.setStopTime(Duration.seconds(5));
        mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
        if(BgMusic.bgMediaPlayer.isMute()) {
            ClickSound.clickMediaPlayer.setMute(false);
            //BgMusic.bgMediaPlayer.setMute(false);
        }
        else{
            ClickSound.clickMediaPlayer.setMute(true);
            //BgMusic.bgMediaPlayer.setMute(true);
        }


        //animations
        FadeTransition fade1 = new FadeTransition(Duration.seconds(0.5), image);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition(Duration.seconds(0.1), image);
        fade2.setFromValue(1);
        fade2.setToValue(0.6);

        FadeTransition fade3 = new FadeTransition(Duration.seconds(0.3), image);
        fade3.setFromValue(0.6);
        fade3.setToValue(1);

        SequentialTransition flicker = new SequentialTransition(fade1, fade2, fade3);
        flicker.setCycleCount(7);
        flicker.play();

        //mute sounds
        unmute.setOnMouseClicked(e -> {
            if (musicOnOff) {
                mediaPlayer.pause();
                flicker.pause();
                image.setOpacity(1.0);
                unmute.setOpacity(0.4);
                musicOnOff = false;
                if(BgMusic.bgMediaPlayer.isMute()) {
                    ClickSound.clickMediaPlayer.setMute(false);
                    //BgMusic.bgMediaPlayer.setMute(false);
                }
                else{
                    ClickSound.clickMediaPlayer.setMute(true);
                    //BgMusic.bgMediaPlayer.setMute(true);
                }
            } else {
                mediaPlayer.play();
                flicker.play();
                unmute.setOpacity(1);
                musicOnOff = true;

            }
        });

        //mouse clicks to new pages
        play.setOnMouseClicked(e ->{
           HelloApplication.mainStage.setScene(new PlayScene());
        });
        create.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new TriviaSceneCreate());
        });
        score.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new ScoreScene());
        });
        settings.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new SettingsScene());
        });
        credits.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new CreditsScene());
        });
    }
}
