/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import hotelmaster.rooms.Room;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Doug
 */

@Primary
@Repository
public class AccountsDaoImpl implements AccountsDao {
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    
    private Logger logger = LoggerFactory.getLogger(AccountsDaoImpl.class);
       
    @Override
    public int insertAccount(Account account) {
        String inserQuery = "INSERT INTO account (first_name, last_name, email, password, facebook_id, gender) VALUES (?, ?, ?, ?, ?, ?) ";
        Object[] params = new Object[] { account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword(), account.getFacebookId(), account.getGender() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        return jdbcTemplate.update(inserQuery, params, types);
    }
    
    @Override
    public int updateAccountByFacebook(JSONObject fb){
        
        String inserQuery = "UPDATE account SET first_name = ?, last_name = ?, email = ?, gender = ? WHERE facebook_id = ? ";
        Object[] params = new Object[] { fb.getString("first_name"), fb.getString("last_name"), fb.getString("email"), fb.getString("gender"), fb.getString("id") };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
                
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        return jdbcTemplate.update(inserQuery, params, types);
    }
    
    @Override
    public int updateAccountByEmail(Account account){
        
        String inserQuery = "UPDATE account SET first_name = ?, last_name = ?, email = ?, password = ?, facebook_id = ?, gender = ? values (?, ?, ?, ?, ?, ?) ";
        Object[] params = new Object[] { account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword(), account.getFacebookId(), account.getGender() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
                
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        return jdbcTemplate.update(inserQuery, params, types);
    }
    
    @Override
    public void deleteAccount(int id){
        
    }
    
    @Override
    public Account selectAccountByEmail(String email){
        Account account = null;
        String selectQuery = "SELECT * FROM account WHERE email = ? ";
        Object[] params = new Object[] { email };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            account = (Account) jdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
        }
        catch (Exception e) {
            logger.debug(e.toString());
            System.out.println(e.toString());
            return account;
        }
        return account; 
    }
    
    @Override
    public Account selectAccountByFBId(String fbId) {
        
        Account account = null;
        String selectQuery = "SELECT * FROM account WHERE facebook_id = ? ";
        Object[] params = new Object[] { fbId };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            account = (Account) jdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
        }
        catch (Exception e) {
            logger.debug(e.toString());
            System.out.println(e.toString());
            return account;
        }
        return account; 
    }
    
}
