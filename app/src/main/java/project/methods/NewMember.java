package project.methods;

import project.defs.*;
import java.sql.*;
import java.util.Calendar;

public class NewMember {
    public String addMember(int id, String name, int phone, String address, MPlans plan, PMethods paymentMethod, int amount, String gstno) {
        // get connection to database from Database class
        Connection conn = Database.getInstance().conn;
        // check if the member already exists
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM members WHERE id = " + id);
            if (rs.next()) {
                return "Member already exists";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // get the trainer with the least number of members
        Trainer trainer = null;
        int trainerCount = Integer.MAX_VALUE;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM trainer");
            while (rs.next()) {
                int count = 0;
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM members WHERE trainer_id = " + rs.getInt("id"));
                while (rs2.next()) {
                    count++;
                }
                if (count < trainerCount) {
                    int trainerId = rs.getInt("id");
                    String trainerName = rs.getString("name");
                    String trainerPhone = rs.getString("phone");
                    int trainerSalary = rs.getInt("salary");
                    trainer = new Trainer(trainerId, trainerName, trainerPhone, trainerSalary);
                    trainerCount = count;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get the nutritionist with the least number of members
        Nutritionist nutritionist = null;
        int nutritionistCount = Integer.MAX_VALUE;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nutritionist");
            while (rs.next()) {
                int count = 0;
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM members WHERE nutritionist_id = " + rs.getInt("id"));
                while (rs2.next()) {
                    count++;
                }
                if (count < nutritionistCount) {
                    int nutritionistId = rs.getInt("id");
                    String nutritionistName = rs.getString("name");
                    String nutritionistPhone = rs.getString("phone");
                    int nutritionistSalary = rs.getInt("salary");
                    nutritionist = new Nutritionist(nutritionistId, nutritionistName, nutritionistPhone, nutritionistSalary);
                    nutritionistCount = count;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create a new member
        Member m = new Member(id, name, phone, address, plan);
        // create a password for the member
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += (char)((int)(Math.random() * 26) + 97);
        }
        // create a payment object with a random payment id, payment method, amount, date, gstno
        int pid = (int)(Math.random() * 1000000);
        // get today's date in dd/mm/yyyy format
        Calendar cal = Calendar.getInstance();
        String today = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
        Payment p = new Payment(pid, paymentMethod, amount, today, gstno);
        // update the database with the new member
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO members (id, name, phone, address, plan, password, trainer_id, nutritionist_id, payment_id) VALUES (" + id + ", '" + name + "', '" + phone + "', '" + address + "', '" + plan.toString() + "', '" + password + "', " + trainer.getId() + ", " + nutritionist.getId() + ", " + p.getId() + ")";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // add the member to the trainer
        trainer = trainer.addMember(m);
        // add the member to the nutritionist
        nutritionist = nutritionist.addMember(m);
        // update the database with the new trainer
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE trainer SET members = '" + trainer.getMembers() + "' WHERE id = " + trainer.getId();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // update the database with the new nutritionist
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE nutritionist SET members = '" + nutritionist.getMembers() + "' WHERE id = " + nutritionist.getId();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return password;
    }
}
