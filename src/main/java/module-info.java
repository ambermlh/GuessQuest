module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}