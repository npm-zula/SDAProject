package HSMS.Owner;

import HSMS.DBHandlers.OwnerDBHandler;

import java.util.ArrayList;

public class OwnerRecords {

    ArrayList<Owner> ownerRecords = new ArrayList<Owner>();
    OwnerDBHandler db = new OwnerDBHandler();

    void addOwner(String fname, String lname, String email, int cnic, int age){
        Owner temp = new Owner(fname,lname,age, cnic,email);
        ownerRecords.add(temp);
        db.saveOwner(temp);
    }

    Owner getOwner(int cnic) {
        for (Owner o : ownerRecords) {
            if (o.getcNIC() == cnic) {
                return o;
            }
        }
        return null;
    }


}
