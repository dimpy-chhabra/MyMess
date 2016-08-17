/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;
import javax.swing.JOptionPane;
import dbmanage.ConnectLogic;

/**
 *
 * @author Dell
 */
public class Uregister {
    
//String name, surname, gender, id, pword, enroll, course, classof, dob, email, contact, roomno, secureq, securea;
    /* usr_surname  = dbData[1];
	String usr_gender  = dbData[2];
	String usr_id = dbData[3];
	String usr_pword  = dbData[4];
	String usr_enroll  = dbData[5];
	String usr_course  = dbData[6];
	String usr_classof = dbData[7];
	String usr_dob  = dbData[8];
	String usr_email = dbData[9];
	String usr_contact = dbData[10]; 
	String usr_roomno  = dbData[11];
	String usr_secureq = dbData[12];
	String usr_securea = dbData[13];
*/
     
    /**
     * @param args the command line arguments
     */
    
    public int Register(String[] dbData) {
        System.out.println("Have reached Register function "+dbData[0] + dbData[14]);
        ConnectLogic obj = new ConnectLogic();
        int ret = obj.dbLogicUregister(dbData);
        return ret;
    }
    
    public int Login(String[] dbData) {
        
        //System.out.println("Successfully reached page U.Register");
        //System.out.println("Have reached Login function "+dbData[0]);
        ConnectLogic obj = new ConnectLogic();
        int ret = obj.dbLogicLogin(dbData);
        return ret;
    } 
    
    public int FpwordValidityCheck (String[] dbData) {
        
        System.out.println("Successfully reached page U.Register : FpwordValidityCheck");
        
        ConnectLogic obj = new ConnectLogic();
        int ret = obj.dbLogicFpwordVC(dbData);
        System.out.println("HEEYY..... VALIDATION CHECK RESULT : "+ret);
        return ret;
    } 
    
    public int FpwordGenuinityCheck (String[] dbData) {
        
        System.out.println("Successfully reached page U.Register : FpwordGenuinityCheck");
    
        ConnectLogic obj = new ConnectLogic();
        int ret = obj.dbLogicFpwordGC(dbData);
        return ret;
    } 
    
    public int FpwordChangepword (String[] dbData){
        System.out.println("Successfully reached page U.Register : FpwordChangepword");
        
        ConnectLogic obj = new ConnectLogic();
        int ret = obj.dbLogicFpwordCP(dbData);
        return ret;
            
    }
    
    
    
/*    
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
*/

   
}