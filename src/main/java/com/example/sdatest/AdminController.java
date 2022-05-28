package com.example.sdatest;

import HSMS.Admin;
import HSMS.ApplicationTypes.EtagApplication;
import HSMS.HSMS;
import HSMS.House;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {



    static Admin admin;

    @FXML
    private URL location;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ResourceBundle resources;
    @FXML
    private ChoiceBox<?> role11;

    @FXML
    private ChoiceBox<?> role;

    @FXML
    private Label allocatedHouses;

    @FXML
    private TextField bkNo;



    @FXML
    private ChoiceBox<String> houseType;





    @FXML
    private Label remainingHouses;

    @FXML
    private Label confirmationHouseAdd;

    @FXML
    private Label totalHouses;



    @FXML
    private Button addHouse1;

    @FXML
    private Button viewSocietyDetails1;

    @FXML
    private TableView<TableData> TableHouses;

    @FXML
    private TableColumn<TableData, String> HouseBlock;
    @FXML
    private TableColumn<TableData, String> hrSR;
    @FXML
    private TableColumn<TableData, String> Htype;
    @FXML
    private TextField descriptionHouse;
    @FXML
    private TableColumn<TableData, String> DescHouse;

    @FXML
    private TableView<TableData> TableHouses1;

    @FXML
    private TableColumn<TableData, String> HouseBlock1;
    @FXML
    private TableColumn<TableData, String> hrSR1;
    @FXML
    private TableColumn<TableData, String> Htype1;
    @FXML
    private TableColumn<TableData, String> DescHouse1;


    @FXML
    private HBox loaderPane;

    @FXML
    private Button viewSocietyDetails;

    @FXML
    private Button Logout;

    @FXML
    private TextField deleteHouseSr;



    @FXML
    private StackPane mainPane;

    @FXML
    private VBox detailsPane;

    @FXML
    void handleLogout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Admin/new.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void handleLoginBtn(ActionEvent event) {

    }



    @FXML
    void handleAddHouse(ActionEvent event) {
        try{
            HSMS.getHsms().addHouse(bkNo.getText(),descriptionHouse.getText().toString(),houseType.getValue());


        }catch (Exception e){

        }



    }




    @FXML
    void handleSocietyDetails(ActionEvent event) {

    ArrayList<House> houses= HSMS.getHsms().getHouses();
    int i=0;
        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for (int z = 0; z < houses.size(); z++) {
            data.add(new TableData(houses.get(i).gethNo(),houses.get(i).getBlockN(),houses.get(i).getDesc(),houses.get(i).getType()));

            System.out.println("aaaa  "+houses.get(i).gethNo());
            i++;
        }

       hrSR.setCellValueFactory(new PropertyValueFactory("data1"));
        Htype.setCellValueFactory(new PropertyValueFactory("data2"));
        DescHouse.setCellValueFactory(new PropertyValueFactory("data3"));
        HouseBlock.setCellValueFactory(new PropertyValueFactory("data4"));


        TableHouses.setItems(data);



    }
    @FXML
    void handleSocietyDetails1(ActionEvent event) {

        ArrayList<House> houses= HSMS.getHsms().getHouses();
        int i=0;
        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for (int z = 0; z < houses.size(); z++) {
            data.add(new TableData(houses.get(i).gethNo(),houses.get(i).getBlockN(),houses.get(i).getDesc(),houses.get(i).getType()));
            i++;
        }

        hrSR1.setCellValueFactory(new PropertyValueFactory("data1"));
        Htype1.setCellValueFactory(new PropertyValueFactory("data2"));
        DescHouse1.setCellValueFactory(new PropertyValueFactory("data3"));
        HouseBlock1.setCellValueFactory(new PropertyValueFactory("data4"));


        TableHouses1.setItems(data);



    }



    @FXML
    void handleHouses(ActionEvent event) {



    }



    @FXML
    void handleHouseDel(ActionEvent event) {

    }


    @FXML
    private TableView<TableData> TableEtag;

    @FXML
    private TableColumn<TableData,String> applicantNameEtag;
    @FXML
    private TableColumn<TableData, String> vehNo;
    @FXML
    private TableColumn<TableData, String> appNoEtag;
    @FXML
    private TableColumn<TableData, String> vType;
    @FXML
    private TableColumn<TableData, String> dateVehicle;
    @FXML
    private TextField passAlot;

    @FXML
    private TextField cnicAlot;
    @FXML
    private TextField emailAlot;
    @FXML
    private TextField LnameAlot;

    @FXML
    private TextField fnameAlot;
    public void handleHouseAlot(ActionEvent actionEvent) {

    HSMS.getHsms().alotHouse(fnameAlot.getText(),LnameAlot.getText(),emailAlot.getText(),cnicAlot.getText(),20,passAlot.getText(),TableHouses1.getSelectionModel().getSelectedItem().getData1());

    }

    public void viewEtag(ActionEvent actionEvent) {
        ArrayList<EtagApplication> eTag= HSMS.getHsms().getEtagApps();
        int i=0;
        final ObservableList<TableData> data = FXCollections.observableArrayList(

        );
        for ( i = 0; i < eTag.size(); i++) {
           if( eTag.get(i).getApplicationStatus().equals("NOT EVALUATED")) {
                data.add(new TableData(Integer.toString(eTag.get(i).getID()), eTag.get(i).getvNo(), eTag.get(i).getvType(), eTag.get(i).getApplicant().getFirstName(), eTag.get(i).getDate().toString()));

                System.out.println("aaaa  " + eTag.get(i).getID());
            }
        }
        appNoEtag.setCellValueFactory(new PropertyValueFactory("data1"));
        vehNo.setCellValueFactory(new PropertyValueFactory("data2"));
        vType.setCellValueFactory(new PropertyValueFactory("data3"));
        applicantNameEtag.setCellValueFactory(new PropertyValueFactory("data4"));
        dateVehicle.setCellValueFactory(new PropertyValueFactory("data5"));


        TableEtag.setItems(data);
    }

    public void handleEtag(SortEvent<TableView> tableViewSortEvent) {
    }

    public void approveEtag(ActionEvent actionEvent) {
        try{
            TableData temp=TableEtag.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("A", temp.getData1());

        }catch(Exception e){

        }



    }

    public void rejEtag(ActionEvent actionEvent) {
        try{
            TableData temp=TableEtag.getSelectionModel().getSelectedItem();
            System.out.println(temp.getData2());
            HSMS.getHsms().updateApplicationStatus("R", temp.getData1());

        }catch(Exception e){

        }
    }



    public void handleHouses1(SortEvent<TableView<TableData>> tableViewSortEvent) {
    }
}

