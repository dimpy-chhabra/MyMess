/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanage;
//import java.math.BigDecimal;
import java.sql.*;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
//import java.math.BigInteger;
//import static oracle.jrockit.jfr.events.Bits.longValue;

/**
 *
 * @author Dell
 */
public class ConnectLogic {
    /*String ConnString="jdbc:mysql://localhost:3306/user_details";
    String ConnId="root";
    String ConnPass="dimpy00"; 
    */
    //Register user into musql table user_details
    public int dbLogicUregister(String[] dbData) {
        
            //converting string to biginteger value
            long user_contact_no = Long.valueOf(dbData[10]);/*
            byte[] fooBytes = dbData[10].getBytes();
            BigInteger user_contact = new BigInteger(fooBytes);
            long user_contact_no = longValue(user_contact); */
            
            //System.out.println(user_contact);
            
            PreparedStatement ps = null;
        
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            String table = "user_details";
            String str_query="INSERT INTO "+table+" ("
                    + "usr_name,"
                    + "usr_surname,"
                    + "usr_gender,"
                    + "usr_id,"
                    + "usr_pword,"
                    + "usr_enroll,"
                    + "usr_course,"
                    + "usr_classof,"
                    + "usr_dob,"
                    + "usr_email,"
                    + "usr_contact,"
                    + "usr_roomno,"
                    + "usr_secureq,"
                    + "usr_securea,"
                    + "usr_balance) VALUES(?,?,?,?,?,?,?,?,?,?, ? ,?,?,?,?);";
        //    String str_query="insert into user_details(usr_name,usr_surname,usr_gender,usr_id,usr_pword,usr_enroll,usr_course,usr_classof,usr_dob,usr_email,usr_contact,usr_roomno,usr_secureq,usr_securea) VALUES('Sarah', 'Johnes');" ;
          
            ps=con.prepareStatement(str_query);
            ps.setString(1, dbData[0]);
            ps.setString(2, dbData[1]);
            ps.setString(3, dbData[2]);
            ps.setString(4, dbData[3]);
            ps.setString(5, dbData[4]);
            ps.setString(6, dbData[5]);
            ps.setString(7, dbData[6]);
            ps.setInt(8, Integer.parseInt(dbData[7]));
            ps.setString(9, dbData[8]);
            ps.setString(10, dbData[9]);
            ps.setLong(11, user_contact_no);
            ps.setInt(12, Integer.parseInt(dbData[11]));
            ps.setString(13, dbData[12]);
            ps.setString(14, dbData[13]);
            ps.setInt(15, Integer.parseInt(dbData[14]));
            
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
}
    
    //Checking data for login of user
    public int dbLogicLogin(String[] dbData) {
        
        //System.out.println("Page : dbLogicLogin : reached");
           
        PreparedStatement ps = null;
        
        try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query="SELECT usr_id, usr_pword , usr_enroll FROM user_details WHERE `usr_id` = '"+dbData[0]+"';";
            
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
            
            String dbUsername=rs.getString(1);
            String dbPassword=rs.getString(2);
            String dbEnrollmentNo = rs.getString(3);
            /*
                dbData[0]=id;
                dbData[1]=pword;
                dbData[2]= enrollno;
            */
               // System.out.println("enroll no."+dbData[1]+ "  " +dbData[2]+"   " +dbData[0]);
                
                //System.out.println("enroll no."+dbPassword+"  " +dbUsername+"   "  +dbEnrollmentNo);
                if(dbPassword.equals(dbData[1])&&dbEnrollmentNo.equals(dbData[2])){
               //good
                    return 1;
               }
               else if(!(dbPassword.equals(dbData[1]))){
               //bad password or enrollment no.
                   return 2; 
               }
                else if(!(dbEnrollmentNo.equals(dbData[2]))){
               //bad password or enrollment no.
                   return 3; 
               } 
            }
            /*
            if(resultCount==0){
            Validate=0;
            LoginRetArray[0]="0";
            LoginRetArray[1]="null";
            }
            
         //validate
            */
            
