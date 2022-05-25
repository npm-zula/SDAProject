package HSMS.Complaint;

import HSMS.DBHandlers.ComplaintsDBHandler;

import java.util.ArrayList;

public class ComplaintRecords {

    ArrayList<Complaint> ComplaintRecord = new ArrayList<>();
    ComplaintsDBHandler db = new ComplaintsDBHandler();

    public int genID(){
        int min = 10000;
        int max = 20000;

        int tempID = (int)(Math.random()*(max-min+1)+min);

        return tempID;
    }

    public boolean exists(int ID){
        for(Complaint c: ComplaintRecord){
            if (c.getID() == ID)
                return true;
        }

        return false;
    }

    public Complaint getComplaint(int ID){
        for(Complaint c: ComplaintRecord){
            if (c.getID() == ID)
                return c;
        }

       return null;
    }

    public Complaint launchComplaint(String HouseNo, String email, String problem){
                Complaint temp =  new Complaint();
                temp.emailAddress = email;
                temp.houseNo = HouseNo;
                temp.problem = problem;
                temp.complaintStatus = "NE";
                boolean check = false;
                while(!check){
                    int t = genID();
                    if(!exists(t)){
                        temp.ID = t;
                        check = true;
                    }
                }

                //SQL
                db.saveComplaint(temp);
                ComplaintRecord.add(temp);

                return temp;
    }


}
