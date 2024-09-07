package LoginPackage;
import SignupPackage.SignupFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import DetailsPackage.*;



public class LoginFrame extends JFrame
{
	
	
  JFrame frame;
  JLabel label1;
  JLabel label2;
  JLabel label3;
  JTextField textField1;
  JTextField textField2;
  JButton button1;
  JButton button2;
  JButton button3;
	
     public LoginFrame()
  {
      frame=new JFrame();	 
	  this.setTitle("Login Form");
	  this.setSize(500, 400);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLayout(null);
	  this.setVisible(true);
	  this.setLocationRelativeTo(null);
	  
	  label1=new JLabel("User Name:",JLabel.LEFT);
	  label1.setBounds(80, 50, 100, 20);
	  
	  label2=new JLabel("Password:",JLabel.LEFT);
	  label2.setBounds(80, 100, 100, 20);
	  
	  textField1=new JTextField();
	  textField1.setBounds(200, 50, 200, 20);
	  
	  textField2=new JTextField();
	  textField2.setBounds(200, 100, 200, 20);
	  
	  button1=new JButton("Reset");
	  button1.setBounds(200, 150, 80, 30);
	  button1.setFocusable(false);
	  button1.setBackground(Color.BLUE);
	  button1.setForeground(Color.WHITE);;
	  
	  button2=new JButton("Login");
	  button2.setBounds(320, 150, 80, 30);
	  button2.setFocusable(false);
	  button2.setBackground(Color.BLUE);
	  button2.setForeground(Color.WHITE);;
	  
	  button3=new JButton("Sign Up Here");
	  button3.setBounds(300, 300, 120, 30);
	  button3.setForeground(Color.BLUE);
	  button3.setFocusable(false);
	  
	  label3=new JLabel("Don't have account?");
	  label3.setBounds(150, 300, 150, 20);
	  label3.setForeground(Color.RED);
	  
	  this.add(label1);
	  this.add(label2);
	  this.add(label3);
	  this.add(textField1);
	  this.add(textField2);
	  this.add(button1);
	  this.add(button2);
	  this.add(button3);
	  
	  String url="jdbc:mysql://localhost:3306/cwdatabase1";
	  String username="root";
	  String password="";
	 
	  
	  
	  button3.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent ae) {
			  dispose();
			  SignupPackage.SignupFrame s1=new SignupPackage.SignupFrame();
			  s1.setVisible(true);
			  
		  }
	  });
	  
	  button1.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent ae)
		  {
			textField1.setText("");
			textField2.setText("");
		
		  }
	  });
	  button2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		    	 
		        try {
		            String name2 = textField1.getText();
		            String password2 = textField2.getText();

		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, username, password);
		            String selectQuery = "SELECT * FROM userdetails WHERE name=? AND pword=?";
		            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		            preparedStatement.setString(1, name2);
		            preparedStatement.setString(2, password2);
		            ResultSet resultSet = preparedStatement.executeQuery();

		            if (resultSet.next()) {
		            	JOptionPane.showMessageDialog(frame, "Login Successfully!");
		                dispose(); 
		                DetailsFrame d1 = new DetailsFrame();
		                d1.setVisible(true);
		                
		            } else {

		               JOptionPane.showMessageDialog(frame, "Invalid username or password");
		               LoginPackage.LoginFrame l1=new LoginPackage.LoginFrame();
		     			l1.setVisible(true);
		            }

		            connection.close();
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		});
		  }

	  }
    
	  


