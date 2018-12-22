/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author new
 */
public class address_db {
    private Connection con ;
    private Statement stat ;
    private ResultSet rs ;
    
    public address_db()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/MASROKA" , "root" , "") ;
            stat=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
    }
    public void insertDB(String Country ,String Governate , String Street , int Bulding , int Floor,int apartment )
    {
        try{
            
            stat.executeUpdate("INSERT INTO address (Country , Governate , Street , Bulding , Floor, apartment)" + "VALUES ('"+Country+"' , '"+Governate+"' ,'"+Street+"' , '"+Bulding+"' , '"+Floor+"','"+apartment+"')");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void getData(String data)
    {
        try{
            String query="select *from address";
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
    public void deleteDB (String apartment)
    {
        try{
            
            stat.executeUpdate("DELETE FROM address WHERE apartment ='"+apartment+"'");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void updateDB(String apartment)
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
                            + "\n1- Country"
                            + "\n2- Governate"
                            + "\n3- Street"
                            + "\n4- Bulding"
                            + "\n5- Floor"
                            + "\n6- apartment"
                    );
                    int number = input.nextInt() ;
                    System.out.println("Enter value");
                    String value = input.next() ;
                    
                    if (number==1){
                        stat.executeUpdate("UPDATE address SET Country='"+value+"' WHERE apartment ='"+apartment+"' ");
                    }
                    else if (number==2){
                        stat.executeUpdate("UPDATE address SET Governate='"+value+"' WHERE apartment ='"+apartment+"' ");
                    }
                    else if (number==3){
                        stat.executeUpdate("UPDATE address SET Street='"+value+"' WHERE apartment ='"+apartment+"' ");
                    }
                    else if (number==4){
                        stat.executeUpdate("UPDATE address SET Bulding='"+value+"' WHERE apartment ='"+apartment+"' ");
                    }
                    else if (number==5){
                        stat.executeUpdate("UPDATE address SET Floor='"+value+"' WHERE apartment ='"+apartment+"' ");
                    }
                    else if (number==6){
                        stat.executeUpdate("UPDATE address SET apartment='"+value+"' WHERE apartment ='"+apartment+"' ");
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

