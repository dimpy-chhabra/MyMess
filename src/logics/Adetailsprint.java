/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import dbmanage.ConnectLogicAdmin;

/**
 *
 * @author Dell
 */
public class Adetailsprint {

    ConnectLogicAdmin obj = new ConnectLogicAdmin(); //Global Object
        
    public String[] GetDetails(String Data) {
        System.out.println("  Adetailsprint : GetDetails :Reach_notify "+Data);
        String[] ret = obj.dbLogicFetchDetails(Data);
        return ret;    
       }

    public int AddMenuItem(String[] newData) {
        System.out.println("  Adetailsprint : GetDetails :Reach_notify "+newData[2]);
        int ret = obj.dbLogicAddMenuItem(newData);
        return ret;   
    }
    
    public int UpdateMenuItem(String[] newRow){
        System.out.println(" ADetailsprint : Update Menu : Reach_notify "+newRow[1]);
        int ret = obj.dbLogicsUpdateStock(newRow);
        return ret;
    }

    public int RemoveMenuItem(String[] newRow) {
        System.out.println(" ADetailsprint : Remove Menu Item : Reach_notify "+newRow[1]);
        int ret = obj.dbLogicsRemoveMenuItem(newRow);
        return ret;
    }

    
    
}
