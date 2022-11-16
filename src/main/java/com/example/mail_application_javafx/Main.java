package com.example.mail_application_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL clientUrl = Main.class.getResource("view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(clientUrl);
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Email client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
