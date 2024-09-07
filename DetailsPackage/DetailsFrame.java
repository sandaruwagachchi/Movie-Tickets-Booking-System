package DetailsPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class DetailsFrame extends JFrame
{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    
    JTextField textField;
    
    JButton button1;
    JButton button2;
    
    JRadioButton radioButton1;
    JRadioButton radioButton2;

    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;
    JComboBox<String> comboBox3;
    JComboBox<String> comboBox4;

    public DetailsFrame() {
        this.setTitle("Movie Details Form");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Select Movie:", JLabel.LEFT);
        label1.setBounds(80, 50, 130, 20);

        label2 = new JLabel("Select Theatre:", JLabel.LEFT);
        label2.setBounds(80, 100, 130, 20);

        label3 = new JLabel("Select Date:", JLabel.LEFT);
        label3.setBounds(80, 150, 130, 20);

        label4 = new JLabel("Select Time:", JLabel.LEFT);
        label4.setBounds(80, 200, 130, 20);

        label5 = new JLabel("Ticket Type:", JLabel.LEFT);
        label5.setBounds(80, 250, 130, 20);

        label6 = new JLabel("No of Tickets", JLabel.LEFT);
        label6.setBounds(80, 300, 130, 20);
        
        label7=new JLabel("(ODC Price=Rs:250.00          BOX Price=Rs:500.00)");
        label7.setBounds(80, 275, 300, 20);
        label7.setForeground(Color.green);

        panel1 = new JPanel();
        panel1.setBounds(210, 50, 200, 30);
        String[] movies = {"Sinhabahu", "Siruwen", "Visal Adare", "Mandara", "Peradies"};
        comboBox1 = new JComboBox<>(movies);

        panel1.add(comboBox1);
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(250, 100, 200, 30);
        String[] theatre = {"Liberty By Scope Cinemas", "PVR Cinemas", "Majestic Cineplex", "Savoy 3D Cinema", "Regal Cinemas"};
        comboBox2 = new JComboBox<>(theatre);

        panel2.add(comboBox2);
        this.add(panel2);

        panel3 = new JPanel();
        panel3.setBounds(210, 150, 200, 30);
        String[] date = {"09-08-2024", "10-08-2024", "11-08-2024", "12-08-2024", "13-08-2024"};
        comboBox3 = new JComboBox<>(date);

        panel3.add(comboBox3);
        this.add(panel3);

        panel4 = new JPanel();
        panel4.setBounds(200, 200, 200, 30);
        String[] time = {"10.30am", "2.30pm", "6.30pm", "10.30pm"};
        comboBox4 = new JComboBox<>(time);

        panel4.add(comboBox4);
        this.add(panel4);

        textField = new JTextField();
        textField.setBounds(265, 300, 50, 20);

        button1 = new JButton("Submit");
        button1.setBounds(300, 400, 80, 30);
        button1.setFocusable(false);
        button1.setBackground(Color.BLUE);
  	    button1.setForeground(Color.WHITE);;

        button2 = new JButton("Cancel");
        button2.setBounds(80, 400, 80, 30);
        button2.setFocusable(false);
        button2.setBackground(Color.BLUE);
  	    button2.setForeground(Color.WHITE);;


        panel5 = new JPanel();
        panel5.setBounds(210, 250, 200, 30);

        radioButton1 = new JRadioButton("ODC");
        radioButton2 = new JRadioButton("BOX");

        ButtonGroup b1 = new ButtonGroup();
        b1.add(radioButton1);
        b1.add(radioButton2);

        panel5.add(radioButton1);
        panel5.add(radioButton2);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(textField);
        this.add(button1);
        this.add(button2);
        this.add(panel5);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                generateReceipt();
            }
        });
        
        button2.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent ae)
     	   {
     		   try {
     			   
     			   
     			   
     			   
     		   dispose();
     		  LoginPackage.LoginFrame l1=new LoginPackage.LoginFrame();
    		  l1.setVisible(true);
     	   }
     		   catch(Exception e)
     		   {
     			   System.out.println(e);
     		   }
     	   }
        });
    }

    private void generateReceipt() {
        try {
            String movie = (String) comboBox1.getSelectedItem();
            String theatre = (String) comboBox2.getSelectedItem();
            String date = (String) comboBox3.getSelectedItem();
            String time = (String) comboBox4.getSelectedItem();
            String type = radioButton1.isSelected() ? "ODC" : "Box";
            int tickets = Integer.parseInt(textField.getText());

            dispose();
            new BookingReceipt(movie, theatre, date, time, type, tickets).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
}
