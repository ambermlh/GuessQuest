// BgMusic.java
// Final Project MAD 200
// BgMusic class to play music in app
// 11.21.25
// Kat K


package com.example.finalproject;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Paths;

public class BgMusic extends Stage {

    private static Media bgMusic = new Media(Paths.get("Music/background.mp3").toUri().toString());
    public static MediaPlayer bgMediaPlayer = new MediaPlayer(bgMusic);
    private boolean soundOn = true;

    public BgMusic() {
        bgMediaPlayer.setAutoPlay(true);
        bgMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        if (soundOn) {
            bgMediaPlayer.play();
        } else {
            bgMediaPlayer.pause();
        }
    }

    public Media getBgMusic() {
        return bgMusic;
    }

    public Media setBgMusic(Media bgMusic) {
        return this.bgMusic = bgMusic;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }

    public MediaPlayer getBgMediaPlayer() {
        return bgMediaPlayer;
    }
}



//    player.addControllerListener(new ControllerAdapter() {
//        @Override
//        public void endOfMedia(EndOfMediaEvent e) {
//            // Set media time to zero and restart the player
//            player.setMediaTime(new Time(0));
//            player.start();
//        }
//    });


//    private MediaPlayer mediaPlayer;
//    private Media bgMusic = new Media(Paths.get("Music/cdk_-_Silence_Await.mp3").toUri().toString());
//    private boolean soundOn = true;
//
//
//
//
//
//}
