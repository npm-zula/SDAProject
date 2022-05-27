package HSMS;

import HSMS.Applicant.Applicant;
import HSMS.Applicant.ApplicantRecords;
import HSMS.ApplicationTypes.*;
import HSMS.Complaint.Complaint;
import HSMS.Complaint.ComplaintRecords;
import HSMS.Owner.Resident;

import java.sql.SQLException;


public class HSMS {

    private static HSMS hsms = null;
//    Application regApplication = new RegistrationApplication();
//    Application oTApplication = new OwnerTransferApplication();
//    Application rentingApplication = new RentingApplication();
//    Application EtagApplication = new EtagApplication();
    ApplicationRecords applicationRecords = new ApplicationRecords();
    ComplaintRecords complaintRecords = new ComplaintRecords();
    ApplicantRecords applicantRecords = new ApplicantRecords();


    public static HSMS getHsms(){
        if(hsms == null){
            hsms = new HSMS();
        }
        return hsms;
    }


    public void start() throws SQLException {
      //  applicationRecords.updateRecords();

    }


    public Applicant createApplicant(String fname, String lname, int cnic, String email, boolean check){
        if(!check)
            return applicantRecords.applicantCreation(fname, lname, cnic,email);
        else
          return applicantRecords.applicantCreation(fname, lname,cnic,email,check);
    }

//    public Application propertyRegistrationApplication(int ApplicationNo,String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
//        Resident tempApplicant = applicantRecords.getApplicant(ApplicationNo);
//        if(tempApplicant.getID() != 0)
//              return  applicationRecords.createRegApplication(tempApplicant,houseNo,size,oFName,oLName,oAge,oCnic);
//
//        return null;
//    }

    public Application propertyTransApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, String HouseNo){


        return  applicationRecords.createTransferApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic,HouseNo);
    }

    public Application propertyRentingApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, int rent, int increment){


        return  applicationRecords.createRentApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic, rent, increment);
    }

    public Application etagApplication(String oFName, String oLName, String oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others, Resident user){


        Application temp = applicationRecords.createEtagApplication(oFName,oLName,oCnic,vNo,vType,vYear,vMake,vEngineSize,others,user);

        return temp;
    }

    public Application getApplicationStatus(int appID){
            return applicationRecords.getApplication(appID);
    }

    public int complaintRegistration(String HouseNo, String problem, String email){
           return complaintRecords.launchComplaint(HouseNo, email, problem).getID();
    }

    public Complaint getComplaint(int ID){
        Complaint temp = complaintRecords.getComplaint(ID);

        return temp;
    }

}
