package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber=pinnumber;
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       
       back=new JButton("BACK");
       back.setBounds(380,470,120,30);
       back.setFont(new Font("System",Font.BOLD,10));
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       image.add(back);
       
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
        text.setBounds(200,230,700,35);
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
       new BalanceEnquiry("");
    }
    
}
