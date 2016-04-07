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
public class Admin extends User {
    public Admin(int id, String firstName, String lastName, String email, String password){
        super(id, firstName, lastName, email, password);
    }
    
    public Admin(){
        super();
    }
}
