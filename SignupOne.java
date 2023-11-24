package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,pincodeTextField,cityTextField,stateTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    JLabel Name,dob,fName,emailadd,marital,gender,address,pincode,city,state;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel  formno= new JLabel("Application Form NO."+random);
        formno.setFont(new Font("Times New Roman",Font.BOLD,25));
        formno.setBounds(260,20,600,30);
        add(formno);
        
        JLabel  personalDetails= new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        personalDetails.setBounds(330,60,400,30);
        add(personalDetails);
        
        Name= new JLabel("Name:");
        Name.setFont(new Font("Times New Roman",Font.BOLD,15));
        Name.setBounds(100,140,100,30);
        add(Name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        nameTextField.setBounds(300,140,300,30);
        add(nameTextField);
        
        
        fName= new JLabel("Father Name:");
        fName.setFont(new Font("Times New Roman",Font.BOLD,15));
        fName.setBounds(100,190,100,30);
        add(fName);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        fnameTextField.setBounds(300,190,300,30);
        add(fnameTextField);
        
        dob= new JLabel("DOB:");
        dob.setFont(new Font("Times New Roman",Font.BOLD,15));
        dob.setBounds(100,240,300,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,300,30);
        add(dateChooser);
        
        gender= new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman",Font.BOLD,15));
        gender.setBounds(100,290,100,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,90,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(430,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
     
        emailadd= new JLabel("Email Address:");
        emailadd.setFont(new Font("Times New Roman",Font.BOLD,15));
        emailadd.setBounds(100,340,100,30);
        add(emailadd);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        emailTextField.setBounds(300,340,300,30);
        add(emailTextField);
        
        marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Times New Roman",Font.BOLD,15));
        marital.setBounds(100,390,100,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,90,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(410,390,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(540,390,90,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup= new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        address= new JLabel("Address:");
        address.setFont(new Font("Times New Roman",Font.BOLD,15));
        address.setBounds(100,440,100,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        addressTextField.setBounds(300,440,300,30);
        add(addressTextField);
        
        pincode= new JLabel("Pincode:");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,15));
        pincode.setBounds(100,490,100,30);
        add(pincode);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        pincodeTextField.setBounds(300,490,300,30);
        add(pincodeTextField);
        
        city= new JLabel("City:");
        city.setFont(new Font("Times New Roman",Font.BOLD,15));
        city.setBounds(100,540,100,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        cityTextField.setBounds(300,540,300,30);
        add(cityTextField);
        
       
        state= new JLabel("State:");
        state.setFont(new Font("Times New Roman",Font.BOLD,15));
        state.setBounds(100,590,100,30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        stateTextField.setBounds(300,590,300,30);
        add(stateTextField);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Times New Roman",Font.BOLD,13));
        next.setBounds(500,640,100,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random; //long
        String Name=nameTextField.getText();
        String fName=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if (female.isSelected()){
            gender="Female";
    }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        
        String address=addressTextField.getText();
        String pincode=pincodeTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        
        try{
            if(Name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+Name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+pincode+"','"+city+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
            
            
            
            /*if(fName.equals("") ){
                JOptionPane.showMessageDialog(null,"FName is Required");
            }
            if(dob.equals("") ){
                JOptionPane.showMessageDialog(null,"DOBis Required");
            }
            if(email.equals("") ){
                JOptionPane.showMessageDialog(null,"Emailaddress is Required");
            }
            
            
           */
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
        
    
    
    public static void main(String[] args) {
      new SignupOne();
      
    }
    
}
