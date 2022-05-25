package HSMS.DBHandlers;

import HSMS.Complaint.Complaint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ComplaintsDBHandler {

    public void saveComplaint(Complaint complaint){
        String sql = "insert into Complaints (ID, HouseNO, EmailAddress, Problem) VALUES(?, ?, ?, ?)";
        try {
            String url = "jdbc:jtds:sqlserver://ZULA:1433/newHSMS;instance=SQLEXPRESS";
            //String url ="jdbc:sqlserver://ZULA:1433;databaseName=HSMS;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(url,"User","qwerty");
            PreparedStatement st = conn.prepareStatement(sql);
            //st.executeUpdate("INSERT INTO Applicant " + "VALUES (fname, lname, cnic, email)");
            st.setString(1,String.valueOf(complaint.getID()));
            st.setString(2, complaint.getHouseNo());
            st.setString(3, complaint.getEmailAddress());
            st.setString(4, complaint.getProblem());
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
