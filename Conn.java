
package bank.management.system;
import java.sql.*;
//steps to connect the database
//register the driver
//create connection
//create statement
//execute query
//close connection


import java.sql.DriverManager;

public class Conn {

   
    Connection c;
    Statement s;
    public Conn(){
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        
    }

  
    
}

    }
    

