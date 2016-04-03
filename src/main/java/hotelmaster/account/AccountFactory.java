/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import hotelmaster.util.ApplicationContextProvider;
import javax.annotation.Resource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathe_000
 */
public class AccountFactory {
  
    public static Account processLogin(JSONObject fb) throws Exception {
        
        ApplicationContext appContext = new ApplicationContextProvider().getApplicationContext();
        AccountsDao accountsDao = (AccountsDao) appContext.getBean("AccountsDao");
        
        //try to find the account by the facebook id
        Account account = accountsDao.selectAccountByFBId(fb.getString("id"));
        
        //we have a new user
        if (account == null) { 
            account = AccountFactory.buildAccountFromFB(fb);
            accountsDao.insertAccount(account);
        } else { //a returning user
            //update their facebook details
            accountsDao.updateAccountByFacebook(fb);
        }
        return account;
    }
    
    
    public static void registerUser(){
        
    }
    
    public static void changeUserAccess(){
        
    }
    
    public static void registerAdmin(){
        
    }
    
    public static Account buildAccountFromFB(JSONObject fb){
        Account account = new Account();
        
        if (!fb.isNull("id"))
            account.setFacebookId(fb.getString("id"));
        if (!fb.isNull("first_name"))
            account.setFirstName(fb.getString("first_name"));
        if (!fb.isNull("last_name"))
            account.setLastName(fb.getString("last_name"));
        if (!fb.isNull("email"))
            account.setEmail(fb.getString("email"));
        if (!fb.isNull("gender"))
            account.setGender(fb.getString("gender"));
        
        return account;
    }
    
}
