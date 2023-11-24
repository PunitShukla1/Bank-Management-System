package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin , repintext;
    String pinnumber;
    JButton change,back;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber; // local to global pinnumber conversion
             
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,920,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
       JLabel text=new JLabel("CHANGE YOUR PIN");
       text.setForeground(Color.WHITE);
       text.setBounds(260,230,700,35);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);
       
       JLabel pintext=new JLabel("New PIN");
       pintext.setForeground(Color.WHITE);
       pintext.setBounds(170,270,80,35);
       pintext.setFont(new Font("System",Font.BOLD,16));
       image.add(pintext);
       
       pin=new JPasswordField();
       pin.setBounds(280,270,200,25);
       pin.setFont(new Font("System",Font.BOLD,16));
       image.add(pin);
       
       JLabel repin=new JLabel("Re-Enter");
       repin.setForeground(Color.WHITE);
       repin.setBounds(170,310,80,35);
       repin.setFont(new Font("System",Font.BOLD,16));
       image.add(repin);
       
       repintext=new JPasswordField();
       repintext.setBounds(280,310,200,25);
       repintext.setFont(new Font("System",Font.BOLD,16));
       image.add(repintext);
       
       
       change=new JButton("CHANGE");
       change.setBounds(380,430,120,30);
       change.setFont(new Font("System",Font.BOLD,10));
       change.setBackground(Color.BLACK);
       change.setForeground(Color.WHITE);
       change.addActionListener(this);
       image.add(change);
       
       back=new JButton("BACK");
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
        if(ae.getSource() == change){
           try{
             String npin = pin.getText();
             String rpin=repintext.getText();
            
             if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Pin Does Not Match");
                return;
              }
           
             if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter PIN");
                return;
              }
             
              if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Re-PIN");
                return;
              }
             
              Conn conn= new Conn();
              String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
              String query2="update login set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
              String query3="update signupthree set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
              
              conn.s.executeUpdate(query1);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);
              
               JOptionPane.showMessageDialog(null,"PIN Change Successfully");
               
               setVisible(false);
               new Transactions(rpin).setVisible(true); //because pin is changed
               
             
        } catch(Exception e){
                 System.out.println(e);
                    }
         
        
     } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
               }
    }
    
    
    public static void main(String[] args) {
        new PinChange("");
    }
    
}
