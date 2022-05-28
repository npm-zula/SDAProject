package HSMS.ApplicationTypes;

import HSMS.Applicant.Applicant;

public abstract class Application {

    Applicant applicant;
    int ID;
    int type; // 1 => Registration, 2 => Transfer, 3 => Renting,  4 => ETagApplication
    String applicationStatus; // A = Approved ,  R = Rejected , NE =  NotEvaluated

    public int getID() {
        return ID;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public String getApplicationStatus() {
        if(applicationStatus.equals("NE"))
            return "NOT EVALUATED";
        else if(applicationStatus.equals("RE"))
            return "REJECTED";
        else
            return "Approved";
    }

    public String getStatus(){
        return applicationStatus;
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





}
