package HSMS.DBHandlers;

import HSMS.ApplicationTypes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ApplicationDBhandler {

    public void saveRegApplication(RegistrationApplication application){
        String sql = "insert into Registration_Applications (AFirstName, ALastName, Acnic, AEmailAddress, ID, houseNo, Size, OFName, OLName, Oage, oCNIC) VALUES(?, ?, ?, ?,?, ?, ?, ?,?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,application.getApplicant().getFirstName());
            st.setString(2, application.getApplicant().getLastName());
            st.setString(3, String.valueOf(application.getApplicant().getCnic()));
            st.setString(4, application.getApplicant().getEmailAddress());
            st.setString(5, String.valueOf(application.getID()));
            st.setString(6, application.getHouseNo());
            st.setString(7, application.getSize());
            st.setString(8, application.getOFName());
            st.setString(9, application.getOLName());
            st.setString(10, String.valueOf(application.getoAge()));
            st.setString(11, String.valueOf(application.getoCnic()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveRentingApplication(RentingApplication application){
        String sql = "insert into Renting_Applications (AFirstName, ALastName, Acnic, AEmailAddress, ID,OFName, OLName, oCNIC, RFName,RLName, RCNIC, RENT, INCREMENT) VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, application.getApplicant().getFirstName());
            st.setString(2, application.getApplicant().getLastName());
            st.setString(3, String.valueOf(application.getApplicant().getCnic()));
            st.setString(4, application.getApplicant().getEmailAddress());
            st.setString(5, String.valueOf(application.getID()));
            st.setString(6, application.getOFName());
            st.setString(7, application.getOLName());
            st.setString(8, String.valueOf(application.getoCnic()));
            st.setString(9, application.getRFName());
            st.setString(10, application.getRLName());
            st.setString(11, String.valueOf(application.getRCnic()));
            st.setString(12, String.valueOf(application.getRent()));
            st.setString(13, String.valueOf(application.getIncrement()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveOTApplication(OwnerTransferApplication application){
        String sql = "insert into OT_Applications (AFirstName, ALastName, Acnic, AEmailAddress, ID,OFName, OLName, oCNIC, RFName,RLName, RCNIC) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, application.getApplicant().getFirstName());
            st.setString(2, application.getApplicant().getLastName());
            st.setString(3, String.valueOf(application.getApplicant().getCnic()));
            st.setString(4, application.getApplicant().getEmailAddress());
            st.setString(5, String.valueOf(application.getID()));
            st.setString(6, application.getOFName());
            st.setString(7, application.getOLName());
            st.setString(8, String.valueOf(application.getoCnic()));
            st.setString(9, application.getRFName());
            st.setString(10, application.getRLName());
            st.setString(11, String.valueOf(application.getRCnic()));
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void saveEtagApplication(EtagApplication application){
        String sql = "insert into Etag_Applications (AFirstName, ALastName, Acnic, AEmailAddress, ID,OFName, OLName, oCNIC, VehicleNo, VechicleType, VehicleMake, VehicleYear, EnginerSize, Others) VALUES(?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?,?,?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1, application.getApplicant().getFirstName());
            st.setString(2, application.getApplicant().getLastName());
            st.setString(3, String.valueOf(application.getApplicant().getCnic()));
            st.setString(4, application.getApplicant().getEmailAddress());
            st.setString(5, String.valueOf(application.getID()));
            st.setString(6, application.getOFName());
            st.setString(7, application.getOLName());
            st.setString(8, String.valueOf(application.getoCnic()));
            st.setString(9, application.getvNo());
            st.setString(10, application.getvType());
            st.setString(11, application.getvMake());
            st.setString(12, application.getvYear());
            st.setString(13, String.valueOf(application.getvEngineSize()));
            st.setString(14, application.isOthers());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}
