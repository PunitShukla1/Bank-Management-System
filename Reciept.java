package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reciept extends JFrame implements ActionListener{
    String pinnumber;
    JButton print, back;
    Reciept(String pinnumber){
    this.pinnumber=pinnumber;
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       
       
       JLabel bank=new JLabel("ICICI Bank");
         bank.setBounds(280,230,700,35);
         bank.setForeground(Color.WHITE);
         bank.setFont(new Font("System",Font.BOLD,16));
         image.add(bank);
         
         JLabel card= new JLabel();
         card.setForeground(Color.WHITE);
         card.setFont(new Font("System",Font.BOLD,16));
         card.setBounds(200,280,700,35);
         image.add(card);
         
         
       print=new JButton("Print");
       print.setBounds(380,430,120,30);
       print.setFont(new Font("System",Font.BOLD,10));
       print.setBackground(Color.BLACK);
       print.setForeground(Color.WHITE);
       print.addActionListener(this);
       image.add(print);
       
       back=new JButton("BACK");
       back.setBounds(380,470,120,30);
       back.setFont(new Font("System",Font.BOLD,10));
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       image.add(back);
       
       
         try{
             Conn conn= new Conn();
             ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
             while(rs.next()){
                 card.setText("Card Number: "+rs.getString ("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString ("cardnumber").substring(12));
             }
             
         }catch(Exception e){
             System.out.println(e);
         }
       
       
       
               Conn conn = new Conn();
        int balance=0;
        try{
            ResultSet rs=conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            
            while(rs.next()){
                 //help in looping all the row
              if(rs.getString("type").equals("Deposit")){
                 balance +=Integer.parseInt(rs.getString("amount"));
            }else{
                  balance -=Integer.parseInt(rs.getString("amount"));
              }
                  }
               }catch(Exception e){
                       System.out.println(e);
             }

        JLabel text = new JLabel("Your Account Balance is Rs "+ balance); 
        text.setForeground(Color.WHITE);
        text.setBounds(200,320,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
         
         
         
         setSize(900,830);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
    
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==back){ 
            setVisible(false);
          new Transactions(pinnumber).setVisible(true);
    }
  }
    
    
    public static void main(String[] args) {
        new Reciept("");
    }
    
}
