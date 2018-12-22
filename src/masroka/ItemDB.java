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

/**
 *
 * @author laptop academy
 */
public class ItemDB {
    private Connection con ;
    private Statement stat ;
    private ResultSet rs ;
    public ItemDB()
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
    
    public void insertDB(String type , String name , String ID ,String address , String ownerID )
    {
        try{
            
            stat.executeUpdate("INSERT INTO item (Type , Name , ID , Address , OwnerID)" + "VALUES ('"+type+"' , '"+name+"' ,'"+ID+"' , '"+address+"' , '"+ownerID+"')");
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
     public void getData(String data)
    {
        try{
            rs=stat.executeQuery("select *from item");
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
            
            stat.executeUpdate("DELETE FROM item WHERE ID ='"+email+"'");
                
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
                            + "\n1- Type"
                            + "\n2- Name"
                            + "\n3- ID"
                            + "\n4- Address"
                            + "\n5- OwnerID");
                    int number = input.nextInt() ;
                    System.out.println("Enter value");
                    String value = input.next() ;
                    
                    if (number==1){
                        stat.executeUpdate("UPDATE item SET Type='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==2){
                        stat.executeUpdate("UPDATE item SET Name='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==3){
                        stat.executeUpdate("UPDATE item SET ID='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==4){
                        stat.executeUpdate("UPDATE item SET Address='"+value+"' WHERE ID ='"+ID+"' ");
                    }
                    else if (number==5){
                        stat.executeUpdate("UPDATE item SET OwnerID='"+value+"' WHERE ID ='"+ID+"' ");
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
