package HSMS;

import HSMS.Applicant.Applicant;
import HSMS.Applicant.ApplicantRecords;
import HSMS.ApplicationTypes.*;
import HSMS.Complaint.Complaint;
import HSMS.Complaint.ComplaintRecords;




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


    public Applicant createApplicant(String fname, String lname, int cnic, String email, boolean check){
        if(!check)
            return applicantRecords.applicantCreation(fname, lname, cnic,email);
        else
          return applicantRecords.applicantCreation(fname, lname,cnic,email,check);
    }

    public Application propertyRegistrationApplication(int ApplicationNo,String houseNo, String size, String oFName, String oLName, int oAge, int oCnic){
        Applicant tempApplicant = applicantRecords.getApplicant(ApplicationNo);
        if(tempApplicant.getID() != 0)
              return  applicationRecords.createRegApplication(tempApplicant,houseNo,size,oFName,oLName,oAge,oCnic);

        return null;
    }

    public Application propertyTransApplication(Applicant applicant,String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic){
        return  applicationRecords.createTransferApplication(applicant,RFName,RLName,RCNIC,oFName,oLName,oCnic);
    }
    public Application propertyRentingApplication(Applicant applicant,String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, int rent, int increment){
        return  applicationRecords.createRentApplication(applicant,RFName,RLName,RCNIC,oFName,oLName,oCnic, rent, increment);
    }

    public Application etagApplication(Applicant applicant, String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
        return  applicationRecords.createEtagApplication(applicant,oFName,oLName,oCnic,vNo,vType,vYear,vMake,vEngineSize,others);
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
