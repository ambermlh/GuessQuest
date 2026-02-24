// CreditsScene.java
// Final Project MAD 200
// Credits Scene page displays credits pane.java
// 11.23.25
// Amber H, Shearl J, Kat K


package com.example.finalproject;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreditsScene extends Scene {
    public CreditsScene() {
        super(new CreditsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
