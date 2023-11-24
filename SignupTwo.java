package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    
    JLabel religion,category,income,edu_quali,occupation,aadharno,pannumber,senior,existingacc;
    JComboBox  religionTextField,categoryTextField,incomeTextField,eduTextField,occupationTextField;
    JTextField aadharTextField,pancodeTextField;
    JRadioButton yes,no,ys,nO;
    JButton next;
    String formno;
    
    
    SignupTwo(String formno){
        
        this.formno=formno;
        setLayout(null);
       
        
        JLabel  additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
        additionalDetails.setBounds(330,60,400,30);
        add(additionalDetails);
        
        religion= new JLabel("Name:");
        religion.setFont(new Font("Times New Roman",Font.BOLD,15));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        
        String valreligion[]={"Hindu","Christian","Sikh","Other"};
        religionTextField =new JComboBox(valreligion);
        religionTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        religionTextField.setBounds(300,140,300,30);
        religionTextField.setBackground(Color.WHITE);
        add(religionTextField);
        
        
        category= new JLabel("Category");
        category.setFont(new Font("Times New Roman",Font.BOLD,15));
        category.setBounds(100,190,100,30);
        add(category);
        
        String valcategory[]={"General","OBC","SC","ST"};
        categoryTextField=new JComboBox(valcategory);
        categoryTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        categoryTextField.setBounds(300,190,300,30);
        categoryTextField.setBackground(Color.WHITE);
        add(categoryTextField);
        
        income= new JLabel("Income");
        income.setFont(new Font("Times New Roman",Font.BOLD,15));
        income.setBounds(100,240,300,30);
        add(income);
        
        String valincome[]={"Below 2.5 lakh", "Below 5 lakh", "Below 10 lakh","Between 10-15 lakh","Above 15 lakh"};
        incomeTextField=new JComboBox(valincome);
        incomeTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        incomeTextField.setBounds(300,240,300,30);
        incomeTextField.setBackground(Color.WHITE);
        add(incomeTextField);
        
     
        edu_quali= new JLabel("Education Qualification");
        edu_quali.setFont(new Font("Times New Roman",Font.BOLD,15));
        edu_quali.setBounds(100,290,200,30);
        add(edu_quali);
        
        String valedu_quali[]={"10th Pass", "12th Pass","Graduate","Post-Graduate","Ph.D"};
        eduTextField=new JComboBox(valedu_quali);
        eduTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        eduTextField.setBounds(300,290,300,30);
        eduTextField.setBackground(Color.WHITE);
        add(eduTextField);
       
        
        occupation= new JLabel("Occupation");
        occupation.setFont(new Font("Times New Roman",Font.BOLD,15));
        occupation.setBounds(100,340,100,30);
        add(occupation);
        
        String valoccupation[]={"Self-employeed","Job","Bussiness","Teacher"};
        occupationTextField=new JComboBox(valoccupation);
        occupationTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        occupationTextField.setBounds(300,340,300,30);
        occupationTextField.setBackground(Color.WHITE);
        add(occupationTextField);
        
        pannumber= new JLabel("PAN Number");
        pannumber.setFont(new Font("Times New Roman",Font.BOLD,15));
        pannumber.setBounds(100,390,100,30);
        add(pannumber);
        
        pancodeTextField =new JTextField();
        pancodeTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        pancodeTextField.setBounds(300,390,300,30);
        add(pancodeTextField);
        
        aadharno= new JLabel("Aadhar Number");
        aadharno.setFont(new Font("Times New Roman",Font.BOLD,15));
        aadharno.setBounds(100,440,120,30);
        add(aadharno);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Times New Roman",Font.BOLD,15));
        aadharTextField.setBounds(300,440,300,30);
        add(aadharTextField);
        
        
        senior= new JLabel("Senior Citizen");
        senior.setFont(new Font("Times New Roman",Font.BOLD,15));
        senior.setBounds(100,490,120,30);
        add(senior);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,490,90,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("NO");
        no.setBounds(430,490,100,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seniorgroup= new ButtonGroup();
        seniorgroup.add(yes);
        seniorgroup.add(no);
        
        existingacc= new JLabel("Existing Account");
        existingacc.setFont(new Font("Times New Roman",Font.BOLD,15));
        existingacc.setBounds(100,540,120,30);
        add(existingacc);
        
        ys=new JRadioButton("Yes");
        ys.setBounds(300,540,90,30);
        ys.setBackground(Color.WHITE);
        add(ys);
        
        nO=new JRadioButton("NO");
        nO.setBounds(430,540,100,30);
        nO.setBackground(Color.WHITE);
        add(nO);
        
        ButtonGroup accountgroup= new ButtonGroup();
        accountgroup.add(ys);
        accountgroup.add(nO);
       
       
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
        
        String religion=(String) religionTextField.getSelectedItem();
        String category=(String)categoryTextField.getSelectedItem();
        String income=(String) incomeTextField.getSelectedItem();
        String edu_quali=(String) eduTextField.getSelectedItem();
        String occupation=(String) occupationTextField.getSelectedItem();
        
        
        String seniorgroup=null;
        if(yes.isSelected()){
            seniorgroup="Yes";
        }else if (no.isSelected()){
            seniorgroup="NO";
    }
        String aadharno=aadharTextField.getText();
        String pannumber=pancodeTextField.getText();
        
        String existingacc=null;
        if(ys.isSelected()){
            existingacc="Yes";
        }else if(nO.isSelected()){
            existingacc="No";
        }
        
        
        
        try{
                Conn c=new Conn();
                String query="insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+edu_quali+"','"+occupation+"','"+seniorgroup+"','"+aadharno+"','"+pannumber+"','"+existingacc+"')";
                c.s.executeUpdate(query);
                
                //SignupThree object
                setVisible(false);
                new signupThree(formno).setVisible(true);
                
            }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
        
    
    
    public static void main(String[] args) {
      new SignupTwo("");
      
    }
    
}
