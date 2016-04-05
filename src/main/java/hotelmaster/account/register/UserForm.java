/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.register;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

/**
 *
 * @author Doug
 */
@Component
public class UserForm {
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

    public UserForm() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
