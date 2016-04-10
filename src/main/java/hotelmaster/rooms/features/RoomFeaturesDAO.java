package hotelmaster.rooms.features;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Danny
 */
public class RoomFeaturesDAO implements RoomFeaturesDAOInterface {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    
    public DriverManagerDataSource getDataSource(){
        
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://dmdev.ca:3306/themegos_hotel_master");
        datasource.setUsername("themegos_hotel_m");
        datasource.setPassword("A2b8rbd6%rT9");
        
        return datasource;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.setDataSource(getDataSource());
    }
    
    @Override
    public List<String> getFeatures() {
        jdbcTemplate.setDataSource(getDataSource());
        
        String query = "SELECT feature_name FROM features ORDER BY feature_name";
                   
        List<String> featureList = jdbcTemplate.query(query, new RowMapper<String>(){
           
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                String s = rs.getString("feature_name");
                
                return s;
            }
        });
        
        return featureList;
    }

    @Override
    public void editRoomFeatures(List<String> features, String roomID) {
        jdbcTemplate.setDataSource(getDataSource());

        String deleteQuery = "DELETE FROM room_features WHERE room_id = " + roomID;
        jdbcTemplate.update(deleteQuery);
        
        for (String feature : features){
            String updateQuery = "INSERT INTO room_features (room_id, feature_id) VALUES (?, "
                                + "(SELECT feature_id FROM features WHERE feature_name = ?))";
            Object[] params = new Object[]{Integer.parseInt(roomID), feature};
            int[] types = new int[]{Types.INTEGER, Types.VARCHAR};
            jdbcTemplate.update(updateQuery);
        }
    }
    
}
