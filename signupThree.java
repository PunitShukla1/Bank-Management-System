package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    signupThree(String formno){
        this.formno=formno;
        
        setLayout(null); // use because setbound function work without this
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Times New Roman",Font.BOLD,25));
        l1.setBounds(310,30,400,30);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Times New Roman",Font.BOLD,18));
        type.setBackground(Color.WHITE);
        type.setBounds(100,100,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Times New Roman",Font.BOLD,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,140,200,30);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Times New Roman",Font.BOLD,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100,170,200,30);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Times New Roman",Font.BOLD,15));
        r3.setBackground(Color.WHITE);
        r3.setBounds(320,140,200,30);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Times New Roman",Font.BOLD,15));
        r4.setBackground(Color.WHITE);
        r4.setBounds(320,170,300,30);
        add(r4);
        
        ButtonGroup groupAccount= new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        
        JLabel card=new JLabel("Card Type");
        card.setFont(new Font("Times New Roman",Font.BOLD,18));
        card.setBounds(100,220,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Times New Roman",Font.BOLD,18));
        number.setBounds(320,220,300,30);
        add(number);
        
        JLabel carddetails=new JLabel("Your 16 digital card number");
        carddetails.setFont(new Font("Times New Roman",Font.BOLD,10));
        carddetails.setBounds(100,240,300,30);
        add(carddetails);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Times New Roman",Font.BOLD,18));
        pin.setBounds(100,270,200,30);
        add(pin);
        
         JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Times New Roman",Font.BOLD,18));
        pinnumber.setBounds(320,270,200,30);
        add(pinnumber);
        
        JLabel pnumber=new JLabel("Your 4 digital pin number");
        pnumber.setFont(new Font("Times New Roman",Font.BOLD,10));
        pnumber.setBounds(100,290,200,30);
        add(pnumber);
        
        JLabel service=new JLabel("Service  Required");
        service.setFont(new Font("Times New Roman",Font.BOLD,18));
        service.setBackground(Color.WHITE);
        service.setBounds(100,330,200,30);
        add(service);
        
        c1=new JCheckBox("Debit Card");
        c1.setFont(new Font("Times New Roman",Font.BOLD,15));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,360,200,30);
        add(c1);
        
        c2=new JCheckBox("Internert Banking");
        c2.setFont(new Font("Times New Roman",Font.BOLD,15));
        c2.setBackground(Color.WHITE);
        c2.setBounds(320,360,200,30);
        add(c2);
        
        c3=new JCheckBox("Credit Card");
        c3.setFont(new Font("Times New Roman",Font.BOLD,15));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,390,200,30);
        add(c3);
        
        c4=new JCheckBox("SMS & Email Alert");
        c4.setFont(new Font("Times New Roman",Font.BOLD,15));
        c4.setBackground(Color.WHITE);
        c4.setBounds(320,390,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Times New Roman",Font.BOLD,15));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,420,200,30);
        add(c5);
        
        c6=new JCheckBox("Passbook");
        c6.setFont(new Font("Times New Roman",Font.BOLD,15));
        c6.setBackground(Color.WHITE);
        c6.setBounds(320,420,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that all the details provided are correct to the best of my knowledge");
        c7.setFont(new Font("Times New Roman",Font.BOLD,10));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,460,500,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,10));
        submit.setBounds(250,520,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,10));
        cancel.setBounds(360,520,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String type=null;
            if(r1.isSelected()){
                type="Saving account";
            }else if(r2.isSelected()){
                type="Fixed Account";
            }else if(r3.isSelected()){
                type="Current Account";
            }else if(r4.isSelected()){
                type="Recurring Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber=""+ Math.abs((random.nextLong()%90000000L)+5049036000000000L);
            String pinnumber=""+ Math.abs((random.nextLong()%9000L)+1000L);
            
            
            String facility="";
            if(c1.isSelected()){
                facility= facility +"Debit  card";
            }else if(c2.isSelected()){
                facility= facility +"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+"Credit Card";
            }else if(c4.isSelected()){
                facility=facility+"Email & SMS alert";
            }else if(c5.isSelected()){
                facility=facility+"Cheque Book";
            }else if(c6.isSelected()){
                facility= facility+"Passbook";
            }
            
            try {
                if(type.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }else {
                    Conn conn = new Conn();
                    String query1="insert into signupThree values('"+formno+"','"+type+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card number"+cardnumber+"\n Pin number" + pinnumber);
                    
                }
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
            
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }
    
    public static void main(String[] args) {
        new signupThree("");
        }
}
    

