
package hotelmaster.account;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe_000
 */
@Component
public class Account {
    private int id;
    private String email;  
    private String firstName;
    private String lastName;
    private String password;
    private String facebookId;
    private String gender;
    
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getProfilePicUrl(){
        String url = "";
        if (!facebookId.isEmpty())
            url = "https://graph.facebook.com/" + facebookId + "/picture";
        else
            url = "/resources/img/user_placeholder.png";
        return url;
    }
    
    @Override
    public String toString(){
        return "[Account] id: " + id + " firstName: " + firstName + " lastName " + lastName + " email " + email + " gender " + gender;
    }
    
}
