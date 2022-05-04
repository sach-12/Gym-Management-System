package project.defs;

import java.sql.*;

public class Database {
    private static Database instance = null;
    public Connection conn;
    
    private Database() {
        try {
            Class.forName("org.postgresql.Driver");
            // postgres without password
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gym", "postgres", "post_123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
