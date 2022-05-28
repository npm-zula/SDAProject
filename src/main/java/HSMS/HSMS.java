package HSMS;

import HSMS.Applicant.Applicant;
import HSMS.Applicant.ApplicantRecords;
import HSMS.ApplicationTypes.*;
import HSMS.Complaint.Complaint;
import HSMS.Complaint.ComplaintRecords;
import HSMS.Property.House;
import HSMS.Resident.Owner;
import HSMS.Resident.OwnerRecords;
import HSMS.Resident.Resident;
import HSMS.Resident.residentRecords;

import java.sql.SQLException;
import java.util.ArrayList;


public class HSMS {

    private static HSMS hsms = null;
//    Application regApplication = new RegistrationApplication();
//    Application oTApplication = new OwnerTransferApplication();
//    Application rentingApplication = new RentingApplication();
//    Application EtagApplication = new EtagApplication();
    ApplicationRecords applicationRecords = new ApplicationRecords();
    ComplaintRecords complaintRecords = new ComplaintRecords();
    ApplicantRecords applicantRecords = new ApplicantRecords();

    residentRecords residents = new residentRecords();
    OwnerRecords owners = new OwnerRecords();
    Admin admin=new Admin();
    ArrayList<House> houses=new ArrayList<House>();


    public static HSMS getHsms(){
        if(hsms == null){
            hsms = new HSMS();
        }
        return hsms;
    }


    public void start() throws SQLException {
        applicationRecords.updateRecords();
        complaintRecords.updateRecords();
        applicantRecords.updateRecords();

        applicationRecords.getApplications();
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

    public Application propertyTransApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, String HouseNo){

        return  applicationRecords.createTransferApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic,HouseNo);
    }

    public Application propertyRentingApplication(String RFName, String RLName, int RCNIC, String oFName, String oLName,  int oCnic, int rent, int increment){


        return  applicationRecords.createRentApplication(RFName,RLName,RCNIC,oFName,oLName,oCnic, rent, increment);
    }

    public Application etagApplication(String oFName, String oLName, int oCnic, String vNo, String vType, String vYear, String vMake, int vEngineSize, boolean others){
        return  applicationRecords.createEtagApplication(oFName,oLName,oCnic,vNo,vType,vYear,vMake,vEngineSize,others);
    }

    public int complaintRegistration(String HouseNo, String problem, String email){
        return complaintRecords.launchComplaint(HouseNo, email, problem).getID();
    }

    public Application getApplicationStatus(int appID){
            return applicationRecords.getApplication(appID);
    }

    public Complaint getComplaint(int ID){
        Complaint temp = complaintRecords.getComplaint(ID);

        return temp;
    }


    //2.0
    public void regHouse(String fname, String lname, String email, String cnic, int age, String password, String hNo){
        House temp=new House();
        temp=temp.getHouse(hNo,this.houses);

        Resident tempRes=this.residents.addResident(fname,lname,email,cnic,age,password,temp);
        Owner obj= this.owners.addOwner(fname,lname,email,cnic,age,password,temp);
        temp.alotHouse(this.houses,obj,hNo);
    }


    public ArrayList<EtagApplication> getEtagApps() {

        return this.applicationRecords.getEtagApps();
    }

    public boolean checkOwner(String hNo,String owner){
        return this.residents.checkOwner(hNo,owner);
    }

    public void updateApplicationStatus(String status, String applicationId){
        this.applicationRecords.updateApplicationStatus(status,applicationId);
    }

    public ArrayList<House> getHouses() {

        return houses;
    }

    public void addHouse(String block,String Desc,String type){

        House temp=new House();
        temp.addHouse(block,Desc,type,this.houses);

    }

    public Resident residentLogin(String cnic,String pass){
        return this.residents.Login(cnic,pass);
    }


}
