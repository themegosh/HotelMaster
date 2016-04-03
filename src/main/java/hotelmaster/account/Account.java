
package hotelmaster.account;

/**
 *
 * @author mathe_000
 */
public class Account {
    int id;
    String email;  
    String firstName;
    String lastName;
    String password;
    String facebookId;
    
    //TODO deal with Hashing the password, and class access to that info
    
    public Account(){
        
    }
    
    public Account(int id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public Account(int id, String firstName, String lastName, String email, String password, String facebookId){
        this(id, firstName, lastName, email, password);
        this.facebookId = facebookId;
    }
    
    public void changePassword(String oldPass, String newPass){
        ///todo
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
    
    
    
}
