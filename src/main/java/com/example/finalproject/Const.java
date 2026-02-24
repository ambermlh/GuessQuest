// Const.java
// Final Project MAD 200
// Contruct file of constants for app
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Const {
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 1000;
    public static final Font font1 = Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 30);
    public static final Font font2 = Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 15);
    public static void colorFont1(Text... texts) {
        for (Text t : texts) {
            t.setFont(font1);
            t.setFill(Color.WHITE);

        }
    }
    public static void colorFont2(Text... texts) {
        for (Text t : texts) {
            t.setFont(font2);
            t.setFill(Color.WHITE);
        }
    }

    public static final Background BACKGROUND = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
}
