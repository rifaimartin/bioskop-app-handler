package com.bioskop.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

                String[] passwordAndRole = { password};
                userMap.put(username, passwordAndRole);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public boolean isValidUser(String username, String password) throws NoSuchAlgorithmException {
        if (!userMap.containsKey(username)) {
            return false;
        }

        String[] passwordAndRole = userMap.get(username);

        String storedPassword = passwordAndRole[0];

        String hashPassword  = hashSHA256(password.toLowerCase(Locale.ROOT));

        System.out.println(hashPassword + "hash password");
        System.out.println(storedPassword + "stored passwrpd");

        return storedPassword.equals(hashPassword);
    }


    public static String hashSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());

        // Konversi hasil hash ke bentuk string heksadesimal
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}