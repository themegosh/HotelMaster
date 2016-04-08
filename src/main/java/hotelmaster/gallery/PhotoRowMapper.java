/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import hotelmaster.account.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Trevor
 */
public class PhotoRowMapper implements RowMapper {
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Photo photo = new Photo();
        
        photo.setImageID(rs.getLong("image_id"));
        photo.setRoomID(rs.getLong("room_id"));
        photo.setImage(rs.getBytes("image"));
        photo.setTitle(rs.getString("title"));

        return photo;
    }
}
