/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Doug
 */

public class AccountsDaoImpl implements AccountsDao {
    
    @Autowired
    private DataSource dataSource;
       
    @Override
    public int insertAccount(Account account) {
        String inserQuery = "insert into account (first_name, last_name, email, password, facebook_id) values (?, ?, ?, ?, ?) ";
        Object[] params = new Object[] { account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword(), account.getFacebookId() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        return jdbcTemplate.update(inserQuery, params, types);
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
        String selectQuery = "SELECT * FROM account WHERE facebook_id = ? ";
        Object[] params = new Object[] { facebookId };
        int[] types = new int[] { Types.VARCHAR };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        List<Map<String, Object>> results = jdbcTemplate.queryForList(selectQuery, facebookId); 
        
        if (results.isEmpty()){
            //we've got a new account!
        } else {
            //returning account, fill the Account Object
        }
        
        Account account = new Account();
        
        //Account account = (Account) jdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
        
        return account; 
    }
    
}
