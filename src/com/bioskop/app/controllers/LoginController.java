package com.bioskop.app.controllers;

import com.bioskop.app.BioskopApp;
import com.bioskop.app.ui.LoginUser;
import com.bioskop.database.UserDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginUser loginUI;
    private UserDatabase userDatabase;

    public LoginController(LoginUser loginUI) {
        this.loginUI = loginUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userDatabase = new UserDatabase();
        String username = loginUI.getUsername();
        char[] password = loginUI.getPassword();

        if (userDatabase.isValidUser(username, new String(password))) {
            String role = userDatabase.getUserRole(username);
            JOptionPane.showMessageDialog(loginUI, "Login berhasil!");
            loginUI.dispose();
            new BioskopApp().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginUI, "Username atau password salah.");
        }
    }
}