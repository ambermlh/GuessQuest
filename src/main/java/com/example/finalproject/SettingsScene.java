// SettingScene.java
// Final Project MAD 200
// Setting Scene page displays settings pane.java
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SettingsScene extends Scene {
    public SettingsScene() {
        super(new SettingsPane(),Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
    }
}
