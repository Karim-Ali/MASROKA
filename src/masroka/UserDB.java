/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author laptop academy
 */
public class UserDB {
    private Connection con ;
    private Statement stat ;
    private ResultSet rs ;
    
    public UserDB()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MASROKA" , "root" , "") ;
            stat=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
    }
    public void insertDB(String email ,String userName , String password , String address , String phone )
    {
        try{
            
            stat.executeUpdate("INSERT INTO user (Email , UserName , Password , Address , Phone)" + "VALUES ('"+email+"' , '"+userName+"' ,'"+password+"' , '"+address+"' , '"+phone+"')");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void getData(String data)
    {
        try{
            String query="select *from user";
            rs=stat.executeQuery(query);
            System.out.println("records from database");
            while(rs.next())
            {
                String dat=rs.getString(data);
                System.out.println(dat);
            }
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void deleteDB (String email)
    {
        try{
            
            stat.executeUpdate("DELETE FROM user WHERE Email ='"+email+"'");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
   public void updateDB(String email)
    {
        Scanner input = new Scanner(System.in) ;
        
        try{
            
            while (true)
            {
                System.out.println("do you want to update thing else (yes or no)");
                String choice = new String() ;
                choice=input.next();
                if (choice.equals("yes"))
                {
                    System.out.println("whate you to update"
                            + "\n1- email"
                            + "\n2- user name"
                            + "\n3- Address"
                            + "\n4- passeord"
                            + "\n5- phone");
                    int number = input.nextInt() ;
                    System.out.println("Enter value");
                    String value = input.next() ;
                    
                    if (number==1){
                        stat.executeUpdate("UPDATE user SET Email='"+value+"' WHERE Email ='"+email+"' ");
                    }
                    else if (number==2){
                        stat.executeUpdate("UPDATE user SET UserName='"+value+"' WHERE Email ='"+email+"' ");
                    }
                    else if (number==3){
                        stat.executeUpdate("UPDATE user SET Address='"+value+"' WHERE Email ='"+email+"' ");
                    }
                    else if (number==4){
                        stat.executeUpdate("UPDATE user SET Password='"+value+"' WHERE Email ='"+email+"' ");
                    }
                    else if (number==5){
                        stat.executeUpdate("UPDATE user SET Phone='"+value+"' WHERE Email ='"+email+"' ");
                    }
                }
                else if (choice.equals("no"))
                    break ;
                else 
                    continue;
            }
            
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
