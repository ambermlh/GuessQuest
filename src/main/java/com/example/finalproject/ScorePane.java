package com.example.finalproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
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

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ScorePane extends BorderPane {
    ScorePane(){
        this.setBackground(Const.BACKGROUND);

        Text select = new Text("HISTORY SCORE: ");
        select.setFont(Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        select.setFill(Color.WHITE);

        HBox top = new HBox(select);
        top.setAlignment(Pos.TOP_CENTER);
        top.setPadding(new Insets(30, 0, 0, 0));

        TextArea showContent = new TextArea();
        showContent.setWrapText(true);
        showContent.setEditable(false);
        showContent.setMaxWidth(500);
        showContent.setMaxHeight(400);
        showContent.setStyle("-fx-control-inner-background: black; -fx-border-color: grey; -fx-text-fill: white; -fx-font-size: 40px;");

        ImageView qImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        qImage.setFitWidth(700);
        qImage.setFitHeight(600);
        qImage.setMouseTransparent(true);

        StackPane questionBox = new StackPane(qImage, showContent);
        questionBox.setAlignment(Pos.CENTER);

        File fileName = new File("HighScore/HighScores.txt");
        ArrayList<Integer> store = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Parse each line as an integer and add to the list
                    store.add(Integer.parseInt(line.trim()));
                    showContent.appendText(line + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



//        try{
//            BufferedReader in = new BufferedReader(new FileReader(fileName));
//            String num;
//            while((num = in.readLine()) != null){
//                store.add(Integer.parseInt(num));
//                System.out.println(num);
//            }
//            showContent.appendText(num);
//            Collections.sort(store);
//            for (int i = store.size()-1; i >= 0; i--){
//                showContent.appendText(store.get(i) + "\n");
//            }
//            System.out.println(store);
//            in.close();
//        }catch(Exception e1){
//            e1.printStackTrace();
//        }
        //back & next buttons
        CustomButton back = new CustomButton("MAIN MENU");
        back.setOnMouseClicked(e-> {
            HelloApplication.mainStage.setScene(new MainScene());
        });
        CustomButton next = new CustomButton("CREDITS");
        next.setOnMouseClicked(e-> {
            HelloApplication.mainStage.setScene(new CreditsScene());
        });

        HBox buttonBox = new HBox(back, next);
        buttonBox.setAlignment(Pos.CENTER);

        this.setTop(top);
        this.setCenter(questionBox);
        this.setBottom(buttonBox);
    }
}
