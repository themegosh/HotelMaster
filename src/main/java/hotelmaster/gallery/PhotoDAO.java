/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import hotelmaster.Room;
import hotelmaster.account.Account;
import hotelmaster.account.AccountRowMapper;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    public List<Photo> getAllPhotos() {        
            
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            String query = "SELECT * FROM room_images";

            List<Photo> photoList = jdbcTemplate.query(query, new RowMapper<Photo>() {

                @Override
                public Photo mapRow(ResultSet rs, int i) throws SQLException {
                    Photo photo = new Photo();

                    photo.setImageID(rs.getInt("image_id"));
                    photo.setRoomID(rs.getInt("room_id"));
                    photo.setImage(rs.getBytes("image"));
                    photo.setTitle(rs.getNString("title"));

                    return photo;
                }
            });

        //return list to be used by controller
        return photoList;
    }

    @Override
    public Photo getPhotoByID(int id) {
        Photo photo = new Photo();
        
        String selectQuery = "SELECT * FROM room_images WHERE image_id = ?";
        Object[] params = new Object[] { id };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            photo = (Photo) jdbcTemplate.queryForObject(selectQuery, params, new PhotoRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            //e.printStackTrace();
            System.out.println("can't find photo");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        return photo;
    }
    
    
    @Override
    public Photo getPhotoByRoomID(int roomID) {
        Photo photo = new Photo();
        
        String selectQuery = "SELECT * FROM room_images WHERE room_id = ?";
        Object[] params = new Object[] { roomID };
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            photo = (Photo) jdbcTemplate.queryForObject(selectQuery, params, new PhotoRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            //e.printStackTrace();
            System.out.println("can't find photo");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        return photo;
    }
    
    @Override
    public Photo insertPhoto(int roomID, byte[] image, String title) {
        
        Photo photo = new Photo();
        
        String insertQuery = "INSERT INTO room_images (room_id, image, title) VALUES (?, ?, ?)";
        Object[] params = new Object[]{photo.getRoomID(), photo.getImage(), photo.getTitle()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DECIMAL, Types.INTEGER};
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
        
        try {
            photo = (Photo) jdbcTemplate.queryForObject(insertQuery, params, new PhotoRowMapper());
        }
        catch (EmptyResultDataAccessException e){
            //e.printStackTrace();
            System.out.println("can't find photo");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        return photo;
    }
    
}
