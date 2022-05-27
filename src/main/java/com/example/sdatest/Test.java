package com.example.sdatest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static HSMS.HSMS.getHsms;

public class Test extends Application {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Test.class.getResource("Admin/new.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("HSMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        getHsms().start();
        launch();
    }








}