            con.close();
                  
   }
   catch(Exception e){ e.getMessage(); }
       return 0;
   }
        
    //Checking data for user case : forgot password
    public int dbLogicFpwordVC(String[] dbData) {
        
        PreparedStatement ps = null;
        
        try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            System.out.println("ConnectLogic : FpwordVC : here :D");
            String str_query="SELECT `usr_name`, `usr_enroll`, `usr_secureq` FROM user_details WHERE `usr_enroll` = '"+dbData[1]+"';";
            
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int i=0;
            while(rs.next()){ 
                i++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
            //System.out.println(""+dbData[0]+"  "+dbData[1]+ "  "+dbData[2]);
            
            String dbDataCL[]= new String[3];
            dbDataCL[0]=rs.getString(1); //name
            dbDataCL[1]=rs.getString(2);//enrollment no
            dbDataCL[2]=rs.getString(3);//seq 
            
            
                if((dbDataCL[0].equals(dbData[0])) && (dbDataCL[1].equals(dbData[1])) && (dbDataCL[2].equals(dbData[2])))
                return 1;
               //good
                
               else 
               return 0; 
                //bad details
                
                          
            }
        con.close();
        }
   catch(Exception e){ System.out.println("EXCEPTION : ****** " +e); }
       return 0;
   }
        
    //Checking security answer for case : forgot password
    public int dbLogicFpwordGC(String[] dbData) { 
        
        System.out.println("ConnectLogic : LogicFpwordGC : HERE..." +dbData[0] + "  " + dbData[3] + "  " + dbData[1]);
        PreparedStatement ps = null;
        
        
    try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query="SELECT `usr_securea` FROM user_details WHERE `usr_enroll` = '"+dbData[1]+"';";
            
            ResultSet rs=stmt.executeQuery(str_query);  
            
            //int resultCount=0;
            while(rs.next()){ 
            //    resultCount++;
            
            String dbDataCL[]= new String[1];
            dbDataCL[0]=rs.getString(1);
            System.out.println(dbDataCL[0] + " LogicPwordGC : STORED SECURITY ANSWER");
                if(dbData[3].equals(dbDataCL[0]))
               {//good
                    return 1;
               }
               else 
               {//bad details
                   return 0; 
               } 
            }           
    
        con.close();
        }
    
    
   catch(Exception e){ e.getMessage(); }

    return 0;
   }    
       
    //Changing password in user_details case : forgot password
    public int dbLogicFpwordCP(String[] dbData) {
        
       PreparedStatement ps = null;
        
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            String table = "user_details";
            String str_query="UPDATE "+table+" SET usr_pword= '"+dbData[4]+"' WHERE usr_enroll = '"+dbData[1]+"';";
            ps=con.prepareStatement(str_query);          
            int i = ps.executeUpdate(); 
            if(i>0)  
                return 1; 
            else  
                return 0;
        } catch(Exception e)
        {   e.getMessage(); }
        // INSERT INTO user_details (usr_enroll) VALUES(new_password);
    // UPDATE "+table+" SET usr_pword= ( ? ) WHERE usr_enroll = (?);
    // UPDATE user_details SET usr_pword= 'newpassword' WHERE usr_enroll = ;
return 0;        
   } 
      
    ///////////////////////////////////////////////////////////////////////////////////REGISTER MODULE DONE!
    
    public String[] dbLogicFetchDetails(String[] dbData) {
//0->username
//1->password
//2->enrollment no

       
        PreparedStatement ps = null;
        
            String dbDataDetails[] = new String[14];
        
        
                
        try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query="SELECT `usr_enroll`, `usr_name`, `usr_surname`, `usr_roomno`, `usr_gender`,`usr_dob`,`usr_course`, `usr_classof`, `usr_contact`, `usr_email`, `usr_balance` FROM user_details WHERE `usr_id` = '"+dbData[0]+"';";
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10)); 
               
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
            
           // System.out.println("Connect Logic : LogicFetchDetails : "+dbDataDetails[2]+ " The previous data is some detail");
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

    
    public int RechargeMoney(String[] NewBalData) {
        
        PreparedStatement ps = null;
        
                try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
        
            String str_query="UPDATE user_details SET usr_balance= '"+NewBalData[1]+"' WHERE usr_enroll = '"+NewBalData[0]+"';";
            ps=con.prepareStatement(str_query);          
            int i = ps.executeUpdate(); 
            if(i>0)  
                return 1; 
            else  
                return 0;
        } catch(Exception e)
        {   e.getMessage(); }
return 0;        
   }

    public String dbLogicFetchMenu() {
            //Get ENTIRE MENU
            
            String[] dbData_Menu = new String[40];
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            java.sql.Statement stmt=con.createStatement();  
            com.mysql.jdbc.Statement stmt_1 = (com.mysql.jdbc.Statement)con.createStatement();
            
            
            String query="Select * from menu_all;";

            ResultSet rs=stmt_1.executeQuery(query);
            while(rs.next()) {
                //String S_No=rs.getString("SNo");
                //String Item=rs.getString("Item");
                //String Cost=rs.getString("Cost");
                
                String Item_code=rs.getString("CODE");
                String Item=rs.getString("ITEM");
                String RATE=rs.getString("RATE");
                String Availi=rs.getString("STOCK_AVAIL");
                
                return Item_code+"#"+Item+"#"+RATE+"#"+Availi;
                
                //float rate=Float.parseFloat(RATE);
                //float avail=Float.parseFloat(Availi);
                //model.addRow(new Object[]{Item_code,Item,rate,avail});
                
            }
           } catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
     /*   try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query="SELECT * FROM menu_all ;";
            
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
            
            dbData_Menu[0] =rs.getString(1);
            dbData_Menu[1] =rs.getString(2);
            dbData_Menu[2] =rs.getString(3);
            dbData_Menu[3] =rs.getString(4);
            dbData_Menu[4] =rs.getString(5);
            dbData_Menu[5] =rs.getString(6);
            dbData_Menu[6] =rs.getString(7);
            dbData_Menu[7] =rs.getString(8);
            
            }
                stmt.getMoreResults();
           
            {
                dbData_Menu[8] =rs.getString(1);              dbData_Menu[9] =rs.getString(2);            dbData_Menu[10] =rs.getString(3);            dbData_Menu[11] =rs.getString(4);
            dbData_Menu[12] =rs.getString(5);           
            }
            
            con.close();
        return dbData_Menu;              
   }
   catch(Exception e){ e.getMessage(); }
       return dbData_Menu;
    */
