package com.bioskop.app.service;

import com.bioskop.database.UserDatabase;

import java.security.NoSuchAlgorithmException;

public class AuthService {

    private UserDatabase userDatabase;

    public AuthService() {
        userDatabase = new UserDatabase();
    }

    public boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
        return userDatabase.isValidUser(username, password);
    }
}