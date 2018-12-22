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
import java.util.regex.*;
import sun.applet.Main;


/**
 *
 * @author new
 */
public class validate_data {
    
    public boolean check_email(String email)
    {
    boolean res=true;
    try{Matcher matcher =Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9,-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE).matcher(email);
    if(matcher.find())
    {
        res=true;
    }
    else{
        res=false;
        }
    
    }
    catch(Exception e)
    {
    }
    return res;
    }
    public boolean check_pass(String password)
    {
        boolean res=true;
        if(password.length()>255||password.length()<8)
        {
            res=false;
        }
        String upperchar="(.*[A-Z].*)";
        String lowerchar="(.*[a-z].*)";
        if(!password.matches(upperchar)&&!password.matches(lowerchar))
        {
            res=false;
        }
       
        return res;
     }
    public boolean check_phone(String phone)
    {
     boolean res=true;
     if(!(phone.length()==10))
     {
       res=false;  
     }
     if(!(phone.substring(0, 1).equals("1")))
     {
        res=false; 
     }
     if(!(phone.substring(0, 2).equals("10"))&&!(phone.substring(0, 2).equals("11"))&&!(phone.substring(0, 2).equals("12"))&&!(phone.substring(0, 2).equals("15")))
     {
        res=false; 
     }
     return  res;
    }
    public boolean validate_logIN(String Email,String password)
    {
    Connection con ;
    Statement stat = null ;
    ResultSet rs ;
    boolean res=true;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MASROKA" , "root" , "") ;
            stat=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
         
        String dat="";
        try{
            String query="select *from user where Email='"+Email+"'";
            rs=stat.executeQuery(query);
            while(rs.next())
            {
                dat=rs.getString("Password");
            }
            if(!dat.equals(password))
            {res=false;}
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        } 
      return res;
    }
     
}

