package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;
import HSMS.Owner.Resident;

import java.util.Date;

public abstract class Application {

    Resident applicant;
    int ID;
    int type; // 1 => Registration, 2 => Transfer, 3 => Renting,  4 => ETagApplication
    String applicationStatus; // A = Approved ,  R = Rejected , NE =  NotEvaluated
    Date applyingDate;

    public int getID() {
        return ID;
    }

    public Resident getApplicant() {
        return applicant;
    }

    public String getApplicationStatus() {
        if(applicationStatus.equals("NE"))
            return "NOT EVALUATED";
        else if(applicationStatus.equals("R"))
            return "REJECTED";
        else
            return "Approved";
    }

    public int getType() {
        return type;
    }

    //    Property property;
//    Tenant tenant;
//    int type;

//    Application(Applicant applicant, Property property){
//        this.applicant = applicant;
//        this.property = property;
//    }
//
//    Application(Applicant applicant, Property property, Tenant tenant){
//        this.applicant = applicant;
//        this.property = property;
//        this.tenant = tenant;
//    }

//    void createRegApplication(Applicant a, Property p) {
//        Application tempApplication = new Application(a,p);
//
//        //save tempApplicaiton to SQL
//    }


    @Override
    public String toString() {
        return "Application{" +
                "applicant=" + applicant +
                ", ID=" + ID +
                ", type=" + type +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
