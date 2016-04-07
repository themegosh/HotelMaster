/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

/**
 *
 * @author mathe_000
 */
public class User extends Account {
    
    //TODO deal with Hashing the password, and class access to that info
    
    public User(){
    }
    
    public User(int id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFacebookId() {
        return facebookId;
    }

    @Override
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
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
        return "[Account] id: " + id + " firstName: " + firstName + " lastName " + lastName + " email " + email + " gender " + gender;
    }
}
