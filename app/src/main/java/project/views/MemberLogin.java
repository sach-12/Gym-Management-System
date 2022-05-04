package project.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import project.methods.*;

public class MemberLogin {
    // create a login frame
    private JFrame frame;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private JButton createButton;
    private JLabel errorLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;

    public MemberLogin() {
        // create a frame
        frame = new JFrame("Member Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // create a title label
        titleLabel = new JLabel("Member Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 20, 200, 30);
        frame.add(titleLabel);

        // create a id label
        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setBounds(70, 100, 50, 30);
        frame.add(idLabel);

        // create a id text field
        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 16));
        idField.setBounds(150, 100, 200, 30);
        frame.add(idField);

        // create a password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setBounds(70, 150, 100, 30);
        frame.add(passwordLabel);

        // create a password text field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBounds(150, 150, 200, 30);
        frame.add(passwordField);

        // create a login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginButton.setBounds(100, 200, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String password = new String(passwordField.getPassword());
                ExistingMember existingMember = new ExistingMember();
                if (existingMember.checkMember(id, password)) {
                    frame.dispose();
                    // check if trainer is online
                    CheckOnlineTrainers checkOnlineTrainers = new CheckOnlineTrainers();
                    if (checkOnlineTrainers.checkOnline(id)) {
                        // if online, tell the user that the trainer is online and he can meet him
                        JOptionPane.showMessageDialog(null, "The trainer is available. You can meet him now.", "Available Trainer", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // if offline, tell the user that the trainer is offline and follow the plan for today
                        JOptionPane.showMessageDialog(null, "The trainer is not available. Follow the plan for today.", "Unavailable Trainer", JOptionPane.INFORMATION_MESSAGE);
                    }
                    Main main = new Main();
                    main.show();
                } else {
                    errorLabel.setText("Invalid ID or Password");
                }
            }
        });
        frame.add(loginButton);

        // create a cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelButton.setBounds(200, 200, 100, 30);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Main main = new Main();
                main.show();
            }
        });
        frame.add(cancelButton);

        // create a create button
        createButton = new JButton("New Member");
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setBounds(125, 250, 150, 30);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a membercreate frame
                MemberCreate memberCreate = new MemberCreate();
                memberCreate.show();
                frame.dispose();
            }
        });
        frame.add(createButton);

        // create a error label
        errorLabel = new JLabel("");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        errorLabel.setBounds(100, 300, 300, 30);
        frame.add(errorLabel);
    }

    public void show() {
        frame.setVisible(true);
    }
}
