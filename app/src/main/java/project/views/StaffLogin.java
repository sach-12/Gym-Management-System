package project.views;

import project.methods.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffLogin {
    // this frame is used to display staff login menu with id and password fields
    private JFrame frame;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel errorLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;

    public StaffLogin() {
        // create a frame
        frame = new JFrame("Staff Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // create a title label
        titleLabel = new JLabel("Staff Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(150, 20, 200, 30);
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
                // check if the id and password are correct
                int id = Integer.parseInt(idField.getText());
                String password = new String(passwordField.getPassword());
                StaffIn staffIn = new StaffIn();
                if (staffIn.checkStaff(id, password)) {
                    // if correct, tell the user and close the frame
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    Main main = new Main();
                    main.show();
                } else {
                    // if incorrect, display error message
                    errorLabel.setText("Incorrect ID or Password");
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
                // open main menu and close this frame
                new Main().show();
                frame.dispose();
            }
        });
        frame.add(cancelButton);

        // create an error label
        errorLabel = new JLabel();
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        errorLabel.setBounds(100, 250, 200, 30);
        frame.add(errorLabel);
    }

    public void show() {
        frame.setVisible(true);
    }
}
