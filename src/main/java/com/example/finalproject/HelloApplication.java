// HelloApplication.java
// Final Project MAD 200
// settings for mainStage and also the first scene navigated to in the project
// 11.23.25
// Amber H, Shearl J, Kat K


package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        BgMusic.bgMediaPlayer.play();
        BgMusic.bgMediaPlayer.setMute(true);
        ClickSound.clickMediaPlayer.setMute(true);
        mainStage = stage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 320, 240);
        mainStage.setTitle("Guess Quest");
        mainStage.setScene(new MainScene());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}