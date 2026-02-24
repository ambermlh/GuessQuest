// TriviaScenePlay.java
// Final Project MAD 200
// Trivia Scene Play - display play trivia pane - TriviaPanePlay.java
// 11.23.25
// Amber H, Shearl J, Kat K
package com.example.finalproject;

import javafx.scene.Scene;

public class TriviaScenePlay extends Scene {

    public TriviaScenePlay(String fileLocation) {
        super(new TriviaPanePlay(fileLocation), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
