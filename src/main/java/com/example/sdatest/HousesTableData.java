package com.example.sdatest;

import javafx.beans.property.SimpleStringProperty;
public class HousesTableData {

     SimpleStringProperty hNo=new SimpleStringProperty();
     SimpleStringProperty blockN=new SimpleStringProperty();
     SimpleStringProperty desc=new SimpleStringProperty();


    public String gethNo() {
        return hNo.get();
    }

    public SimpleStringProperty hNoProperty() {
        return hNo;
    }

    public void sethNo(String hNo) {
        this.hNo.set(hNo);
    }

    public String getBlockN() {
        return blockN.get();
    }

    public SimpleStringProperty blockNProperty() {
        return blockN;
    }

    public void setBlockN(String blockN) {
        this.blockN.set(blockN);
    }

    public String getDesc() {
        return desc.get();
    }

    public SimpleStringProperty descProperty() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.set(desc);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    SimpleStringProperty type=new SimpleStringProperty();;

    HousesTableData(String hNo, String blockN, String desc, String type) {
        this.hNo = new SimpleStringProperty(hNo);
        this.blockN = new SimpleStringProperty(blockN);
        this.desc = new SimpleStringProperty(desc);
        this.type = new SimpleStringProperty(type);
    }



}
