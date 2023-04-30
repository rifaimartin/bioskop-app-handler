package com.bioskop.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDatabase {

    private Map<String, String[]> userMap;


    public UserDatabase() {
        userMap = new HashMap<>();
        String filename = "users.txt - set with u specifik local directory";

        try {
            File file = new File("C:\\Users\\muhamad^rifai\\Documents\\UPH-CODE\\bioskop-app-handler\\resources\\users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(",");
                String username = tokens[0];
                String password = tokens[1];
                String role = tokens[2];

                String[] passwordAndRole = { password, role };
                userMap.put(username, passwordAndRole);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public boolean isValidUser(String username, String password) {
        if (!userMap.containsKey(username)) {
            return false;
        }

        String[] passwordAndRole = userMap.get(username);

        // hashing
        String hashPassword = password -> hashinh md5/sha256 ;

        String storedPassword = passwordAndRole[0];

        return storedPassword.equals(hashPassword);
    }

    public String getUserRole(String username) {
        String[] passwordAndRole = userMap.get(username);
        String role = passwordAndRole[1];

        return role;
    }

}