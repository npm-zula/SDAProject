package HSMS.Owner;

import HSMS.DBHandlers.OwnerDBHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OwnerRecords {


    private HashMap<String,Owner> ownerRecords=new HashMap<>();
    OwnerDBHandler db = new OwnerDBHandler();

    void addOwner(String fname, String lname, String email, String cnic, int age,String password){
        Owner temp = new Owner(fname,lname,age, cnic,email, password);
        ownerRecords.put(cnic,temp);
        db.saveOwner(temp);
    }

    Owner getOwner(String cnic) {
        return ownerRecords.get(cnic);

    }
    Owner Login(String cNIC,String password){

        for (Map.Entry<String, Owner> set : ownerRecords.entrySet()) {
            Owner objOwner=set.getValue();
            if (objOwner.login(cNIC,password))
                return objOwner;
        }


        return null;
    }


}
