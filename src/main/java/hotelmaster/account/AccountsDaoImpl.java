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
    
    @Autowired
    Account accountSession;
       
    @Override
    public int insertNewAccount() {
        String inserQuery = "INSERT INTO account (first_name, last_name, email, password, facebook_id, gender) VALUES (?, ?, ?, ?, ?, ?) ";
        Object[] params = new Object[] { accountSession.getFirstName(), accountSession.getLastName(), accountSession.getEmail(), accountSession.getPassword(), accountSession.getFacebookId(), accountSession.getGender() };
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
    public boolean selectAccountByFBId(String fbId) {
        boolean foundAccount = false;
        
        String selectQuery = "SELECT * FROM account WHERE facebook_id = ? ";
        Object[] params = new Object[] { fbId };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            accountSession = (Account) jdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
            foundAccount = true;
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.toString());
        }
        return foundAccount; 
    }
    
}
