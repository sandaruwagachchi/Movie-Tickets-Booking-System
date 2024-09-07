package PaymentPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ReciptPackage.ReciptFrame;

public class PaymentFrame extends JFrame {
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JPanel panel1;
    JPanel panel2;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JButton button1;
    JButton button2;

    private String movie;
    private String theatre;
    private String date;
    private String time;
    private String type;
    private int tickets;
    private double totalCost;

    public PaymentFrame() {
    }

    public PaymentFrame(String movie, String theatre, String date, String time, String type, int tickets, double totalCost) {
        this.movie = movie;
        this.theatre = theatre;
        this.date = date;
        this.time = time;
        this.type = type;
        this.tickets = tickets;
        this.totalCost = totalCost;

        this.setTitle("Payment Frame");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Card Information", JLabel.CENTER);
        label1.setFont(new Font("Roman", Font.BOLD, 30));
        label1.setForeground(Color.RED);
        label1.setBounds(50, 200, 400, 30);

        label2 = new JLabel("Card Type:", JLabel.CENTER);
        label2.setBounds(40, 250, 100, 30);

        panel1 = new JPanel();
        panel1.setBounds(270, 250, 200, 30);

        radioButton1 = new JRadioButton("VISA");
        radioButton2 = new JRadioButton("MASTERCARD");

        ButtonGroup b1 = new ButtonGroup();
        b1.add(radioButton1);
        b1.add(radioButton2);

        label3 = new JLabel("Card Number:", JLabel.CENTER);
        label3.setBounds(50, 300, 100, 30);

        textField1 = new JTextField();
        textField1.setBounds(300, 300, 150, 20);

        label4 = new JLabel("Card Holder Name:", JLabel.CENTER);
        label4.setBounds(50, 350, 120, 30);

        textField2 = new JTextField();
        textField2.setBounds(300, 350, 150, 20);

        label5 = new JLabel("CVV:", JLabel.CENTER);
        label5.setBounds(50, 400, 100, 30);

        textField3 = new JTextField();
        textField3.setBounds(300, 400, 50, 20);
        
        label7 = new JLabel("Cost:", JLabel.CENTER);
        label7.setBounds(50, 450, 100, 30);
        
        textField4 = new JTextField(String.format("Rs.%.2f", totalCost));
        textField4.setBounds(300, 450, 100, 20);
        textField4.setEditable(false);

        button1 = new JButton("Confirm");
        button1.setBounds(320, 500, 80, 30);
        button1.setFocusable(false);
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);

        button2 = new JButton("Cancel");
        button2.setBounds(50, 500, 80, 30);
        button2.setFocusable(false);
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.WHITE);

        panel2 = new JPanel();
        panel2.setBounds(140, 0, 220, 200);

        label6 = new JLabel();
        label6.setIcon(new ImageIcon("C:\\Users\\Lap.lk\\Pictures\\download.png"));
        panel2.add(label6);
        this.add(panel2);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label7);
        this.add(textField4);
        panel1.add(radioButton1);
        panel1.add(radioButton2);
        this.add(panel1);
        this.add(textField1);
        this.add(textField2);
        this.add(textField3);
        this.add(button1);
        this.add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (validateCardInfo()) {
                        JOptionPane.showMessageDialog(PaymentFrame.this, "Success!!");
                        dispose();
                        new ReciptFrame(movie, theatre, date, time, type, tickets, totalCost, textField2.getText(), textField1.getText()).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(PaymentFrame.this, "Invalid card information.!!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    private boolean validateCardInfo() {
        String cardNumber = textField1.getText();
        String cardHolderName = textField2.getText();
        String cvv = textField3.getText();

        if (cardNumber.length() != 16) {
        	  JOptionPane.showMessageDialog(PaymentFrame.this, "Invalid card Number.!!");
            return false;
        }
        if (cardHolderName.isEmpty()) {
        	  JOptionPane.showMessageDialog(PaymentFrame.this, "Enter card holder name.!!");
            return false;
        }
        if (cvv.length() != 3) {
        	  JOptionPane.showMessageDialog(PaymentFrame.this, "Invalid cvv.!!");
            return false;
        }
        return true;
    }
}
