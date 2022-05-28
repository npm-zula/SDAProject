package com.example.sdatest;

import HSMS.Applicant.Applicant;
import HSMS.ApplicationTypes.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static HSMS.HSMS.getHsms;

public class GuestController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void BackBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Guest/GuestDashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void MenuBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ApplyRegBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Guest/GuestPropertyRegistration.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void ApplicationStatusBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Guest/RegistrationApplicationStatus.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField appIDStatusField;

    @FXML
    public void ApplicationStatusPopUP(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Guest/ApplicationStatusPopUP.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Application application = getHsms().getApplicationStatus(Integer.parseInt(appIDStatusField.getText()));

        ApplicationStatusPOPUPController a = fxmlLoader.getController();
        a.display(String.valueOf(application.getID()) ,application.getApplicationStatus(),application.getApplicant().getFirstName() + " " + application.getApplicant().getLastName());

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    // BUSINESS LOGIC CONNECTIONS

    @FXML // fx:id="aCNIC"
    private TextField aCNIC; // Value injected by FXMLLoader

    @FXML // fx:id="aEmail"
    private TextField aEmail; // Value injected by FXMLLoader

    @FXML // fx:id="afName"
    private TextField afName; // Value injected by FXMLLoader

    @FXML // fx:id="alName"
    private TextField alName; // Value injected by FXMLLoader


    @FXML
    void createApplicant(ActionEvent event) throws IOException {
        Applicant app =  getHsms().createApplicant(afName.getText(),alName.getText(),Integer.parseInt(aCNIC.getText()), aEmail.getText(),false);
        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Guest/ApplicantSuccessPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicantID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    @FXML // fx:id="HouseSize"
    private ChoiceBox<String> HouseSize; // Value injected by FXMLLoader

    @FXML // fx:id="appID"
    private TextField appID; // Value injected by FXMLLoader

    @FXML // fx:id="houseNo"
    private TextField houseNo; // Value injected by FXMLLoader

    @FXML // fx:id="oAge"
    private TextField oAge; // Value injected by FXMLLoader

    @FXML // fx:id="oCNIC"
    private TextField oCNIC; // Value injected by FXMLLoader

    @FXML // fx:id="oEmail"
    private TextField oEmail; // Value injected by FXMLLoader

    @FXML // fx:id="oFName"
    private TextField oFName; // Value injected by FXMLLoader

    @FXML // fx:id="oLName"
    private TextField oLName; // Value injected by FXMLLoader


    @FXML
    void propertyRegistrationApplication(ActionEvent event) throws IOException {
      //  System.out.println(Integer.parseInt(appID.getText()));
       // Application app = getHsms().propertyRegistrationApplication(Integer.parseInt(appID.getText()),houseNo.getText(),HouseSize.getValue(),oFName.getText(),oLName.getText(),Integer.parseInt(oAge.getText()),Integer.parseInt(oCNIC.getText()));
      //  System.out.println(app.toString());

        Application app =  getHsms().propertyRegistrationApplication(Integer.parseInt(appID.getText()),houseNo.getText(),HouseSize.getValue(),oFName.getText(),oLName.getText(),Integer.parseInt(oAge.getText()),Integer.parseInt(oCNIC.getText()));
        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Guest/ApplicationSuccessPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicationID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }







}
