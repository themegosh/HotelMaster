/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Doug
 */
@Repository
public interface AccountsDao {
    Account insertNewAccount(Account account);
    void deleteAccount(int id);
    Account getAccountByFBId(String fbId);
    int updateAccountByFacebook(JSONObject fb);
    int updateAccountByEmail(Account account);
    Account getAccountByEmailPass(String email, String pass) throws Exception;
}
