// ScoreScene.java
// Final Project MAD 200
// Score Scene page displays score pane.java
// 11.23.25
// Amber H, Shearl J, Kat K


package com.example.finalproject;

import javafx.scene.Scene;

public class ScoreScene extends Scene {
    public ScoreScene(){
        super(new ScorePane(), Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
    }
}
