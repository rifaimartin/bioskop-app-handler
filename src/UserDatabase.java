import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDatabase {

    private Map<String, String[]> userMap;

    public UserDatabase(String filename) {
        userMap = new HashMap<>();

        try {
            File file = new File(filename);
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
        String storedPassword = passwordAndRole[0];

        return storedPassword.equals(password);
    }

    public String getUserRole(String username) {
        String[] passwordAndRole = userMap.get(username);
        String role = passwordAndRole[1];

        return role;
    }

}