package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; // for the resultset 

public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear;
    JTextField cardTestField; 
    JPasswordField pinTestField;
    
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon( i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,28));
        cardno.setBounds(120,160,250,30);
        add(cardno);
        
        cardTestField=new JTextField();
        cardTestField.setBounds(300,160,230,30);
        cardTestField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTestField);
        
        
         JLabel pin= new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);
        
        pinTestField=new JPasswordField();
        pinTestField.setBounds(300,220,230,30);
        pinTestField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTestField);
        
        login =new JButton("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear =new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("Sign up");
        signup.setBounds(350,340,100,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,500);
        setVisible(true);
        setLocation(300,250);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTestField.setText("");
            pinTestField.setText("");
            
        } else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber= cardTestField.getText();
            String pinnumber=pinTestField.getText();
            String query= "select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            
            try{
                ResultSet rs = conn.s.executeQuery(query); // because we match the data from database
                if(rs.next()){
                    setVisible(false); //because user login successfully
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
    } else if(ae.getSource() == signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
     
                
    }
    
    
    public static void main(String[] args) {
        new Login();
    }
    
}
