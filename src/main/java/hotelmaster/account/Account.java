
package hotelmaster.account;

/**
 *
 * @author mathe_000
 */
public abstract class Account {
    String email;  
    
    public Account(String email, String password){
        this.email = email;
        //attempt to login
    }
    
    
    public Account(String uid){
        //query the DB for uid, filling email and password
    }
    
    public void changePassword(String oldPass, String newPass){
     
        //Testing Git Hub Here
     //hi
        
        //toast
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
