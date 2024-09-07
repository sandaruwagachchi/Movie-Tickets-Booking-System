 package DetailsPackage;

import PaymentPackage.PaymentFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingReceipt extends JFrame {
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JButton button1;
    JButton button2;

    public BookingReceipt(String movie, String theatre, String date, String time, String type, int tickets) {
        this.setTitle("Booking Receipt");
        this.setSize(500, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        double ticketPrice;
        double totalCost;

        if (type.equals("ODC")) {
            ticketPrice = 250.00;
        } else {
            ticketPrice = 500.00;
        }

        totalCost = tickets * ticketPrice;

        label = new JLabel("Booking Details", JLabel.CENTER);
        label.setFont(new Font("Roman", Font.BOLD, 20));
        label.setForeground(Color.red);
        label.setBounds(50, 50, 400, 30);

        label1 = new JLabel("Movie Name: " + movie, JLabel.CENTER);
        label1.setBounds(50, 100, 400, 20);

        label2 = new JLabel("Theatre Location: " + theatre, JLabel.CENTER);
        label2.setBounds(50, 150, 400, 20);

        label3 = new JLabel("Showing Date: " + date, JLabel.CENTER);
        label3.setBounds(50, 200, 400, 20);

        label4 = new JLabel("Start Date: " + time, JLabel.CENTER);
        label4.setBounds(50, 250, 400, 20);

        label5 = new JLabel("Ticket Type: " + type, JLabel.CENTER);
        label5.setBounds(50, 300, 400, 20);

        label6 = new JLabel("No of Tickets: " + tickets, JLabel.CENTER);
        label6.setBounds(50, 350, 400, 20);

        label7 = new JLabel(String.format("Total Cost: Rs.%.2f", totalCost), JLabel.CENTER);
        label7.setBounds(50, 400, 400, 20);

        button1 = new JButton("Cancel");
        button1.setBounds(100, 500, 80, 30);
        button1.setFocusable(false);
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        this.add(button1);

        button2 = new JButton("Book");
        button2.setBounds(300, 500, 80, 30);
        button2.setFocusable(false);
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.WHITE);
        this.add(button2);

        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    dispose();
                    DetailsFrame d2 = new DetailsFrame();
                    d2.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                int value;

                try {
                    value = JOptionPane.showConfirmDialog(null, "Are You Sure?");
                    if (value == JOptionPane.YES_OPTION) {
                        dispose();
                        PaymentFrame p1 = new PaymentFrame(movie, theatre, date, time, type, tickets, totalCost);
                        p1.setVisible(true);
                    } else if (value == JOptionPane.NO_OPTION) {
                        DetailsFrame d1 = new DetailsFrame();
                        d1.setVisible(true);
                    } else if (value == JOptionPane.CANCEL_OPTION) {
                        dispose();
                        DetailsFrame d1 = new DetailsFrame();
                        d1.setVisible(true);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
