package com.example.finalproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;

public class PlayPane extends BorderPane {
    public PlayPane(){
        this.setBackground(Const.BACKGROUND);

        Text select = new Text("PLEASE SELECT A TRIVIA GAME: ");
        select.setFont(Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        select.setFill(Color.WHITE);

        HBox top = new HBox(select);
        top.setAlignment(Pos.TOP_CENTER);
        top.setPadding(new Insets(30, 0, 0, 0));

        File questionFolder = new File("QuestionLists/");
        File [] listOfQuest = questionFolder.listFiles();

        ArrayList<String> list =new ArrayList<>();
        for(File file: listOfQuest){
            if(file.isFile()){
                String displayName = file.getName().replaceFirst("\\.txt$", "");
                list.add(displayName);
            }
        }

        ListView<String> quest = new ListView<>(FXCollections.observableList(list));
        quest.setMaxHeight(400);
        quest.setMaxWidth(500);
        quest.setStyle("-fx-control-inner-background: black; -fx-border-color: grey; -fx-text-fill: white; -fx-font-size: 20px;");

        quest.setOnMouseClicked(event -> {
            String selectedFile = quest.getSelectionModel().getSelectedItem();
            if (selectedFile != null) {
                if (event.getClickCount() == 2) {
                    String relativePath = "QuestionLists/" + selectedFile + ".txt";
                    HelloApplication.mainStage.setScene(new TriviaScenePlay(relativePath));
                }
            }
        });

        //Yellow Box around list
        ImageView qImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        qImage.setFitWidth(700);
        qImage.setFitHeight(600);
        qImage.setMouseTransparent(true);

        StackPane questionBox = new StackPane(qImage, quest);
        questionBox.setAlignment(Pos.CENTER);

        ImageView back = new ImageView(new Image(getClass().getResourceAsStream("Back.jpg")));
        back.setFitWidth(300);
        back.setFitHeight(100);
        back.setOnMouseClicked(e-> {
            HelloApplication.mainStage.setScene(new MainScene());
        });

        this.setTop(top);
        this.setCenter(questionBox);
        this.setBottom(back);

    }
}