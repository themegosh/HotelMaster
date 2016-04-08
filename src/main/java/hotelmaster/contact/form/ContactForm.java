/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.contact.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author GEORGE
 */
public class ContactForm {
    
    @NotNull
    @Size(min=1, max = 75)
    private String name;
    
    @NotNull
    @Email
    @Size(min=1, max = 75)
    private String email;
    
    @NotNull
    @Size(min=1, max = 75)
    private String subject;
    
    @NotNull
    @Size(min=1, max = 75)
    private String message;
    
    public ContactForm(){}
    
    public ContactForm(String name, String email){
        this.name = name;
        this.email = email;
    }
    
    public ContactForm(String name, String email, String subject, String message){
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
