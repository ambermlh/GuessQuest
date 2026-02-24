// ClickSound.java
// Final Project MAD 200
// ClickSound class to play sound effects on click
// 11.23.25
// Kat K.

package com.example.finalproject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class ClickSound extends Stage {

    private static Media clickSound = new Media(Paths.get("Music/new-notification-08-352461.mp3").toUri().toString());
    public static MediaPlayer clickMediaPlayer = new MediaPlayer(clickSound);

    public ClickSound() {
        clickMediaPlayer.setCycleCount(2);
        ClickSound.clickMediaPlayer.setMute(false);
    }

    public Media getClickSound() {
        return clickSound;
    }

    public Media setClickSound(Media clickSound) {
        return this.clickSound = clickSound;
    }

    public MediaPlayer getClickMediaPlayer() {
        return clickMediaPlayer;
    }


}
