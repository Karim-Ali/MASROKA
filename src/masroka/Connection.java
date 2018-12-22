/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author new
 */
public class Connection {
    public String[] getData(String finderEmail , String loserEmail)
    {
        String finderData = new String();
        String loserData = new String();
        
        java.sql.Connection con ;
        Statement stat = null ;
        ResultSet rs ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MASROKA" , "root" , "") ;
            stat=con.createStatement();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex);
        }
        try{
            String query="select *from user where Email='"+finderEmail+"'";
            rs=stat.executeQuery(query);
            while(rs.next())
            {
                finderData=rs.getString("Phone");
            }
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        try{
            String query="select *from user where Email='"+loserEmail+"'";
            rs=stat.executeQuery(query);
            while(rs.next())
            {
                loserData=rs.getString("Phone");
            }
                
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        String []arr = {finderData , loserData} ;
        return arr;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

