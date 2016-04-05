/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import hotelmaster.util.ApplicationContextProvider;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author mathe_000
 */
public class AccountFactory {
      
    public Account loginFacebook(JSONObject fb) throws Exception {
        
        ApplicationContext appContext = new ApplicationContextProvider().getApplicationContext();
        AccountsDao accountsDao = (AccountsDao) appContext.getBean("AccountsDao");
        Account account = new Account();
                
        //try to find the account by the facebook id
        account = accountsDao.getAccountByFBId(fb.getString("id"));
        if (account.getId() > 0){
            //we found it
            //update their facebook details
            accountsDao.updateAccountByFacebook(fb);
        } else {
            //we have a new user
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
        
            account.setId(accountsDao.insertNewAccount(account)); //inserting returns the freshly generated ID
        }
        return account;
    }
    
    
    public void registerUser(){
        
    }
    
    public void changeUserAccess(){
        
    }
    
    public void registerAdmin(){
        
    }
}
