/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    
       
    @Override
    public int insertNewAccount(Account _account) {
        
        final Account account = _account;
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        final String inserQuery = "INSERT INTO account (first_name, last_name, email, password, facebook_id, gender) VALUES (?, ?, ?, ?, ?, ?) ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
            new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(inserQuery, new String[] {"account_id"});
                    ps.setString(1, account.getFirstName());
                    ps.setString(2, account.getLastName());
                    ps.setString(3, account.getEmail());
                    ps.setString(4, account.getPassword());
                    ps.setString(5, account.getFacebookId());
                    ps.setString(6, account.getGender());
                    return ps;
                }
            },
            keyHolder);
                
        return keyHolder.getKey().intValue();
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
    public Account getAccountByFBId(String fbId) {
        Account account = new Account();
        
        String selectQuery = "SELECT * FROM account WHERE facebook_id = ? ";
        Object[] params = new Object[] { fbId };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
                        
            account = (Account) jdbcTemplate.queryForObject(selectQuery, params, new AccountRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            //e.printStackTrace();
            System.out.println("getAccountByFBId: couldnt find an account with matching FB id");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return account; 
    }
    
}
