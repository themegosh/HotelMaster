/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
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
    
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    
    @Override
    public List<Photo> getAllPhotos() {        
            
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            String query = "SELECT * FROM room_images WHERE thumbnail = 1";

            List<Photo> photoList = jdbcTemplate.query(query, new RowMapper<Photo>() {

                @Override
                public Photo mapRow(ResultSet rs, int i) throws SQLException {
                    Photo photo = new Photo();

                    photo.setImageID(rs.getInt("image_id"));
                    photo.setRoomID(rs.getInt("room_id"));
                    photo.setImage(rs.getBytes("image"));
                    photo.setTitle(rs.getNString("title"));
                    photo.setPrimary(rs.getInt("thumbnail"));
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
    public List<Photo> getPhotosByRoomID(int roomID) {
        
        jdbcTemplate = new JdbcTemplate(dataSource);
                
        String query = "SELECT * FROM room_images WHERE room_id = " + roomID;
        
        List<Photo> photos = jdbcTemplate.query(query, new RowMapper<Photo>() {
            
            @Override
            public Photo mapRow(ResultSet rs, int i) throws SQLException {
                Photo photo = new Photo();
                
                photo.setImageID(rs.getInt("image_id"));
                photo.setTitle(rs.getString("title"));
                photo.setRoomID(rs.getInt("room_id"));
                photo.setPrimary(rs.getInt("thumbnail"));
                
                return photo;
            }
        });
        
        return photos;
    }
    
    @Override
    public int insertPhoto(Photo photo) {
        
        jdbcTemplate.setDataSource(dataSource);
        
        String query = "SELECT * FROM room_images WHERE room_id = " + photo.getRoomID();
        
        List<Photo> photos = this.getPhotosByRoomID(photo.getRoomID());
        
        String insertQuery;
        Object[] params;
        int[] types;
        
        if (photos.isEmpty()){
            insertQuery = "INSERT INTO room_images (room_id, image, title, thumbnail) VALUES (?, ?, ?, ?)";
            params = new Object[]{photo.getRoomID(), photo.getImage(), photo.getTitle(), 1};
            types = new int[]{Types.INTEGER, Types.BLOB, Types.VARCHAR, Types.INTEGER};
        } else {
            insertQuery = "INSERT INTO room_images (room_id, image, title) VALUES (?, ?, ?)";
            params = new Object[]{photo.getRoomID(), photo.getImage(), photo.getTitle()};
            types = new int[]{Types.INTEGER, Types.BLOB, Types.VARCHAR};
        }
        
        return jdbcTemplate.update(insertQuery, params, types);
    }    
    
    @Override
    public int deletePhoto(int imageID) {
        
        jdbcTemplate.setDataSource(dataSource);
        
        Photo photo = this.getPhotoByID(imageID);
        
        List<Photo> photos = this.getPhotosByRoomID(photo.getRoomID());
        
        String deleteQuery;
        Object[] params;
        int[] types;
        
        if (photos.size() <= 1){
            
            return 0;
            
        } else {
            
            int image_id = imageID;
            int tempID = 0;

            for (Photo p : photos){
                if (p.getImageID() > tempID && p.getImageID() !=  image_id){
                    tempID = p.getImageID();
                }
            }

            String updateQuery = "UPDATE room_images SET thumbnail = 1 WHERE image_id = " + tempID;
            jdbcTemplate.update(updateQuery);
            
            deleteQuery = "DELETE FROM room_images WHERE image_id = ?";
            params = new Object[]{imageID};
            types = new int[]{Types.INTEGER};
        }
        
        return jdbcTemplate.update(deleteQuery, params, types);
    }
    
    @Override
    public int setPrimaryPhoto(int imageID) {
        
        jdbcTemplate.setDataSource(dataSource);
        
        String updateQuery = "UPDATE room_images SET thumbnail = ? WHERE image_id = ?";
        Object[] params = new Object[]{1, imageID};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER};
        
        
        return jdbcTemplate.update(updateQuery, params, types);
    }
    
    @Override
    public int getCurrPrimaryPhoto(int currRoomID) {
        
        jdbcTemplate.setDataSource(dataSource);
        
        String query = "SELECT image_id FROM room_images WHERE room_id = + " + currRoomID + " AND thumbnail = 1";
        
        
        List<String> primaryPhoto = jdbcTemplate.query(query, new RowMapper<String>() {
            
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString(1);
            }
        });
        
        return Integer.parseInt(primaryPhoto.get(0));
    }
    
    @Override
    public int unsetCurrPrimaryPhoto(int imageID) {
        
        jdbcTemplate.setDataSource(dataSource);
        
        String updateQuery = "UPDATE room_images SET thumbnail = ? WHERE image_id = ?";
        Object[] params = new Object[]{0, imageID};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER};
        
        
        return jdbcTemplate.update(updateQuery, params, types);
    }
    
    

    
    
}
