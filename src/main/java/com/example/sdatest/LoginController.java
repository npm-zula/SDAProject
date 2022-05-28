package com.example.sdatest;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HSMS.HSMS;
import HSMS.Resident.Resident;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

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
    private TextField userName;

    @FXML
    private PasswordField password;

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
    private ChoiceBox<String> role;

    @FXML
    private Button SignIn;
    @FXML
    void handleSignin(ActionEvent event) throws IOException {
        if(role.getValue().equalsIgnoreCase("Resident")){
            if(HSMS.getHsms().residentLogin(userName.getText(),password.getText())!=null){
            }
            else{
                return;
            }
            Resident obj=HSMS.getHsms().residentLogin(userName.getText(),password.getText());
            ResidentController.owner=obj;

            root = FXMLLoader.load(getClass().getResource("Resident/ResidentDashboard.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (role.getValue().equalsIgnoreCase("Admin")) {

            //ResidentController.setName(obj.getFirstName());
            root = FXMLLoader.load(getClass().getResource("Admin/Admin.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void BackBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
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
