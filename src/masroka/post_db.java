/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/**
 *
 * @author new
 */
public class post_db {
    private Connection con ;
    private Statement stat ;
    private ResultSet rs ;
    
    public post_db()
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
    public void insertDB(String ID ,String Owner , String name , String address , String photo, String  description,String qestions)
    {
        try{
            stat.executeUpdate("INSERT INTO post (ID , Owner , Name , Address , Photo,Description,Question)" + "VALUES ('"+ID+"' , '"+Owner+"' ,'"+name+"' , '"+address+"' , '"+photo+"', '"+description+"', '"+qestions+"')");      
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void getData(String data)
    {
        try{
            String query="select *from post";
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
    public void deleteDB (String ID)
    {
        try{
            
            stat.executeUpdate("DELETE FROM post WHERE ID ='"+ID+"'");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void updateDB(String ID)
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
                            + "\n1- ID"
                            + "\n2- Owner"
                            + "\n3- Name"
                            + "\n4- Address"
                            + "\n5- Photo"
                            + "\n6- Description"
                            + "\n7- Qestion"
                    );
                    int number = input.nextInt() ;
                    System.out.println("Enter value");
                    String value = input.next() ;
                    
                    if (number==1){
                        stat.executeUpdate("UPDATE post SET ID='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==2){
                        stat.executeUpdate("UPDATE  post Owner='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==3){
                        stat.executeUpdate("UPDATE post SET Name='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==4){
                        stat.executeUpdate("UPDATE post SET Address='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==5){
                        stat.executeUpdate("UPDATE post SET Photo='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==6){
                        stat.executeUpdate("UPDATE post SET Description='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==7){
                        stat.executeUpdate("UPDATE post SET Question='"+value+"' WHERE ID ='"+ID+"' ");
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
