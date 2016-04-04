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
    
    @Autowired
    Account accountSession;
  
    public void loginFacebook(JSONObject fb) throws Exception {
        
        ApplicationContext appContext = new ApplicationContextProvider().getApplicationContext();
        AccountsDao accountsDao = (AccountsDao) appContext.getBean("AccountsDao");
        accountSession = (Account) appContext.getBean("account");
                
        //try to find the account by the facebook id
        if (accountsDao.selectAccountByFBId(fb.getString("id"))){
            //we found it
            //update their facebook details
            accountsDao.updateAccountByFacebook(fb);
        } else {
            //we have a new user
            if (!fb.isNull("id"))
                accountSession.setFacebookId(fb.getString("id"));
            if (!fb.isNull("first_name"))
                accountSession.setFirstName(fb.getString("first_name"));
            if (!fb.isNull("last_name"))
                accountSession.setLastName(fb.getString("last_name"));
            if (!fb.isNull("email"))
                accountSession.setEmail(fb.getString("email"));
            if (!fb.isNull("gender"))
                accountSession.setGender(fb.getString("gender"));
        
            accountsDao.insertNewAccount();
        }
    }
    
    
    public void registerUser(){
        
    }
    
    public void changeUserAccess(){
        
    }
    
    public void registerAdmin(){
        
    }
}
