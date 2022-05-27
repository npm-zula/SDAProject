package HSMS.Owner;

import HSMS.Applicant.ApplicantRecords;

import java.util.HashMap;

public class Owner {
    private String firstName;
    private String lastName;
    private int age;
    private String cNIC;
    private String emailAddress;
    private String password;




    private HashMap<String, ApplicantRecords> applications=new HashMap<>();



    public Owner(String firstName, String lastName, int age, String cNIC, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cNIC = cNIC;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getcNIC() {
        return cNIC;
    }

    public void setcNIC(String cNIC) {
        this.cNIC = cNIC;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }
    public boolean login(String cNIC,String password){
        if(this.password.equals(password)&&this.cNIC.equals(cNIC)){
return true;
        }
        return false;
    }

}
