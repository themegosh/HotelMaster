
package hotelmaster.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe_000
 */
public abstract class Account {
    protected int id;
    @NotNull
    @Size(min=1, max = 75)
    protected String firstName;
    @NotNull
    @Size(min=1, max = 75)
    protected String lastName;
    @NotNull
    @Email
    protected String email;
    @NotNull
    @Size(min=1, max = 75)
    protected String password;
    protected String facebookId;
    protected String gender;
    
    public Account() { }
    
    public Account(int id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    public abstract int getId();

    public abstract void setId(int id);
    
    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);

    public abstract String getPassword();

    public abstract void setPassword(String password);

    public abstract String getFacebookId();

    public abstract void setFacebookId(String facebookId);

    public abstract String getGender();

    public abstract void setGender(String gender);
    
    public abstract String getProfilePicUrl();
    
    @Override
    public abstract String toString();
    
}
