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
public interface IAccountsDao {
    int insertAccount(Account account);
    void deleteAccount(int id);
    Account selectAccount(String facebookId);
    int updateAccount(Account account);
}
