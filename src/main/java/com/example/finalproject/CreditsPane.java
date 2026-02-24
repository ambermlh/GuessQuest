// CreditPane.java
// Final Project MAD 200
// CreditPane - display credits for game
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CreditsPane extends BorderPane {
    public CreditsPane(){
        this.setBackground(Const.BACKGROUND);

        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("GuessQuest-NoButtons.jpg")));
        image.setFitWidth(1100);
        image.setFitHeight(450);

        Text credits = new Text("CREDITS");
        Text contribute = new Text("CONTRIBUTORS");
        Text contributeList = new Text("Amber Howe \nKat Koeller \nShearl James");
        Text resource = new Text("RESOURCES");
        //TODO Resources???
        Text resourceList = new Text("Music : Youtube \n");
        Text imageAssets = new Text("IMAGES PROVIDED BY");
        Text imageAssetsList = new Text("Nicholas Gloster \n Canva");

        credits.setFill(Color.WHITE);
        credits.setFont(Font.font("Impact", FontPosture.REGULAR, 60));


        Const.colorFont1(contribute, resource, imageAssets);
        Const.colorFont2(contributeList, resourceList, imageAssetsList);


        ImageView back = new ImageView(new Image(getClass().getResourceAsStream("Back.jpg")));
        back.setFitWidth(200);
        back.setFitHeight(60);



        VBox vBox1 = new VBox(image);
        VBox vBox2 = new VBox(credits, contribute, contributeList, resource, resourceList, imageAssets, imageAssetsList);

        this.setTop(vBox1);
        this.setCenter(vBox2);
        this.setBottom(back);

        vBox1.setAlignment(Pos.TOP_CENTER);

        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setSpacing(10);

        back.setX(10);

        FadeTransition fade1 = new FadeTransition(Duration.seconds(0.5), image);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition(Duration.seconds(0.1), image);
        fade2.setFromValue(1);
        fade2.setToValue(0.6);

        FadeTransition fade3 = new FadeTransition(Duration.seconds(0.3), image);
        fade3.setFromValue(0.6);
        fade3.setToValue(1);

        //TODO MAYBE TAKE THIS OUT? IDK
        TranslateTransition move = new TranslateTransition(Duration.seconds(5), vBox2);
        move.setFromY(400);
        move.setToY(0);
        move.play();

        SequentialTransition flicker = new SequentialTransition(fade1, fade2, fade3);
        flicker.setCycleCount(2);
        flicker.play();
        if(BgMusic.bgMediaPlayer.isMute()) {
            ClickSound.clickMediaPlayer.setMute(false);
            BgMusic.bgMediaPlayer.setMute(false);
        }
        else{
            ClickSound.clickMediaPlayer.setMute(true);
            BgMusic.bgMediaPlayer.setMute(true);
        }

        back.setOnMouseClicked(e ->{
            HelloApplication.mainStage.setScene(new MainScene());
        });
    }
}
