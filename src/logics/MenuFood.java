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
public class MenuFood {
    
        ConnectLogic obj = new ConnectLogic();
        public String PrintMenu (){
            System.out.println("logics.MenuFood.PrintMenu() : reach : notify : Getting thaa menu");
            String Menu = obj.dbLogicFetchMenu();
            return Menu;
        }
        
        public String[] PrintCart (){
            System.out.println("logics.MenuFood.PrintMenu() : reach : notify : Getting thaa menu");
            String[] Menu = obj.dbLogicFetchCart();
            return Menu;
        }
        
        public int BuyFoodBalanceUpdte (String[] x){
            System.out.println("Logics : Udetailsprint : RechargeAccount : rech-notify");
            int ret = obj.dbLogicBuyFoodBalance(x);
           //System.out.println(" Udetailsprint : RechargeAccouny : Data_received from ConnectLogic "+ret);
        
            return ret;
        }
        
        public int UpdateStock (String[] dbData){
            System.out.println("Logics.MenuFood.UpdateStock reached: ablh blah");
            int ret = obj.dbLogicUpdateStock(dbData);
            
            return ret;
        }

        public String[] FetchCartData(String[] dbData) {
        System.out.println("Logics.MenuFood.UpdateStock reached: ablh blah");
            String[] ret = obj.dbLogicFetchFRCart(dbData);
            
            return ret;
        }
        
        public int DeleteCart(String[] dbData){
        System.out.println("Logics.MenuFood.UpdateStock reached: ablh blah");
        int ret = obj.dbLogicDeleteCart(dbData);
        return ret;
        }

}
