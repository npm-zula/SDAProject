package HSMS.Owner;

import java.util.HashMap;

public class Resident {
    private int ID;
    private String firstName;
    private String lastName;
    private String cnic;
    private String emailAddress;
    private String password;
    private HashMap<String,Resident> residents=new HashMap<>();


    public int getID() {
        return ID;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Resident( String firstName, String lastName,int ID, String cnic, String emailAddress,String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnic = cnic;
        this.emailAddress = emailAddress;
        this.password=password;
    }

    public HashMap<String, Resident> getResidents() {
        return residents;
    }
    public Resident getResident(String cnic) {
        return residents.get(cnic);
    }


}
