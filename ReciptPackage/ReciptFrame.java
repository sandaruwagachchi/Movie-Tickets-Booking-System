package ReciptPackage;

import javax.swing.*;

import PaymentPackage.PaymentFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ReciptFrame extends JFrame {

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JButton button;

    public ReciptFrame(String movie, String theatre, String date, String time, String type, int tickets, double totalCost, String cardHolderName, String cardNumber) {
        this.setTitle("Receipt");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Booking Receipt", JLabel.CENTER);
        label1.setFont(new Font("Roman", Font.BOLD, 30));
        label1.setForeground(Color.BLACK);
        label1.setBounds(50, 50, 400, 40);

        label2 = new JLabel("Bank of Ceylon", JLabel.CENTER);
        label2.setFont(new Font("Roman", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(50, 100, 400, 30);

        label3 = new JLabel("Card Holder Name: " + cardHolderName, JLabel.CENTER);
        label3.setForeground(Color.BLACK);
        label3.setBounds(50, 150, 400, 30);

        label4 = new JLabel("Card Number: " + cardNumber, JLabel.CENTER);
        label4.setForeground(Color.BLACK);
        label4.setBounds(50, 200, 400, 30);

        label5 = new JLabel("Theatre: " + theatre, JLabel.CENTER);
        label5.setForeground(Color.BLACK);
        label5.setBounds(50, 250, 400, 30);

        label6 = new JLabel("Movie: " + movie, JLabel.CENTER);
        label6.setForeground(Color.BLACK);
        label6.setBounds(50, 300, 400, 30);

        label7 = new JLabel("Date: " + date, JLabel.CENTER);
        label7.setForeground(Color.BLACK);
        label7.setBounds(50, 350, 400, 30);

        label8 = new JLabel("Tickets: " + tickets, JLabel.CENTER);
        label8.setForeground(Color.BLACK);
        label8.setBounds(50, 400, 400, 30);

        label9 = new JLabel(String.format("Total Price: Rs.%.2f", totalCost), JLabel.CENTER);
        label9.setForeground(Color.BLACK);
        label9.setBounds(50, 450, 400, 30);
        
        button = new JButton("OK");
        button.setBounds(350, 500, 80, 30);
        button.setFocusable(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);


        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(button);
        
        
  	  String url="jdbc:mysql://localhost:3306/cwdatabase1";
  	  String username="root";
  	  String password="";
  	 
        
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		try {
        			
        			 JOptionPane.showMessageDialog(ReciptFrame.this, "Thanks for Booking!");
        			 dispose();
        			 Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection connection = DriverManager.getConnection(url, username, password);
                     Statement statement = connection.createStatement();
                     String insertQuery = "INSERT INTO bookingdetails (name, theatre, movie, date, tickets, price) VALUES (?,?,?,?,?,?)";
                     PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                     insertStatement.setString(1, cardHolderName);
                     insertStatement.setString(2, theatre);
                     insertStatement.setString(3, movie);
                     insertStatement.setString(4, date);
                     insertStatement.setInt(5, tickets);
                     insertStatement.setDouble(6, totalCost);
                     
                     insertStatement.executeUpdate();
                     connection.close();
        		}
        		catch(Exception e)
        		{
        			System.out.println(e);
        		}
        	}
        });
    }
}
