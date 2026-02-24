// MainScene.java
// Final Project MAD 200
// Main Scene page displays main pane.java
// 11.23.25
// Amber H, Shearl J, Kat K


package com.example.finalproject;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainScene extends Scene {
    public MainScene() {
        super(new MainPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
