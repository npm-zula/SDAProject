package com.example.sdatest;

import java.util.ArrayList;

public class fullUIController {
ArrayList <House> houses=new ArrayList<House>();
    private static fullUIController objInstance;
    private fullUIController() {


    }
    public static fullUIController getInstance() {
        if(objInstance==null) {
            objInstance=new fullUIController();
        }

        return objInstance;
    }

    public ArrayList<House> getHouses() {
        //populateData


        this.houses.add(new House("10","2","Good","2apt"));
        this.houses.add(new House("11","2","Good","2apt"));
        this.houses.add(new House("12","3","Good","2apt"));
        this.houses.add(new House("13","23","Good","2apt"));


        return houses;
    }






}
