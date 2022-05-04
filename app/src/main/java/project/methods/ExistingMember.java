package project.methods;
import project.defs.Database;

import java.sql.*;

public class ExistingMember {
    // This method is used to check the user id and password
    public boolean checkMember(int id, String password) {
        // This method is used to check the user id and password
        try {
            // This method is used to connect to the database
            Connection con = Database.getInstance().conn;
            // This method is used to create a statement
            Statement stmt = con.createStatement();
            // This method is used to execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM members WHERE id = " + id + " AND password = '" + password + "'");
            // This method is used to check if the user id and password are correct
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
