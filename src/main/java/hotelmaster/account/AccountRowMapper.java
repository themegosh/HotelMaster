/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Doug
 */
public class AccountRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("account_id"));
        account.setFirstName(rs.getString("first_name"));
        account.setLastName(rs.getString("last_name"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));
        account.setFacebookId(rs.getString("facebook_id"));
        
        return account;
    }
}
