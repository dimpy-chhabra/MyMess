/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ConnectLogicAdmin {
    

    public String[] dbLogicFetchDetails(String Data) {
        String enroll;
        enroll = Data;
        PreparedStatement ps = null;
        
            String dbDataDetails[] = new String[14];
              
        try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            //System.out.println("  LogicAdmin : dbLogicFetchDetails :Reach_notify "+Data);
            String str_query="SELECT `usr_enroll`, `usr_name`, `usr_surname`, `usr_roomno`, `usr_gender`,`usr_dob`,`usr_course`, `usr_classof`, `usr_contact`, `usr_email`, `usr_balance` FROM user_details WHERE `usr_enroll` = '"+enroll+"';";
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            
            dbDataDetails[0]=rs.getString(1);
            dbDataDetails[1]=rs.getString(2);
            dbDataDetails[2]=rs.getString(3);
            dbDataDetails[3]=rs.getString(4);
            dbDataDetails[4]=rs.getString(5);
            dbDataDetails[5]=rs.getString(6);
            dbDataDetails[6]=rs.getString(7);
            dbDataDetails[7]=rs.getString(8);
            dbDataDetails[8]=rs.getString(9);
            dbDataDetails[9]=rs.getString(10);
            dbDataDetails[10]=rs.getString(11);
            }
            
            //System.out.println("Connect Logic : LogicFetchDetails : "+dbDataDetails[2]+ " :The previous data is some detail");
            con.close();
            return dbDataDetails;      
   }
   catch(Exception e){ 
       e.getMessage(); 
       
   }
       String[] error = new String[1];
       error[0] = "err occured in ConnectLogic";
       return error;  
    
    }

    public int dbLogicAddMenuItem(String[] newData) {
        PreparedStatement ps = null;
        
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            String table = "menu_all";
            String str_query="INSERT INTO "+table+" ("
                    + "CODE,"
                    + "ITEM,"
                    + "RATE,"
                    + "STOCK_AVAIL,"
                    + "TYPE) VALUES(?,?,?,?,?);";
        //    String str_query="insert into user_details(usr_name,usr_surname,usr_gender,usr_id,usr_pword,usr_enroll,usr_course,usr_classof,usr_dob,usr_email,usr_contact,usr_roomno,usr_secureq,usr_securea) VALUES('Sarah', 'Johnes');" ;
          
            ps=con.prepareStatement(str_query);
            ps.setString(1, newData[0]);
            ps.setString(2, newData[1]);
            ps.setString(3, newData[2]);
            ps.setString(4, newData[3]);
            ps.setString(5, newData[4]);
            //ps.setString(6, newData[5]);
           
            
        //    ps=con.prepareStatement("INSERT INTO user_details VALUES('"+dbData[0]+"', '"+dbData[1]+"', '"+dbData[2]+"', '"+dbData[3]+"', '"+dbData[4]+"', '"+dbData[5]+"', '"+dbData[6]+"', '"+dbData[7]+"', '"+dbData[8]+"', '"+dbData[9]+"', '"+dbData[10]+"', '"+dbData[11]+"', '"+dbData[12]+"', '"+dbData[13]+"'); ");
        //    System.out.println("this:"+ps);
            int i = ps.executeUpdate();
            if(i>0)
                return 1;
            else
                return 0;
            
    
        } catch(Exception e)
        {   e.getMessage(); }
return 0;        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public int dbLogicsUpdateStock(String[] newRow){
    //System.out.println("Coonect Logic Admin : dbLogicsUpdateStock : new items : "+newRow[0]+ " & "+newRow[1]+ " & "+newRow[2]+" & "+newRow[3]);
    
    String item_code = newRow[0];
    String item = newRow[1];
    String rate = newRow[2];
    String availi = newRow[3];
    //System.out.println("Coonect Logic Admin : dbLogicsUpdateStock : new items : "+item_code+ " & "+ item+ " & "+rate+" & "+availi);
    
    try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            com.mysql.jdbc.Statement stmt=(com.mysql.jdbc.Statement) con.createStatement();  
            
            String str= "UPDATE menu_all SET RATE="+rate+" ,STOCK_AVAIL ="+availi+" WHERE CODE = '"+item_code+"';  ";
            con.prepareStatement(str);          
            int i = stmt.executeUpdate(str); 
            if(i>0)  
                return 1;
            else  
                return 2;
        } catch(ClassNotFoundException | SQLException e)
        {   e.getMessage(); }
        


return 2;    
}

    public int dbLogicsRemoveMenuItem(String[] newRow) {
    
         try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            com.mysql.jdbc.Statement stmt=(com.mysql.jdbc.Statement) con.createStatement();  
            
            String str= "DELETE FROM menu_all WHERE CODE = '"+newRow[0]+"'; ";
            con.prepareStatement(str);          
            int i = stmt.executeUpdate(str); 
            if(i>0)  
                return 1;
            else  
                return 2;
        } catch(ClassNotFoundException | SQLException e)
        {   e.getMessage(); }
        


return 2;    
        
    
    }
}