return "error occured";
        }
    public String[] dbLogicFetchCart() {
            String[] dbData_Cart = new String[40];
        
        try{           
      
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query="SELECT * FROM menu_all ;";
            
            ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
            
            dbData_Cart[0] =rs.getString(1);
            dbData_Cart[1] =rs.getString(2);
            dbData_Cart[2] =rs.getString(3);
            dbData_Cart[3] =rs.getString(4);
            dbData_Cart[4] =rs.getString(5);
            dbData_Cart[5] =rs.getString(6);
            dbData_Cart[6] =rs.getString(7);
            dbData_Cart[7] =rs.getString(8);
            
       }
                
            
            con.close();
        return dbData_Cart;              
   }
   catch(Exception e){ e.getMessage(); }
       return dbData_Cart;
    }

    public int dbLogicBuyFoodBalance(String[] dbData) {
    
        PreparedStatement ps = null;
        /*
        dbData[0] = SessionArray[0]; //username
            dbData[1] = SessionArray[2]; //enrollno.
            dbData[2] = String.valueOf(sum);*/
        
        
                try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
        
            String str_query="UPDATE user_details SET usr_balance= '"+dbData[2]+"' WHERE usr_enroll = '"+dbData[1]+"';";
            ps=con.prepareStatement(str_query);          
            int i = ps.executeUpdate(); 
            if(i>0)  
                return 1; 
            else  
                return 0;
        } catch(Exception e)
        {   e.getMessage(); }
return 0;        
   }

    public int dbLogicUpdateStock(String[] dbData) {
         PreparedStatement ps = null;
         
         int stock = Integer.valueOf(dbData[3]);
         int quan = Integer.valueOf(dbData[2]);
         
        
                try{            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
        
            //String str_query="UPDATE menu_all SET STOCK_AVAIL=STOCK_AVAIL-"+quan+" & DDT_STOCK_CHNG = '"+dbData[0]+"'WHERE CODE = '"+dbData[1]+"';";
            String str_query="UPDATE menu_all SET STOCK_AVAIL=STOCK_AVAIL-"+quan+" WHERE CODE = '"+dbData[1]+"';";
            
            ps=con.prepareStatement(str_query);          
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

    public String[] dbLogicFetchFRCart(String[] dbData) {
        String[] dbData_Cart = new String[10];
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            Statement stmt=con.createStatement();  
            
            String str_query = "SELECT code, quantity FROM cart_temp WHERE usr_enroll = "+dbData[1]+"; ";
             ResultSet rs=stmt.executeQuery(str_query);  
            
            int resultCount=0;
            while(rs.next()){ 
                resultCount++;
            //System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
            
            dbData_Cart[0] =rs.getString(1);
            dbData_Cart[1] =rs.getString(2);
            dbData_Cart[2] =rs.getString(3);
            dbData_Cart[3] =rs.getString(4);
            dbData_Cart[4] =rs.getString(5);
            dbData_Cart[5] =rs.getString(6);
            dbData_Cart[6] =rs.getString(7);
            dbData_Cart[7] =rs.getString(8);
            
       }
        con.close();
        return dbData_Cart;              
   }
   catch(Exception e){ e.getMessage(); }
       return dbData_Cart;
    
    }
public int dbLogicDeleteCart(String[] dbData) {
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
            com.mysql.jdbc.Statement stmt=(com.mysql.jdbc.Statement) con.createStatement();  
            String query="Delete from cart_temp WHERE usr_enroll = '"+dbData[2]+"';";
            int i = stmt.executeUpdate(query);
            // = ps.executeUpdate(); 
            if(i>0)  
                return 1; 
            else  
                return 0;
        } catch(Exception e)
        {   e.getMessage(); }
return 0;   
}

    public int dbLogicsUpdateUserDetail(String[] newRowData) {
    try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mess","root","dimpy00");
                Statement stmt=(Statement) con.createStatement();

                String str= "UPDATE user_details SET "+newRowData[0]+"='"+newRowData[1]+"' WHERE usr_enroll = '"+newRowData[2]+"';  ";
                con.prepareStatement(str);
                int i = stmt.executeUpdate(str);    
                if(i>0)
                    return 1;
                else
                    return 0;
                
        } catch(ClassNotFoundException | SQLException e)
            {   e.getMessage(); }
    return 0;}
}