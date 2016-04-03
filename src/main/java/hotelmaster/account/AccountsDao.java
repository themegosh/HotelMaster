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
    int insertAccount(Account account);
    void deleteAccount(int id);
    Account selectAccountByEmail(String email);
    Account selectAccountByFBId(String fbId);
    int updateAccountByFacebook(JSONObject fb);
    int updateAccountByEmail(Account account);
}
