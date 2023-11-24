package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; //for the resultset
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton with100,with500,with1000,with2000,with5000,with8000,with10000,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       
       JLabel text=new JLabel("Select Withdrawl Type");
       text.setForeground(Color.WHITE);
       text.setBounds(220,220,700,35);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       with100=new JButton("Rs 100");
       with100.setBounds(160,350,120,30);
       with100.setFont(new Font("System",Font.BOLD,10));
       with100.setBackground(Color.BLACK);
       with100.setForeground(Color.WHITE);
       with100.addActionListener(this);
       image.add(with100);
       
       with500=new JButton("Rs 500");
       with500.setBounds(160,390,120,30);
       with500.setFont(new Font("System",Font.BOLD,10));
       with500.setBackground(Color.BLACK);
       with500.setForeground(Color.WHITE);
       with500.addActionListener(this);
       image.add(with500);
       
       with1000=new JButton("Rs 1000");
       with1000.setBounds(160,430,120,30);
       with1000.setFont(new Font("System",Font.BOLD,10));
       with1000.setBackground(Color.BLACK);
       with1000.setForeground(Color.WHITE);
       with1000.addActionListener(this);
       image.add(with1000);
       
       with2000=new JButton("Rs 2000");
       with2000.setBounds(160,470,120,30);
       with2000.setFont(new Font("System",Font.BOLD,10));
       with2000.setBackground(Color.BLACK);
       with2000.setForeground(Color.WHITE);
       with2000.addActionListener(this);
       image.add(with2000);
       
       with5000=new JButton("Rs 5000");
       with5000.setBounds(380,350,120,30);
       with5000.setFont(new Font("System",Font.BOLD,10));
       with5000.setBackground(Color.BLACK);
       with5000.setForeground(Color.WHITE);
       with5000.addActionListener(this);
       image.add(with5000);
       
       with8000=new JButton("Rs 8000");
       with8000.setBounds(380,390,120,30);
       with8000.setFont(new Font("System",Font.BOLD,10));
       with8000.setBackground(Color.BLACK);
       with8000.setForeground(Color.WHITE);
       with8000.addActionListener(this);
       image.add(with8000);
       
       with10000=new JButton("Rs 10000");
       with10000.setBounds(380,430,120,30);
       with10000.setFont(new Font("System",Font.BOLD,10));
       with10000.setBackground(Color.BLACK);
       with10000.setForeground(Color.WHITE);
       with10000.addActionListener(this);
       image.add(with10000);
       
       back=new JButton("Back");
       back.setBounds(380,470,120,30);
       back.setFont(new Font("System",Font.BOLD,10));
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       image.add(back);
       
       
        setSize(900,830);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
         }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== back){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
      }else {
         String amount=((JButton)ae.getSource()).getText().substring(3);//with get text we get RS 500 but we want 500 so use substring
         Conn conn = new Conn();
         try{
             ResultSet rs=conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
             int balance=0;
             while(rs.next()){
                 //help in looping all the row
                 if(rs.getString("type").equals("Deposit")){
                     balance +=Integer.parseInt(rs.getString("amount"));
                 }else{
                 balance -=Integer.parseInt(rs.getString("amount"));
                  }
               }
             if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
             }
             
             Date date = new Date(); // we get date from util package because we have date in sql and util both package
             String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
             conn.s.executeUpdate(query); 
             JOptionPane.showMessageDialog(null,"Amount"+amount+"Debited Succcessfully");
             
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
             
             
             
         }catch (Exception e){
             System.out.println(e);
         }
    }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
    
}
