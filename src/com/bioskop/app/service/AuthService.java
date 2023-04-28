package com.bioskop.app.service;

import com.bioskop.database.UserDatabase;

public class AuthService {

    private UserDatabase userDatabase;

    public AuthService() {
        userDatabase = new UserDatabase();
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.isValidUser(username, password);
    }
}