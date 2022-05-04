package project.methods;

import project.defs.Database;
import java.sql.*;

public class StaffOut {
    // This method is used to check the user id and password under trainer, nutritionist, receptionist and admin tables
    public boolean checkStaff(int id, String password) {
        // This method is used to check the user id and password
        try {
            // This method is used to connect to the database
            Connection con = Database.getInstance().conn;
            // This method is used to create a statement
            Statement stmt = con.createStatement();
            // This method is used to execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM trainer WHERE id = '" + id + "' AND password = '" + password + "'");
            // This method is used to check if the user id and password are correct
            if (rs.next()) {
                // update db to show that the user has logged in
                try {
                    Statement stmt2 = con.createStatement();
                    stmt2.executeUpdate("UPDATE trainer SET logged_in = 0 WHERE id = '" + id + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
            else {
                rs = stmt.executeQuery("SELECT * FROM nutritionist WHERE id = '" + id + "' AND password = '" + password + "'");
                if (rs.next()) {
                    // update db to show that the user has logged in
                    try {
                        Statement stmt2 = con.createStatement();
                        stmt2.executeUpdate("UPDATE nutritionist SET logged_in = 0 WHERE id = '" + id + "'");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                else {
                    rs = stmt.executeQuery("SELECT * FROM receptionist WHERE id = '" + id + "' AND password = '" + password + "'");
                    if (rs.next()) {
                        // update db to show that the user has logged in
                        try {
                            Statement stmt2 = con.createStatement();
                            stmt2.executeUpdate("UPDATE receptionist SET logged_in = 0 WHERE id = '" + id + "'");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    } else {
                        rs = stmt.executeQuery("SELECT * FROM admin WHERE id = '" + id + "' AND password = '" + password + "'");
                        if (rs.next()) {
                            // update db to show that the user has logged in
                            try {
                                Statement stmt2 = con.createStatement();
                                stmt2.executeUpdate("UPDATE admin SET logged_in = 0 WHERE id = '" + id + "'");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
