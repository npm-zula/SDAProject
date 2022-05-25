package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;
import HSMS.DBHandlers.ApplicationDBhandler;

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
    public Application createRegApplication(Applicant applicant, String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
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

    public Application createRentApplication(Applicant applicant, String RFName, String RLName, int RCnic, String oFName, String oLName, int oCnic, int rent, int increment){
        RentingApplication temp = new RentingApplication();
        temp.applicant = applicant;
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

        return temp;
    }

    public Application createEtagApplication(Applicant applicant, String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
        EtagApplication temp = new EtagApplication();
        temp.applicant = applicant;
        temp.OFName = oFName;
        temp.OLName = oLName;
        temp.oCnic = oCnic;
        temp.others = others;
        temp.vNo = vNo;
        temp.vType = vType;
        temp.vMake = vMake;
        temp.vYear = vYear;
        temp.vEngineSize = vEngineSize;
        temp.type = 4;
        temp.ID = assignID();
        temp.applicationStatus = "NE";
        ApplicationRecord.add(temp);
        return temp;
    }

    public Application createTransferApplication(Applicant applicant,  String RFName, String RLName,  int RCnic, String oFName, String oLName,  int oCnic){
        OwnerTransferApplication temp = new OwnerTransferApplication();
        temp.applicant = applicant;
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
        return temp;
    }






}
