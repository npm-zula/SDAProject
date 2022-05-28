package HSMS.Owner;

import HSMS.DBHandlers.OwnerDBHandler;
import HSMS.House;

import java.util.HashMap;
import java.util.Map;

public class residentRecords {

    private HashMap<String,Resident> residentRecords =new HashMap<>();
    OwnerDBHandler db = new OwnerDBHandler();

   public Resident addResident(String fname, String lname, String email, String cnic, int age, String password, House house){
        Resident temp = new Resident(fname,lname,age, cnic,email, password,house);

        if(this.exist(cnic)){
            this.residentRecords.get(cnic).alotHouse(house);
        }
        else{
            residentRecords.put(cnic,temp);
        }

        //db.saveOwner(temp);
        return temp;
    }

    Resident getResident(String cnic) {
        return residentRecords.get(cnic);

    }
    public boolean checkOwner(String hNo,String ownerId){
        if(this.residentRecords.get(ownerId)!=null){
            Resident temp=this.residentRecords.get(ownerId);
            return temp.hasHouse(hNo);
        }
        return false;
    }
    public boolean exist(String ownerId){
        if(this.residentRecords.get(ownerId)!=null){

            return true;
        }
        return false;
    }



    public Resident Login(String cNIC,String password){

        Resident temp=new Resident("Shahid","Hameed",2,"","wwww", "",null);
        this.residentRecords.put(temp.getCnic(), temp);


        for (Map.Entry<String, Resident> set : residentRecords.entrySet()) {
            Resident objOwner=set.getValue();
            if (objOwner.login(cNIC,password))
                return objOwner;
        }


        return null;
    }



}
