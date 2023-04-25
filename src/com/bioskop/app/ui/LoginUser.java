package com.bioskop.app.ui;

import com.bioskop.app.controllers.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginUser extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUser() {
        super("Login User");

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        mainPanel.add(usernameLabel);

        usernameField = new JTextField();
        mainPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        mainPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginController(this));
        mainPanel.add(loginButton);

        // add to frame
        add(mainPanel);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}