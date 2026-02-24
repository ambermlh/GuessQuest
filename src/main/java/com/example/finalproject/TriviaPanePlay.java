package com.example.finalproject;

import javafx.animation.FillTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TriviaPanePlay extends BorderPane {
    private int playerScore = 0;
    private int currentQuestion = 0;
    private ArrayList<String[]> questions = new ArrayList<>();
    private MediaPlayer mediaPlayer = null;
    private ImageView playPause;
    private boolean isPlaying = false;
    private boolean questionAnswered = false;
    int questionNumSet;
    public TriviaPanePlay(String fileLocation){

        this.setBackground(Const.BACKGROUND);

        questionNumSet = questionNumSet +1;
        Text questionNum = new Text("QUESTION #: " + questionNumSet);
        questionNum.setFont(Font.font("Impact", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        questionNum.setFill(Color.WHITE);

        HBox topQNum = new HBox(questionNum);
        topQNum.setAlignment(Pos.BASELINE_CENTER);
        topQNum.setPadding(new Insets(30, 0, 0, 0));

        //Question stackPane
        ImageView qImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        qImage.setFitWidth(800);
        qImage.setFitHeight(350);
        Text qField = new Text();
        qField.setFont(Const.font2);
        qField.setTextAlignment(TextAlignment.CENTER);
        qField.setWrappingWidth(700);
        StackPane questionBox = new StackPane(qImage, qField);
        questionBox.setAlignment(Pos.CENTER);

        ImageView ansImage = new ImageView(new Image(getClass().getResourceAsStream("question.jpg")));
        ansImage.setFitWidth(300);
        ansImage.setFitHeight(100);
        Text ansField = new Text();
        StackPane ansBox = new StackPane(ansImage, ansField);
        ansBox.setAlignment(Pos.CENTER);

        CustomButton aBox = new CustomButton("");
        aBox.setBackground(new ImageView(new Image(getClass().getResourceAsStream("a.jpg"))));
        aBox.getBackgroundImage().setFitWidth(500);
        aBox.getBackgroundImage().setFitHeight(150);
        aBox.getButtonText().setWrappingWidth(320);
        aBox.getButtonText().setTextAlignment(TextAlignment.CENTER);


        CustomButton bBox = new CustomButton("");
        bBox.setBackground(new ImageView(new Image(getClass().getResourceAsStream("b.jpg"))));
        bBox.getBackgroundImage().setFitWidth(500);
        bBox.getBackgroundImage().setFitHeight(150);
        bBox.getButtonText().setWrappingWidth(320);
        bBox.getButtonText().setTextAlignment(TextAlignment.CENTER);


        CustomButton cBox = new CustomButton("");
        cBox.setBackground(new ImageView(new Image(getClass().getResourceAsStream("c.jpg"))));
        cBox.getBackgroundImage().setFitWidth(500);
        cBox.getBackgroundImage().setFitHeight(150);
        cBox.getButtonText().setWrappingWidth(320);
        cBox.getButtonText().setTextAlignment(TextAlignment.CENTER);

        CustomButton dBox = new CustomButton("");
        dBox.setBackground(new ImageView(new Image(getClass().getResourceAsStream("d.jpg"))));
        dBox.getBackgroundImage().setFitWidth(500);
        dBox.getBackgroundImage().setFitHeight(150);
        dBox.getButtonText().setWrappingWidth(320);
        dBox.getButtonText().setTextAlignment(TextAlignment.CENTER);

        Const.colorFont1(qField);

        //pause & play buttons
        playPause = new ImageView(new Image(getClass().getResourceAsStream("playbutton.png")));
        playPause.setFitWidth(50);
        playPause.setFitHeight(50);

// click event just like a button
        playPause.setOnMouseClicked(e -> {
            togglePlayPause();
        });

        try (BufferedReader read = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                questions.add(parts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //boxes for centering in borderpane
        HBox ab = new HBox(aBox, bBox);
        ab.setAlignment(Pos.CENTER);
        HBox cd = new HBox(cBox, dBox);
        cd.setAlignment(Pos.CENTER);

        //hbox for abcd
        VBox questionABCD = new VBox(40, questionBox, ab, cd);
        questionABCD.setAlignment(Pos.CENTER);

        //back & next buttons
        CustomButton back = new CustomButton("BACK");
        CustomButton next = new CustomButton("NEXT");

        //HBox for buttons
        HBox buttonBox = new HBox(back, next);
        buttonBox.setAlignment(Pos.CENTER);

        showQuestion(currentQuestion, questionNum, qField, aBox.getButtonText(), bBox.getButtonText(), cBox.getButtonText(), dBox.getButtonText(), ansField);

        back.setOnMouseClicked(e-> {
            currentQuestion--;
            showQuestion(currentQuestion, questionNum, qField, aBox.getButtonText(), bBox.getButtonText(), cBox.getButtonText(), dBox.getButtonText(), ansField);

            if (isPlaying) {
                mediaPlayer.pause();
                playPause.setImage(new Image(getClass().getResourceAsStream("playbutton.png")));
            }
        });

        ArrayList<Integer> scoreList = new ArrayList<>();
//
//        try( PrintWriter in = new PrintWriter(new FileWriter("HighScore/HighScores.txt", true));){
//            in.print(playerScore +"\n");
//            System.out.println(playerScore);
//            // Convert int to String before writing
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        // TO COMPARE IF THE DISPLAY ITEM IS THE SAME AS THE ANSWER
        aBox.setOnMouseClicked(e->{
                if (aBox.getButtonText().getText().toString().equals(ansField.getText().toString())){
                    boolean correct = true;
                    playerScore += 10;
                    scoreList.add(playerScore);
                   // System.out.println(scoreList);

                    System.out.println("match");
                    FillTransition fillRight = new FillTransition(Duration.seconds(.1), aBox.getButtonText(), Color.WHITE, Color.LIGHTGREEN);
                    fillRight.play();
                } else {
                    boolean correct = false;
                    System.out.println("no match");
                    FillTransition fillWrong = new FillTransition(Duration.seconds(.1), aBox.getButtonText(), Color.WHITE, Color.RED);
                    fillWrong.play();
                }
            aBox.setDisable(true);
            bBox.setDisable(true);
            cBox.setDisable(true);
            dBox.setDisable(true);
        });
        bBox.setOnMouseClicked(e->{
            if (bBox.getButtonText().getText().toString().equals(ansField.getText().toString())){
                boolean correct = true;
                playerScore += 10;
                scoreList.add(playerScore);
               // System.out.println(scoreList);

                System.out.println("match");
                FillTransition fillRight = new FillTransition(Duration.seconds(.1), bBox.getButtonText(), Color.WHITE, Color.LIGHTGREEN);
                fillRight.play();
            } else {
                boolean correct = false;
                System.out.println("no match");
                FillTransition fillWrong = new FillTransition(Duration.seconds(.1), bBox.getButtonText(), Color.WHITE, Color.RED);
                fillWrong.play();
            }
            aBox.setDisable(true);
            bBox.setDisable(true);
            cBox.setDisable(true);
            dBox.setDisable(true);
        });
        cBox.setOnMouseClicked(e->{
            if (cBox.getButtonText().getText().toString().equals(ansField.getText().toString())){
                boolean correct = true;
                playerScore += 10;
                scoreList.add(playerScore);
              //  System.out.println(scoreList);

                System.out.println("match");
                FillTransition fillRight = new FillTransition(Duration.seconds(.1), cBox.getButtonText(), Color.WHITE, Color.LIGHTGREEN);
                fillRight.play();
            } else {
                boolean correct = false;
                System.out.println("no match");
                FillTransition fillWrong = new FillTransition(Duration.seconds(.1), cBox.getButtonText(), Color.WHITE, Color.RED);
                fillWrong.play();
            }
            aBox.setDisable(true);
            bBox.setDisable(true);
            cBox.setDisable(true);
            dBox.setDisable(true);
        });
        dBox.setOnMouseClicked(e->{
            if (dBox.getButtonText().getText().toString().equals(ansField.getText().toString())){
                boolean correct = true;
                playerScore += 10;
                scoreList.add(playerScore);
                //System.out.println(scoreList);

                System.out.println("match");
                FillTransition fillRight = new FillTransition(Duration.seconds(.1), dBox.getButtonText(), Color.WHITE, Color.LIGHTGREEN);
                fillRight.play();
            } else {
                boolean correct = false;
                System.out.println("no match");
                FillTransition fillWrong = new FillTransition(Duration.seconds(.1), dBox.getButtonText(), Color.WHITE, Color.RED);
                fillWrong.play();

            }
            aBox.setDisable(true);
            bBox.setDisable(true);
            cBox.setDisable(true);
            dBox.setDisable(true);
        });

        next.setOnMouseClicked(e -> {
            currentQuestion++;
            if(currentQuestion >= questions.size()) {
                try( PrintWriter in = new PrintWriter(new FileWriter("HighScore/HighScores.txt", true));){
                    in.print(playerScore +"\n");
                    System.out.println(playerScore);
                    // Convert int to String before writing
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (isPlaying) {
                    mediaPlayer.pause();
                    playPause.setImage(new Image(getClass().getResourceAsStream("playbutton.png")));
                }
                HelloApplication.mainStage.setScene(new ScoreScene());

                return;
            }

            showQuestion(currentQuestion, questionNum, qField, aBox.getButtonText(), bBox.getButtonText(), cBox.getButtonText(), dBox.getButtonText(), ansField);

            resetBox(aBox);
            resetBox(bBox);
            resetBox(cBox);
            resetBox(dBox);

            aBox.setDisable(false);
            bBox.setDisable(false);
            cBox.setDisable(false);
            dBox.setDisable(false);

            questionAnswered = false;
            mediaPlayer.pause();
            playPause.setImage(new Image(getClass().getResourceAsStream("playbutton.png")));
        });
        this.setTop(topQNum);
        this.setRight(playPause);
        this.setCenter(questionABCD);
        this.setBottom(buttonBox);
    }

    private void togglePlayPause() {
        String[] currentQuestionSong = questions.get(currentQuestion);

        if (currentQuestionSong.length > 6) {
            String mp3FileName = currentQuestionSong[6];
            File mp3File = new File("Music/" + mp3FileName);

            if (!mp3File.exists()) {
                System.out.println("File not found: " + mp3FileName);
                return;
            }

            if (mediaPlayer == null ||
                    !Objects.equals(mediaPlayer.getMedia().getSource(), mp3File.toURI().toString())) {

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }

                Media media = new Media(mp3File.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
            }

            if (isPlaying) {
                mediaPlayer.pause();
                playPause.setImage(new Image(getClass().getResourceAsStream("playbutton.png")));
            } else {
                mediaPlayer.play();
                playPause.setImage(new Image(getClass().getResourceAsStream("pausebutton.png")));
            }

            if (isPlaying) {
                isPlaying = false;
            } else {
                isPlaying = true;
            }
        }
    }

    private void showQuestion(int index, Text questionNum, Text qField, Text aField, Text bField, Text cField, Text dField, Text ansField){
        String[] x = questions.get(index);
        questionNum.setText("QUESTION #: " + (index + 1));
        if (x.length >= 1) {
            qField.setText(x[0]);
        } else {
            qField.setText("");
        }
        if (x.length >= 2) {
            aField.setText(x[1]);
        } else {
            aField.setText("");
        }
        if (x.length >= 3) {
            bField.setText(x[2]);
        } else {
            bField.setText("");
        }
        if (x.length >= 4) {
            cField.setText(x[3]);
        } else {
            cField.setText("");
        }
        if (x.length >= 5) {
            dField.setText(x[4]);
        } else {
            dField.setText("");
        }
        if (x.length >= 6) {
            ansField.setText(x[5]);
        } else {
            ansField.setText("");
        }
    }

    public void resetBox(CustomButton button){
        FillTransition fillWrong = new FillTransition(Duration.seconds(.1), button.getButtonText(), Color.WHITE, Color.WHITE);
        fillWrong.play();
    }
}


