package project.views;

import project.methods.*;
import project.defs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemberCreate {
    private JFrame frame;
    private JTextField idField;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JComboBox<String> planField;
    private JRadioButton cashButton;
    private JRadioButton cardButton;
    private JRadioButton upiButton;
    private JRadioButton netbankingButton;
    private ButtonGroup paymentGroup;
    private JButton createButton;
    private JButton cancelButton;

    public MemberCreate() {
        // create a frame
        frame = new JFrame("New Member Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // create a title label
        JLabel titleLabel = new JLabel("Member Create");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 20, 200, 30);
        frame.add(titleLabel);

        // create a id label
        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setBounds(60, 100, 50, 30);
        frame.add(idLabel);

        // create a id text field
        idField = new JTextField();
        idField.setFont(new Font("Arial", Font.PLAIN, 16));
        idField.setBounds(150, 100, 200, 30);
        frame.add(idField);

        // create a name label
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(60, 150, 100, 30);
        frame.add(nameLabel);

        // create a name text field
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBounds(150, 150, 200, 30);
        frame.add(nameField);

        // create a phone label
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setBounds(60, 200, 100, 30);
        frame.add(phoneLabel);

        // create a phone text field
        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneField.setBounds(150, 200, 200, 30);
        frame.add(phoneField);

        // create a address label
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        addressLabel.setBounds(60, 250, 100, 30);
        frame.add(addressLabel);

        // create a address text field
        addressField = new JTextField();
        addressField.setFont(new Font("Arial", Font.PLAIN, 16));
        addressField.setBounds(150, 250, 200, 30);
        frame.add(addressField);

        // create a plan label
        JLabel planLabel = new JLabel("Plan");
        planLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        planLabel.setBounds(60, 300, 100, 30);
        frame.add(planLabel);

        // create a plan text field
        planField = new JComboBox<String>();
        planField.setFont(new Font("Arial", Font.PLAIN, 16));
        planField.setBounds(150, 300, 200, 30);
        planField.addItem("ONEMONTH");
        planField.addItem("THREEMONTHS");
        planField.addItem("SIXMONTHS");
        planField.addItem("TWELVEMONTHS");
        frame.add(planField);

        // create a payment label
        JLabel paymentLabel = new JLabel("Payment Mode");
        paymentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        paymentLabel.setBounds(60, 350, 150, 30);
        frame.add(paymentLabel);

        // create a cash button
        cashButton = new JRadioButton("Cash");
        cashButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cashButton.setBounds(200, 350, 100, 30);
        frame.add(cashButton);

        // create a card button
        cardButton = new JRadioButton("Card");
        cardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cardButton.setBounds(200, 375, 100, 30);
        frame.add(cardButton);

        // create a upi button
        upiButton = new JRadioButton("UPI");
        upiButton.setFont(new Font("Arial", Font.PLAIN, 16));
        upiButton.setBounds(200, 400, 100, 30);
        frame.add(upiButton);

        // create a netbanking button
        netbankingButton = new JRadioButton("Netbanking");
        netbankingButton.setFont(new Font("Arial", Font.PLAIN, 16));
        netbankingButton.setBounds(200, 425, 150, 30);
        frame.add(netbankingButton);

        // create a payment group
        paymentGroup = new ButtonGroup();
        paymentGroup.add(cashButton);
        paymentGroup.add(cardButton);
        paymentGroup.add(upiButton);
        paymentGroup.add(netbankingButton);

        // create a create button
        createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setBounds(100, 475, 100, 30);
        frame.add(createButton);

        // create a cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cancelButton.setBounds(200, 475, 100, 30);
        frame.add(cancelButton);

        // create a listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // show memberlogin frame
                MemberLogin memberLogin = new MemberLogin();
                memberLogin.show();
            }
        });
        NewMember newMember = new NewMember();

        // create a listener for the create button
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int phone = Integer.parseInt(phoneField.getText());
                String address = addressField.getText();
                MPlans plan = MPlans.valueOf(planField.getSelectedItem().toString());
                PMethods paymentMethod = null;
                if (cashButton.isSelected()) {
                    paymentMethod = PMethods.CASH;
                } else if (cardButton.isSelected()) {
                    paymentMethod = PMethods.CARD;
                } else if (upiButton.isSelected()) {
                    paymentMethod = PMethods.UPI;
                } else if (netbankingButton.isSelected()) {
                    paymentMethod = PMethods.NETBANKING;
                }
                int amount = 10;
                String gstno = "GST001";
                String ret = newMember.addMember(id, name, phone, address, plan, paymentMethod, amount, gstno);
                String showPass = "Your password is " + ret;
                JOptionPane.showMessageDialog(frame, showPass);
                frame.dispose();
                // show memberlogin frame
                MemberLogin memberLogin = new MemberLogin();
                memberLogin.show();
            }
        });
    }

    public void show() {
        // show the frame
        frame.setVisible(true);
    }
}
