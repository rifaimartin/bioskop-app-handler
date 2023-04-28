package com.bioskop.app.controllers;

import com.bioskop.app.service.AuthService;
import com.bioskop.app.ui.LoginUser;
import com.bioskop.app.ui.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginUser loginUI;
    private AuthService authService;

    public LoginController(LoginUser loginUI) {
        this.loginUI = loginUI;
        authService = new AuthService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = loginUI.getUsername();
        char[] password = loginUI.getPassword();

        if (authService.authenticate(username, new String(password))){
            JOptionPane.showMessageDialog(loginUI, "Login berhasil!");
            loginUI.dispose();
            boolean[] kursiStatus = new boolean[30];
            new MainMenu(kursiStatus).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginUI, "Username atau password salah.");
        }
    }
}