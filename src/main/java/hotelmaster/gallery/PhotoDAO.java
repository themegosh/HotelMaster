/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Trevor
 */
@Primary
@Repository
public class PhotoDAO implements PhotoDAOInterface {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    
    @Override
    public List<Photo> list() {        
        String query = "SELECT * FROM room_images WHERE room_id = ?";
        String param = "2";
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        List<Photo> photoList = new ArrayList<Photo>();
        
        //map columns to photo objects
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, new Object[]{param});
        for (Map<String, Object> row : rows) {
            Photo photo = new Photo();
            photo.setImageID((Long)row.get("image_id"));
            photo.setRoomID((Long)row.get("room_id"));
            photo.setImage((byte[])row.get("image"));
            photo.setTitle((String)row.get("title"));
            photoList.add(photo);
        }
        
        //return list to be used by controller
        return photoList;
    }
    
}
