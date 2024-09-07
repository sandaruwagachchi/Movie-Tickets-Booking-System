package StartPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass
{
	public static void main(String[] args) {
        JFrame frame = new JFrame("DashBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("C:\\Users\\Lap.lk\\Pictures\\best-avengers-pictures-tkqxv7yjk1pbub3y.jpg").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        JLabel label=new JLabel("Movie Tickets Booking System",JLabel.CENTER);
        label.setFont(new Font("Georgia", Font.BOLD, 70));
	    label.setForeground(Color.WHITE);
	    label.setBounds(100, 300, 1100, 100);
	 
	    
	    JButton button1=new JButton("LOGIN");
	    button1.setBounds(1000, 20, 150, 40);
	    button1.setFocusable(false);
	    button1.setBackground(Color.RED);
	    button1.setForeground(Color.BLACK);
	    button1.setFont(new Font("Georgia", Font.BOLD, 20));
	    
	    JButton button2=new JButton("SIGN UP");
	    button2.setBounds(1200, 20, 150, 40);
	    button2.setFocusable(false);
	    button2.setBackground(Color.RED);
	    button2.setForeground(Color.BLACK);;
	    button2.setFont(new Font("Georgia", Font.BOLD, 20));
	    
        panel.setLayout(null);
        frame.add(panel);
        frame.setSize(new Dimension(900, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        
        button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
        	try {
        	LoginPackage.LoginFrame l1=new LoginPackage.LoginFrame();
  			l1.setVisible(true);
        	}
        	catch(Exception e) {
        		System.out.println(e);
        	}
        }
        	
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	try {
            	SignupPackage.SignupFrame s1=new SignupPackage.SignupFrame();
      			s1.setVisible(true);
            	}
            	catch(Exception e) {
            		System.out.println(e);
            	}
            }
            	
            });
        
       
    }
}