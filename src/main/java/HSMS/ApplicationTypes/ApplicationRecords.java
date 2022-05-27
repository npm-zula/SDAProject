package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;
import HSMS.DBHandlers.ApplicationDBhandler;
import HSMS.Owner.Resident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationRecords {

    ArrayList<Application> ApplicationRecord = new ArrayList<Application>();
    ApplicationDBhandler db = new ApplicationDBhandler();


    public int assignID(){
        int t = 0;
        boolean check = false;
        while(!check){
            t = genID();
            if(!exists(t)){
                System.out.println("sss "+t);
                return t;
            }
        }
        return t;
    }

    public int genID(){
        int min = 10000;
        int max = 20000;

        int tempID = (int)(Math.random()*(max-min+1)+min);

        return tempID;
    }

    public boolean exists(int ID){
        for(Application a: ApplicationRecord){
            if (a.getID() == ID)
                return true;
        }

        return false;
    }

    public Application getApplication(int ID){
        for(Application a: ApplicationRecord){
            if (a.getID() == ID)
                return a;
        }

        return null;
    }

    //ADDING APPLICATIONS TO RECORDS
    public Application createRegApplication(Resident applicant, String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
        RegistrationApplication temp = new RegistrationApplication();
        temp.applicant = applicant;
        temp.houseNo = houseNo;
        temp.size = size;
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.age = oAge;
        temp.oCnic = oCnic;
        temp.type = 1;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        db.saveRegApplication(temp);

        return temp;
    }

    public Application createTransferApplication(String RFName, String RLName,  int RCnic, String oFName, String oLName,  int oCnic, String HouseNo){
        OwnerTransferApplication temp = new OwnerTransferApplication();
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.RCnic = RCnic;
        temp.RFName = RFName;
        temp.RLName = RLName;
        temp.type = 2;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        db.saveOTApplication(temp);
        return temp;
    }

    public Application createRentApplication(String RFName, String RLName, int RCnic, String oFName, String oLName, int oCnic, int rent, int increment){
        RentingApplication temp = new RentingApplication();
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.RCnic = RCnic;
        temp.RFName = RFName;
        temp.RLName = RLName;
        temp. rent = rent;
        temp. increment = increment;
        temp.ID = assignID();
        temp.type = 3;
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        db.saveRentingApplication(temp);
        return temp;
    }

    public Application createEtagApplication(String oFName, String oLName, String oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others, Resident applicant){
//        EtagApplication temp = new EtagApplication();
//        temp.OFName = oFName;
//        temp.OLName = oLName;
//        temp.oCnic = oCnic;
//        temp.others = others;
//        temp.vNo = vNo;
//        temp.vType = vType;
//        temp.vMake = vMake;
//        temp.vYear = vYear;
//        temp.vEngineSize = vEngineSize;
//        temp.type = 4;
//        temp.ID = assignID();
//        temp.applicationStatus = "NE";


        EtagApplication temp2=new EtagApplication(oFName, oLName, oCnic, vNo, vType, vYear, vMake, vEngineSize, others, applicant);
        temp2.ID = assignID();
        temp2.applicant=applicant;
        ApplicationRecord.add(temp2);

        System.out.println("CREATED111");
        //db.saveEtagApplication(temp);
        return temp2;
    }



    public void updateRecords() throws SQLException {
        updateOTRecords();
        updateRTRecords();
        updateETRecords();
    }

    public void updateOTRecords() throws SQLException {
        ResultSet rs = db.retrieveList(2);
        if(rs != null){
            while(rs.next()){
                OwnerTransferApplication temp = new OwnerTransferApplication();
                temp.ID = rs.getInt("ID");
                temp.OFName = rs.getString("OFName");
                temp.OLName = rs.getString("OLName");
                temp.oCnic = rs.getInt("oCNIC");
                temp.RFName = rs.getString("RFName");
                temp.RLName = rs.getString("RLName");
                temp.RCnic = rs.getInt("RCNIC");
                temp.type = rs.getInt("ApplicationType");
            }
        }

    }

    public void updateRTRecords() throws SQLException {
        ResultSet rs = db.retrieveList(3);

        while(rs.next()){
            RentingApplication temp = new RentingApplication();
            temp.ID = rs.getInt("ID");
            temp.OFName = rs.getString("OFName");
            temp.OLName = rs.getString("OLName");
            temp.oCnic = rs.getInt("oCNIC");
            temp.RFName = rs.getString("RFName");
            temp.RLName = rs.getString("RLName");
            temp.RCnic = rs.getInt("RCNIC");
            temp.rent = rs.getInt("RENT");
            temp.increment = rs.getInt("INCREMENT");
            temp.type = rs.getInt("ApplicationType");
        }
    }

    public void updateETRecords() throws SQLException {
        ResultSet rs = db.retrieveList(4);

        while(rs.next()){
            EtagApplication temp = new EtagApplication();
            temp.ID = rs.getInt("ID");
            temp.OFName = rs.getString("OFName");
            temp.OLName = rs.getString("OLName");
            temp.vNo =  rs.getString("VehichleNo");
            temp.vType  = rs.getString("vehicleType");
            temp.vMake = rs.getString("VehicleMake");
            temp.vYear = rs.getString("VehicleYear");
            temp.vEngineSize = rs.getInt("EngineSize");
            temp.others = rs.getInt("Others") == 1;

            temp.type = rs.getInt("ApplicationType");
        }
    }






}
