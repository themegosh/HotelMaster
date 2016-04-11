
package hotelmaster.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe_000
 */
public class Account {
    private int id;
    @NotNull
    @Size(min=1, max = 75)
    private String firstName;
    @NotNull
    @Size(min=1, max = 75)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min=1, max = 75)
    private String password;
    private String facebookId;
    private String gender;
    private AccountLevel accountLevel;
    
    public Account() { }
        
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

    public AccountLevel getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(AccountLevel accountLevel) {
        this.accountLevel = accountLevel;
    }
    
    public boolean isAdmin(){
        return AccountLevel.ADMIN.equals(accountLevel);
    }
    
    public String getProfilePicUrl(){
        String url;
        if (facebookId != null)
            url = "https://graph.facebook.com/" + facebookId + "/picture";
        else
            url = "/resources/img/user_placeholder.png";
        return url;
    }
    
    @Override
    public String toString(){
        return "[Account] id: " + id + " firstName: " + firstName + " lastName " + lastName + " email " + email + " pass " + password + " gender " + gender + " level " + accountLevel;
    }
    
}
