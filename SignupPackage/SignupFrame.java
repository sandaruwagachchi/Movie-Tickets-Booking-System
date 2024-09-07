package SignupPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import LoginPackage.LoginFrame;

public class SignupFrame extends JFrame {
    JFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    
    JButton button1;
    JButton button2;
    
    public SignupFrame() {
        frame = new JFrame();
        this.setTitle("SignUp Form");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        label1 = new JLabel("User Name:", JLabel.LEFT);
        label1.setBounds(80, 50, 130, 20);
        
        label2 = new JLabel("Email:", JLabel.LEFT);
        label2.setBounds(80, 100, 130, 20);
        
        label3 = new JLabel("Phone Number:", JLabel.LEFT);
        label3.setBounds(80, 150, 130, 20);
        
        label4 = new JLabel("Create Password:", JLabel.LEFT);
        label4.setBounds(80, 200, 130, 20);
        
        label5 = new JLabel("Confirm Password:", JLabel.LEFT);
        label5.setBounds(80, 250, 130, 20);
        
        textField1 = new JTextField();
        textField1.setBounds(230, 50, 200, 20);
        
        textField2 = new JTextField();
        textField2.setBounds(230, 100, 200, 20);
        
        textField3 = new JTextField();
        textField3.setBounds(230, 150, 200, 20);
        
        textField4 = new JTextField();
        textField4.setBounds(230, 200, 200, 20);
        
        textField5 = new JTextField();
        textField5.setBounds(230, 250, 200, 20);
        
        button1 = new JButton("Sign Up");
        button1.setBounds(350, 300, 80, 30);
        button1.setFocusable(false);
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        
        button2 = new JButton("Reset");
        button2.setBounds(230, 300, 80, 30);
        button2.setFocusable(false);
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.WHITE);
        
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        
        this.add(textField1);
        this.add(textField2);
        this.add(textField3);
        this.add(textField4);
        this.add(textField5);
        
        this.add(button1);
        this.add(button2);
        
        String url = "jdbc:mysql://localhost:3306/cwdatabase1";
        String username = "root";
        String password = "";
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String name2 = textField1.getText();
                    String email2 = textField2.getText();
                    String phonenumber2 = textField3.getText();
                    String password2 = textField4.getText();
                    String confirmPassword2 = textField5.getText();
                    
                    if (!validateFields(name2, email2, phonenumber2, password2, confirmPassword2)) {
                        return;
                    }
                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    String insertQuery = "INSERT INTO userdetails (name, email, phonenumber, pword) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                    insertStatement.setString(1, name2);
                    insertStatement.setString(2, email2);
                    insertStatement.setString(3, phonenumber2);
                    insertStatement.setString(4, password2);
                    
                    insertStatement.executeUpdate();
                    connection.close();
                    
                    JOptionPane.showMessageDialog(frame, "Hello " + name2 + "! Welcome to our movie tickets booking system");
                    
                    dispose();
                    LoginFrame f1 = new LoginFrame();
                    f1.setVisible(true);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });
    }
    
    private boolean validateFields(String name, String email, String phoneNumber, String password, String confirmPassword) {
        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!validateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!phoneNumber.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
