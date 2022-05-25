package HSMS.Owner;

public class Owner {
    private String firstName;
    private String lastName;
    private int age;
    private int cNIC;
    private String emailAddress;

    public Owner(String firstName, String lastName, int age, int cNIC, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cNIC = cNIC;
        this.emailAddress = emailAddress;
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

    public int getcNIC() {
        return cNIC;
    }

    public void setcNIC(int cNIC) {
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
}
