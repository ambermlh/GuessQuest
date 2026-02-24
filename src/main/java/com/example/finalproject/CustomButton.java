// CustomButton.java
// Final Project MAD 200
// Setting Scene page displays settings pane.java
// 11.23.25
// Cai F, Kat K


package com.example.finalproject;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CustomButton extends StackPane {
    private ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream("empty.jpg")));
    private Text buttonText;

    public CustomButton(String text) {
        this.setOnMouseEntered(e ->
            this.buttonText.setEffect(new Glow(1.0)));
        this.setOnMouseExited( e->
             this.buttonText.setEffect(new Glow(0.0)));
        this.getStyleClass().add("custom-button");

        backgroundImage.setFitHeight(100);
        backgroundImage.setFitWidth(300);
        this.buttonText = new Text(text);
        buttonText.setFill(Color.WHITE);
        buttonText.setFont(Const.font1);
        this.getChildren().addAll(backgroundImage, buttonText);
        this.setId("custom");

        //this.buttonText.setWrappingWidth(400);

    }

    public ImageView getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackground(ImageView background) {
        this.backgroundImage = background;
        backgroundImage.setFitHeight(100);
        backgroundImage.setFitWidth(300);
        this.getChildren().clear();
        this.getChildren().addAll(backgroundImage, buttonText);

    }

    public Text getButtonText() {
        return buttonText;
    }

    public void setButtonText(Text buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public String toString() {
        return buttonText.getText().toString();
    }

}
