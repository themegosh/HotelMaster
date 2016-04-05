/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import hotelmaster.util.ApplicationContextProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Doug
 */
public class AccountRowMapper implements RowMapper{
    
    @Autowired
    Account accountSession;
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account accountSession = new Account();
        
        accountSession.setId(rs.getInt("account_id"));
        accountSession.setFirstName(rs.getString("first_name"));
        accountSession.setLastName(rs.getString("last_name"));
        accountSession.setEmail(rs.getString("email"));
        accountSession.setPassword(rs.getString("password"));
        accountSession.setFacebookId(rs.getString("facebook_id"));
        accountSession.setGender(rs.getString("gender"));
        
        return accountSession;
    }
}
