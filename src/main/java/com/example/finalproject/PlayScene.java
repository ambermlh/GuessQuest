// PlayScene.java
// Final Project MAD 200
// Play Scene page displays play pane.java
// 11.23.25
// Amber H, Shearl J, Kat K


package com.example.finalproject;

import javafx.scene.Scene;

public class PlayScene extends Scene {
    public PlayScene() {
        super(new PlayPane(), Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
    }

}
