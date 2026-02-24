// TriviaSceneCreate.java
// Final Project MAD 200
// Trivia Scene Create - display create trivia pane - TriviaPaneCreate.java
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.scene.Scene;

public class TriviaSceneCreate extends Scene {
    public TriviaSceneCreate() {
        super(new TriviaPaneCreate(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
