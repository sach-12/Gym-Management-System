package project.methods;

import project.defs.Database;
import java.sql.*;

public class CheckOnlineTrainers {
    // this method is used to check if the member's trainer is online
    public boolean checkOnline(int id) {
        try {
            // this method is used to connect to the database
            Connection con = Database.getInstance().conn;
            // this method is used to create a statement
            Statement stmt = con.createStatement();
            // this method is used to execute the query and find the trainer's id based on member id
            ResultSet rs = stmt.executeQuery("SELECT trainer_id FROM members WHERE id = " + id);
            // this method is used to check if the trainer is online
            if (rs.next()) {
                int trainer_id = rs.getInt("trainer_id");
                rs = stmt.executeQuery("SELECT logged_in FROM trainer WHERE id = " + trainer_id);
                if (rs.next()) {
                    int logged_in = rs.getInt("logged_in");
                    if (logged_in == 1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
