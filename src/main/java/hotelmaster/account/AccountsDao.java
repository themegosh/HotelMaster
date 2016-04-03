/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Doug
 */
public class AccountsDao implements IAccountsDao {
    
    @Autowired
    private JdbcTemplate accountJdbcTemplate;

    public void setAccountJdbcTemplate(JdbcTemplate accountJdbcTemplate) {
        this.accountJdbcTemplate = accountJdbcTemplate;
    }
    
    @Override
    public int insertAccount(Account account) {
        String inserQuery = "insert into account (first_name, last_name, email, password, facebook_id) values (?, ?, ?, ?, ?) ";
        Object[] params = new Object[] { account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword(), account.getFacebookId() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
        
        return accountJdbcTemplate.update(inserQuery, params, types);
    }
    
    @Override
    public int updateAccount(Account account){
        return 0; //todo
    }
    
    @Override
    public void deleteAccount(int id){
        
    }
    
    @Override
    public Account selectAccount(String facebookId){
        String selectQuery = "SELECT * FROM account WHERE facebook_id = ?";
        Object[] params = new Object[] { facebookId };
        int[] types = new int[] { Types.VARCHAR };
        
        Account account = (Account) accountJdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
        
        return account; 
    }
    
}
