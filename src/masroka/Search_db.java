/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author new
 */
public class Search_db {
    private Connection con ;
    private Statement stat ;
    private ResultSet rs ;
    public Search_db()
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
    public String getAddress(String Email_User)
    {
       String dat="";
        try{
            String query="select *from user where Email='"+Email_User+"'";
            rs=stat.executeQuery(query);
            while(rs.next())
            {
                dat=rs.getString("Address");
            }
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        } 
        return dat;
    }
    public ArrayList<String> SearchByName(String name)
    {
      ArrayList<String> arr=new ArrayList<String>();
      String s="";
      try{
            String query="select *from post where Name like '%"+name+"%'";
            rs=stat.executeQuery(query);
            while(rs.next())
            {
                s+=rs.getString("ID")+"#";   
                s+=rs.getString("Owner")+"#";
                s+=rs.getString("Name")+"#";
                s+=rs.getString("Address")+"#";
                s+=rs.getString("Photo")+"#";
                s+=rs.getString("Description")+"#";
                s+=rs.getString("Question");
                arr.add(s);
                s="";
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        } 
      return arr;
    }
    
    public void serch_by_address()
    {
        
    }
    public void serch_by_type()
    {
        
    }
    public void serch_by_name()
    {
        
    }
    public void getPostID()
    {
        
    }
    
}
