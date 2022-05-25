package com.example.sdatest;

import HSMS.Applicant.Applicant;
import HSMS.Complaint.Complaint;
import HSMS.HSMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static HSMS.HSMS.getHsms;

public class ResidentController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void BackBtn(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentDashboard.fxml"));
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
    public void ApplyRent(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentRentingApplication.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void TransferProperty(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentOwnershipTransfer.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void EtagApplication(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/EtagApplication.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Complaints(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Resident/ResidentComplaintReg.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //COMPLAINTS
    @FXML
    private TextField emailTextField;

    @FXML
    private TextField houseTextField;

    @FXML
    private ChoiceBox<String> problemChoiceBox;

    @FXML
    public void ComplaintReg(ActionEvent actionEvent) throws IOException {

        int temp =  getHsms().complaintRegistration(houseTextField.getText(),problemChoiceBox.getValue(),emailTextField.getText());

        Parent root1;
        String complaintID = String.valueOf(temp);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ComplaintIDPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayComplaintID(complaintID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    @FXML
    private TextField complaintIDtextField;

    @FXML
    private Label checkComplaintIDLabel;
    @FXML
    private Label checkComplaintProblemLabel;
    @FXML
    private Label checkComplaintStatusLabel;

    public void getComplaintInfo(ActionEvent actionEvent){
        Complaint temp = getHsms().getComplaint(Integer.parseInt(complaintIDtextField.getText()));

        checkComplaintIDLabel.setText(String.valueOf(temp.getID()));
        checkComplaintProblemLabel.setText(temp.getProblem());
        checkComplaintStatusLabel.setText(temp.getComplaintStatus());

    }


    //OT APPLICATION

    @FXML
    private TextField aCNIC;

    @FXML
    private TextField aEmail;

    @FXML
    private TextField afName;

    @FXML
    private TextField alName;


    @FXML
    void createApplicant(ActionEvent event) throws IOException {
        Applicant app =  getHsms().createApplicant(afName.getText(),alName.getText(),Integer.parseInt(aCNIC.getText()), aEmail.getText(),true);
        Parent root1;
        String appID = String.valueOf(app.getID());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resident/ApplicantSuccessPopUP.fxml"));
        root1 = loader.load();

        popUPcontroller p = loader.getController();
        p.displayapplicantID(appID);

        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }







}
