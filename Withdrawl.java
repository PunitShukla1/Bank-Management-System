package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
         // use for working of the setBound function
        this.pinnumber=pinnumber;
         
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       JLabel text=new JLabel("Enter the amount you to Withdrawl");
       text.setForeground(Color.WHITE);
       text.setBounds(200,220,700,35);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       amount=new JTextField();
       amount.setBounds(180,270,300,35);
       amount.setFont(new Font("System",Font.BOLD,16));
       image.add(amount);
       
       withdraw=new JButton("Withdraw");
       withdraw.setBounds(355,380,150,25);
       withdraw.addActionListener(this);
       image.add(withdraw);
       
       back=new JButton("Back");
       back.setBounds(355,420,150,25);
       back.addActionListener(this);
       image.add(back);
        
       
       
        setSize(900,800);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Amount "+number+" withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
            } catch(Exception e){
                System.out.println(e);
                
            }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
    }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
} 

