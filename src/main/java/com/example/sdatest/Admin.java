package com.example.sdatest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class Admin {

    fullUIController UI=fullUIController.getInstance();

    static Admin admin;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> role1;

    @FXML
    private ChoiceBox<?> role11;

    @FXML
    private ChoiceBox<?> role;

    @FXML
    private Label allocatedHouses;

    @FXML
    private TableColumn<HousesTableData, String> DescHouse;

    @FXML
    private Label remainingHouses;

    @FXML
    private Label confirmationHouseAdd;

    @FXML
    private Label totalHouses;

    @FXML
    private TableColumn<HousesTableData, String> Htype;

    @FXML
    private Button addHouse;

    @FXML
    private TextField descriptionHouse;

    @FXML
    private Button addHouse1;

    @FXML
    private Button viewSocietyDetails1;

    @FXML
    private TableView<HousesTableData> TableHouses;

    @FXML
    private TableColumn<HousesTableData, String> HouseBlock;

    @FXML
    private HBox loaderPane;

    @FXML
    private Button viewSocietyDetails;

    @FXML
    private Button Logout;

    @FXML
    private TextField deleteHouseSr;

    @FXML
    private TableColumn<HousesTableData, String> hrSR;

    @FXML
    private StackPane mainPane;

    @FXML
    private VBox detailsPane;

    @FXML
    void handleLogout(ActionEvent event) {

    }



    @FXML
    void handleLoginBtn(ActionEvent event) {

    }



    @FXML
    void handleAddHouse(ActionEvent event) {

    }




    @FXML
    void handleSocietyDetails(ActionEvent event) {

    ArrayList<House> houses=UI.getHouses();
    int i=0;
        final ObservableList<HousesTableData> data = FXCollections.observableArrayList(

        );
        for (int z = 0; z < houses.size(); z++) {
            data.add(new HousesTableData(houses.get(i).gethNo(),houses.get(i).getBlockN(),houses.get(i).getDesc(),houses.get(i).getType()));

            System.out.println("aaaa  "+houses.get(i).gethNo());
        }
//        TableColumn hrSR = new TableColumn("hrSR");
//        TableColumn HouseBlock = new TableColumn("HouseBlock");
//        TableColumn Htype = new TableColumn("Htype");
//        TableColumn DescHouse = new TableColumn("DescHouse");
//
       hrSR.setCellValueFactory(new PropertyValueFactory("hNo"));
        Htype.setCellValueFactory(new PropertyValueFactory("type"));
        DescHouse.setCellValueFactory(new PropertyValueFactory("desc"));
        HouseBlock.setCellValueFactory(new PropertyValueFactory("blockN"));


        TableHouses.setItems(data);



    }



    @FXML
    void handleHouses(ActionEvent event) {

    }



    @FXML
    void handleHouseDel(ActionEvent event) {

    }


}

