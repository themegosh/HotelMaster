/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import hotelmaster.account.Account;
import java.util.Date;

/**
 *
 * @author mathe_000
 */
public class User extends Account {
    private String userId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdate;
    private String photo;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    
    public User(String email, String password){
        super(email, password);
    }
    
    public User(String uid){
        super(uid);
    }
    
    
}
