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

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        mainPanel.add(usernameLabel);

        usernameField = new JTextField();
        mainPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 18)); // ganti font dan ukurannya di sini
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        mainPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));


        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0x87CEEB));
        loginButton.addActionListener(new LoginController(this));
        buttonPanel.add(loginButton);

        loginButton = new JButton("Daftar");
        loginButton.setBackground(new Color(0x90EE90));
        loginButton.addActionListener(new LoginController(this));
        buttonPanel.add(loginButton);

        // Menambahkan buttonPanel ke dalam mainPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 6;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(buttonPanel, gbc);

        // add to frame
        add(mainPanel);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

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