/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masroka;

import java.util.ArrayList;

/**
 *
 * @author new
 */
public class Write_post {
    public static int id=1;
    public String addQuestion(ArrayList <String> quest)
    {
       String con="";
        for(int i=0;i<quest.size();i++)
       {
           con+=quest.get(i);
       }
        return con;
    }
    public String addDescreption(String desc)
    {
       String con=desc;
       return con;
    }
    public static int setID()
    {
        int num=id;
        id++;
        return num;
    }
    
}
