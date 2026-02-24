// TrivaPaneCreate.java
// Final Project MAD 200
// TriviaPanePlay - triva area to create new question sets
// 11.23.25
// Amber H, Shearl J, Kat K

package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class TriviaPaneCreate extends BorderPane {

    String userFileNameOut;
    File userFileName = null;
    int questionNumSet;
    static int questionNumValue = 1;
    String mp3FileNameUpload;
    String mp3FileName = null;

    ArrayList<String> questionArray = new ArrayList<>();

    private int currentIndex = 0;

    public TriviaPaneCreate() {
        this.setBackground(Const.BACKGROUND);
        if(BgMusic.bgMediaPlayer.isMute()) {
            ClickSound.clickMediaPlayer.setMute(false);
            BgMusic.bgMediaPlayer.setMute(false);
        }
        else{
            ClickSound.clickMediaPlayer.setMute(true);
            BgMusic.bgMediaPlayer.setMute(true);
        }

        questionNumValue = questionNumValue +1;
        // /// code to paginate  Text questionNum = new Text("QUESTION #: " + questionNumValue);
        Text questionNum = new Text("ENTER QUESTIONS AND ANSWERS");
        HBox topQNum = new HBox(questionNum);

        topQNum.setAlignment(Pos.BASELINE_CENTER);
        topQNum.setPadding(new Insets(30, 0, 0, 0));
        questionNum.setFont(Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        questionNum.setFill(Color.WHITE);

        this.setTop(topQNum);

        ImageView fileImage = new ImageView(new Image(getClass().getResourceAsStream("empty.jpg")));
        fileImage.setFitWidth(300);
        fileImage.setFitHeight(100);
        TextField fileField = new TextField();
        fileField.setPromptText("Enter file name");
        fileField.setMaxWidth(200);
        fileField.setAlignment(Pos.CENTER);
        StackPane fileBox = new StackPane(fileImage, fileField);
        fileBox.setAlignment(Pos.CENTER);

        //Question stackPane
        ImageView qImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        qImage.setFitWidth(900);
        qImage.setFitHeight(300);
        TextArea qField = new TextArea();
        qField.setPromptText("Enter Question");
        qField.setWrapText(true);
        qField.setMaxWidth(700);
        qField.setMaxHeight(200);
        StackPane qBox = new StackPane(qImage, qField);
        qBox.setAlignment(Pos.CENTER);

        ImageView ansImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        ansImage.setFitWidth(300);
        ansImage.setFitHeight(100);
        TextField ansField = new TextField();
        ansField.setPromptText("Enter Answer");
        ansField.setMaxWidth(200);
        ansField.setAlignment(Pos.CENTER);
        StackPane ansBox = new StackPane(ansImage, ansField);
        ansBox.setAlignment(Pos.CENTER);

        //ABCD stackpanes
        ImageView aImage = new ImageView(new Image(getClass().getResourceAsStream("a.jpg")));
        aImage.setFitWidth(300);
        aImage.setFitHeight(100);
        TextField aField = new TextField();
        aField.setPromptText("Enter option");
        aField.setMaxWidth(200);
        aField.setAlignment(Pos.CENTER);
        StackPane aBox = new StackPane(aImage, aField);
        aBox.setAlignment(Pos.CENTER);

        ImageView bImage = new ImageView(new Image(getClass().getResourceAsStream("b.jpg")));
        bImage.setFitWidth(300);
        bImage.setFitHeight(100);
        TextField bField = new TextField();
        bField.setPromptText("Enter option");
        bField.setMaxWidth(200);
        bField.setAlignment(Pos.CENTER);
        StackPane bBox = new StackPane(bImage, bField);
        bBox.setAlignment(Pos.CENTER);

        ImageView cImage = new ImageView(new Image(getClass().getResourceAsStream("c.jpg")));
        cImage.setFitWidth(300);
        cImage.setFitHeight(100);
        TextField cField = new TextField();
        cField.setPromptText("Enter option");
        cField.setMaxWidth(200);
        cField.setAlignment(Pos.CENTER);
        StackPane cBox = new StackPane(cImage, cField);
        cBox.setAlignment(Pos.CENTER);

        ImageView dImage = new ImageView(new Image(getClass().getResourceAsStream("d.jpg")));
        dImage.setFitWidth(300);
        dImage.setFitHeight(100);
        TextField dField = new TextField();
        dField.setPromptText("Enter option");
        dField.setMaxWidth(200);
        dField.setAlignment(Pos.CENTER);
        StackPane dBox = new StackPane(dImage, dField);
        dBox.setAlignment(Pos.CENTER);

        qField.setStyle("-fx-control-inner-background: black; -fx-border-color: grey; -fx-text-fill: white; -fx-prompt-text-fill: white; -fx-font-size: 20px;");
        ansField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");
        fileField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");
        aField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");
        bField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");
        cField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");
        dField.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");

        /// ADDED
        CustomButton back = new CustomButton("BACK");
        CustomButton next = new CustomButton("NEXT");
        CustomButton finish = new CustomButton("FINISH");
        CustomButton upload = new CustomButton("UPLOAD MP3");
        CustomButton completeUploadBox = new CustomButton("SAVE LIST");

        //boxes for centering in borderpane
        HBox ansMP = new HBox(ansBox, upload);
        ansMP.setAlignment(Pos.CENTER);
        HBox ab = new HBox(aBox, bBox);
        ab.setAlignment(Pos.CENTER);
        HBox cd = new HBox(cBox, dBox);
        cd.setAlignment(Pos.CENTER);

        //hbox for abcd
        VBox questionABCD = new VBox(qBox, ab, cd, ansMP);
        questionABCD.setAlignment(Pos.CENTER);

        questionABCD.setAlignment(Pos.CENTER);

        upload.setOnMouseClicked(e->{
            FileChooser fileChooser = new FileChooser();
            File mp3File = fileChooser.showOpenDialog(HelloApplication.mainStage);

            if (mp3File != null){
                try {
                    mp3FileNameUpload = mp3File.getName();
                    File musicFolder = new File("Music");

                    Path fileIn = new File(musicFolder, mp3FileName).toPath();
                    Files.copy(mp3File.toPath(), fileIn);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        this.setCenter(questionABCD);

        HBox fileNameBox = new HBox(fileBox, completeUploadBox);
        fileNameBox.setAlignment(Pos.CENTER);
        HBox buttonBox = new HBox(back, next, finish);

        buttonBox.setAlignment(Pos.CENTER);

        next.setOnMouseClicked( e->{
            questionNumValue = questionNumValue + 1;
            questionArray.add(qField.getText() + "," +
                    aField.getText() + "," + bField.getText()
                    + "," + cField.getText() + "," + dField.getText() + "," + ansField.getText() + "," + mp3FileNameUpload);

            // clear the form
            qField.clear();
            ansField.clear();
            aField.clear();
            bField.clear();
            cField.clear();
            dField.clear();
            questionNum.setText("QUESTION #" + questionNumValue);
            // set question number to one more
            System.out.println(questionArray.toString());

        });

        finish.setOnMouseClicked( e->{
            questionNumValue = questionNumValue + 1;
            questionArray.add(qField.getText() + ","  +
                    aField.getText() + "," + bField.getText()
                    + "," + cField.getText() + "," + dField.getText() + "," +  ansField.getText() + "," + mp3FileNameUpload);

            // clear the form
            qField.clear();
            ansField.clear();
            aField.clear();
            bField.clear();
            cField.clear();
            dField.clear();

            // set question number to one more
            System.out.println(questionArray.toString());

            // display file name box
            Text enterFileNameTxt = new Text("Enter in a Question List file name: ");
            enterFileNameTxt.setStyle("-fx-background-color: black; -fx-border-color: grey; -fx-text-fill: white;");

            HBox displayFinish = new HBox(enterFileNameTxt, fileNameBox);
            displayFinish.setAlignment(Pos.TOP_CENTER);
            this.setTop(displayFinish);

        });

        completeUploadBox.setOnMouseClicked(e -> {

                if(fileField != null){
                    System.out.println(fileField);
                }

                String randomUserFileName = fileField.getText() + "_" + System.currentTimeMillis() + ".txt";
                System.out.println(randomUserFileName);
                File userFileName = new File(randomUserFileName);

                TextField userFile = new TextField(userFileName.toString());
                userFile.setPromptText(userFileName.toString());

                //  create file and store in dir QuestionLists
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("QuestionLists/" + userFileName));
                    out.close();
                    userFileNameOut = userFileName.toString();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            //}

            try {
                PrintWriter out = new PrintWriter( new BufferedWriter
                        (new FileWriter("QuestionLists/" + userFileNameOut, true)));

                for(String str : questionArray) {
                    out.write(str + "\n");
                }

                out.close();
                // clear the form
                qField.clear();
                aField.clear();
                bField.clear();
                cField.clear();
                dField.clear();
                ansField.clear();

                // set question number to one more
                questionNumSet = questionNumSet +1;

                /// ADDED

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            HelloApplication.mainStage.setScene(new MainScene());

    });
        next.setOnMouseClicked(e -> {
            // check if file has been created

            questionNumValue = questionNumValue + 1;
            questionArray.add(qField.getText() + "," +
                    aField.getText() + "," + bField.getText()
                    + "," + cField.getText() + "," + dField.getText() + "," + ansField.getText() + "," + mp3FileNameUpload);

            // clear the form
            qField.clear();
            ansField.clear();
            aField.clear();
            bField.clear();
            cField.clear();
            dField.clear();

            // set question number to one more
            System.out.println(questionArray.toString());
        });


        back.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new MainScene());
        });
        this.setBottom(buttonBox);
    }
}