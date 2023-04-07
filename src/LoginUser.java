import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUser extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUser() {
        super("Login User");

        
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
        // setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // hardcode wkwkw
            if (username.equals("user") && new String(password).equals("password")) {
                JOptionPane.showMessageDialog(this, "Login berhasil!");
                dispose();
                new BioskopApp();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah.");
            }
        }
    }
}