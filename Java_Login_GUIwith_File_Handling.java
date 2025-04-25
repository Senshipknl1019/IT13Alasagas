
package saguing_javalogingui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class Java_Login_GUIwith_File_Handling extends JFrame {

    public Java_Login_GUIwith_File_Handling() {
        JTextField jTextFieldUsername = new JTextField();
        JPasswordField jPasswordPassword = new JPasswordField();
        JLabel jLabelUsername = new JLabel("Username:");
        JLabel jLabelPassword = new JLabel("Password:");
        JButton jButtonLogIn = new JButton("Log In");
        JButton jButtonCancel = new JButton("Cancel");

        jLabelUsername.setForeground(Color.green);
        setLayout(new GridLayout(3, 2));

        getContentPane().add(jLabelUsername);
        getContentPane().add(jTextFieldUsername);
        getContentPane().add(jLabelPassword);
        getContentPane().add(jPasswordPassword);
        getContentPane().add(jButtonLogIn);
        getContentPane().add(jButtonCancel);

        // Diri ang log in logic 
        jButtonLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = jTextFieldUsername.getText();
                String password = new String(jPasswordPassword.getPassword());

                boolean found = false;

                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\paul\\"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            String fileUsername = parts[0].trim();
                            String filePassword = parts[1].trim();

                            if (username.equals(fileUsername) && password.equals(filePassword)) {
                                found = true;
                                break;
                            }
                        }
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error reading file.");
                    return;
                }

               if (found) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                }
            }
        });

        jButtonCancel.addActionListener(e -> System.exit(0));

        setTitle("Login Form");
        setBounds(600, 300, 400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Java_Login_GUIwith_File_Handling();
    }
    }

