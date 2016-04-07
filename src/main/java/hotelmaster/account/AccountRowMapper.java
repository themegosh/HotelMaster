/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Doug
 */
public class AccountRowMapper implements RowMapper{
        
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account;
        
        if (rs.getInt("account_level") == 0)
            account = new User();
        else
            account = new Admin();
        
        account.setId(rs.getInt("account_id"));
        account.setFirstName(rs.getString("first_name"));
        account.setLastName(rs.getString("last_name"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));
        account.setFacebookId(rs.getString("facebook_id"));
        account.setGender(rs.getString("gender"));
        
        return account;
    }
}
