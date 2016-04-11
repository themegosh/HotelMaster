/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

/**
 *
 * @author Doug
 */
public enum AccountLevel {
    USER ("User"),
    ADMIN ("Admin");
    
    private String displayName;
    
    private AccountLevel(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
