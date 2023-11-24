package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balenquirey,exit,receipt;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       
       JLabel text=new JLabel("Please Select Your Transaction");
       text.setForeground(Color.WHITE);
       text.setBounds(220,220,700,35);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       deposit=new JButton("Deposite");
       deposit.setBounds(160,350,120,30);
       deposit.setFont(new Font("System",Font.BOLD,10));
       deposit.setBackground(Color.BLACK);
       deposit.setForeground(Color.WHITE);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawl=new JButton("Withdrawl");
       withdrawl.setBounds(160,390,120,30);
       withdrawl.setFont(new Font("System",Font.BOLD,10));
       withdrawl.setBackground(Color.BLACK);
       withdrawl.setForeground(Color.WHITE);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
       fastcash=new JButton("Fast cash");
       fastcash.setBounds(160,430,120,30);
       fastcash.setFont(new Font("System",Font.BOLD,10));
       fastcash.setBackground(Color.BLACK);
       fastcash.setForeground(Color.WHITE);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
       ministatement=new JButton("Mini-statement");
       ministatement.setBounds(160,470,120,30);
       ministatement.setFont(new Font("System",Font.BOLD,10));
       ministatement.setBackground(Color.BLACK);
       ministatement.setForeground(Color.WHITE);
       ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange=new JButton("Pin change");
       pinchange.setBounds(380,350,120,30);
       pinchange.setFont(new Font("System",Font.BOLD,10));
       pinchange.setBackground(Color.BLACK);
       pinchange.setForeground(Color.WHITE);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
       balenquirey=new JButton("Balance Enquiry");
       balenquirey.setBounds(380,390,120,30);
       balenquirey.setFont(new Font("System",Font.BOLD,10));
       balenquirey.setBackground(Color.BLACK);
       balenquirey.setForeground(Color.WHITE);
       balenquirey.addActionListener(this);
       image.add(balenquirey);
       
       receipt=new JButton("Receipt");
       receipt.setBounds(380,430,120,30);
       receipt.setFont(new Font("System",Font.BOLD,10));
       receipt.setBackground(Color.BLACK);
       receipt.setForeground(Color.WHITE);
       receipt.addActionListener(this);
       image.add(receipt);
       
       exit=new JButton("Exit");
       exit.setBounds(380,470,120,30);
       exit.setFont(new Font("System",Font.BOLD,10));
       exit.setBackground(Color.BLACK);
       exit.setForeground(Color.WHITE);
       exit.addActionListener(this);
       image.add(exit);
       
       
       
        
        setSize(900,830);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== exit){
          System.exit(0);
      }else if(ae.getSource()==deposit){
          setVisible(false);
          new Deposit(pinnumber).setVisible(true);
    }else if(ae.getSource()==withdrawl){
        setVisible(false);
        new Withdrawl(pinnumber).setVisible(true); 
    }else if(ae.getSource()==fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true); 
    }else if(ae.getSource()==pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
    }else if(ae.getSource()==balenquirey){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
    }else if(ae.getSource()==ministatement){
        new MiniStatement(pinnumber).setVisible(true);
    }else if(ae.getSource()==receipt){
        setVisible(false);
        new Reciept(pinnumber).setVisible(true);
    }

  }
    public static void main(String[] args) {
        new Transactions("");
    }
    
}
