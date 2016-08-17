/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;
import dbmanage.ConnectLogic;


/**
 *
 * @author Dell
 */
public class Udetailsprint {
        ConnectLogic obj = new ConnectLogic(); //Global Object
        
        public String[] GetDetails(String[] dbData) {
        System.out.println("  Udetailsprint : GetDetails :Reach_notify ");
        String[] ret = obj.dbLogicFetchDetails(dbData);
        //System.out.println(" Udetailsprint : Get Details : Data_received from ConnectLogic "+ret[2]);
        return ret;    
    
    }
        public String RechargeGetBal(String[] dbData) {
        System.out.println("  Udetailsprint : RechargeGetBal :Reach_notify ");
        String[] ret = obj.dbLogicFetchDetails(dbData);
        String retn = ret[10];
        //System.out.println(" Udetailsprint : Get Details : Data_received from ConnectLogic "+ret[2]);
        return retn;    
        
    }
        
        public int RechargeAccount (String[] x){
            System.out.println("Logics : Udetailsprint : RechargeAccount : rech-notify");
           //System.out.println(" Udetailsprint : RechargeAccouny : Data_received from ConnectLogic ---->"+x[0]+" & --->  "+x[1]);
           int ret = obj.RechargeMoney(x);
           //System.out.println(" Udetailsprint : RechargeAccouny : Data_received from ConnectLogic "+ret);
        
            return ret;
            
    }
        
        public int UpdateUserDetails(String[] newRowData) {
            
        System.out.println(" UDetailsprint : Update User Detail : Reach_notify "+newRowData[1]);
        
        int ret = obj.dbLogicsUpdateUserDetail(newRowData);
        return ret;
    }



    
}
