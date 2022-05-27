package com.example.sdatest;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HSMS.Owner.Owner;
import HSMS.Owner.Resident;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button signUpBtn;

    @FXML
    private HBox loaderPane;

    @FXML
    private StackPane mainPane;

    @FXML
    private VBox detailsPane;

    @FXML
    private Button SignupButton;

    @FXML
    void handleSignUpBtn(ActionEvent event) {

    }

    @FXML
    private ChoiceBox<?> role;

    @FXML
    private Button SignIn;
    @FXML
    void handleSignin(ActionEvent event) throws IOException {

        Resident obj=new Resident("Shahid","Hameed",2,"2333","wwww", "123");
        ResidentController.owner=obj;
        //ResidentController.setName(obj.getFirstName());
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void initialize() {
        assert signUpBtn != null : "fx:id=\"signUpBtn\" was not injected: check your FXML file 'new.fxml'.";
        assert loaderPane != null : "fx:id=\"loaderPane\" was not injected: check your FXML file 'new.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'new.fxml'.";
        assert detailsPane != null : "fx:id=\"detailsPane\" was not injected: check your FXML file 'new.fxml'.";
        assert SignupButton != null : "fx:id=\"SignupButton\" was not injected: check your FXML file 'new.fxml'.";

    }
}
