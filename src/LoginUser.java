import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUser extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private UserDatabase userDatabase;

    public LoginUser() {
        super("Login User");

        userDatabase = new UserDatabase("C:\\Users\\muhamad^rifai\\Documents\\UPH-CODE\\bioskop-app-handler\\src\\users.txt");

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        mainPanel.add(usernameLabel);

        usernameField = new JTextField();
        mainPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        mainPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        mainPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        mainPanel.add(loginButton);

        // add to frame
        add(mainPanel);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            if (userDatabase.isValidUser(username, new String(password))) {
                String role = userDatabase.getUserRole(username);
                JOptionPane.showMessageDialog(this, "Login berhasil!");
                dispose();
                new BioskopApp();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah.");
            }
        }
    }
}