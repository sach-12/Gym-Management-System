package project.views;

import javax.swing.*;

import project.defs.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
public class Main {
    // this frame is used to display the main menu with options member login and staff login and staff logout
    private JFrame frame;
    private JButton memberLoginButton;
    private JButton staffLoginButton;
    private JButton staffLogoutButton;
    private JButton exitButton;
    private JLabel titleLabel;

    public Main() {
        // create a frame
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // create a title label
        titleLabel = new JLabel("Main Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 20, 200, 30);
        frame.add(titleLabel);

        // create a member login button
        memberLoginButton = new JButton("Member Login");
        memberLoginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        memberLoginButton.setBounds(100, 100, 200, 30);
        frame.add(memberLoginButton);

        // create a listener for the member login button
        memberLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a member login frame
                frame.dispose();
                MemberLogin memberLogin = new MemberLogin();
                memberLogin.show();
            }
        });

        // create a staff login button
        staffLoginButton = new JButton("Staff Login");
        staffLoginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        staffLoginButton.setBounds(100, 150, 200, 30);
        frame.add(staffLoginButton);

        // create a listener for the staff login button
        staffLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a staff login frame
                frame.dispose();
                StaffLogin staffLogin = new StaffLogin();
                staffLogin.show();
            }
        });

        // create a staff logout button
        staffLogoutButton = new JButton("Staff Logout");
        staffLogoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        staffLogoutButton.setBounds(100, 200, 200, 30);
        frame.add(staffLogoutButton);

        // create a listener for the staff logout button
        staffLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a staff logout frame
                frame.dispose();
                StaffLogout staffLogout = new StaffLogout();
                staffLogout.show();
            }
        });

        // create an exit button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exitButton.setBounds(100, 300, 200, 30);
        frame.add(exitButton);

        // create a listener for the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exit the program after closing db connection
                Connection connection = Database.getInstance().conn;
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}
