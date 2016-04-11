package hotelmaster.rooms;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import hotelmaster.Room;
import hotelmaster.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

//Author - Danny Ardona

@Component
public class RoomDAO implements RoomDAOInterface {

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
    
    /**
     * Inserts a room into the database. Note that the room name is a unique field in the database.
     * @param room - The room to be inserted
     * @return - The number of rows affected
     */
    @Override
    public int insertRoom(Room room) {
        jdbcTemplate.setDataSource(getDataSource());
        
        String insertQuery = "INSERT INTO room (room_name, floor, price_per_night, max_guests) VALUES (?, ?, ?, ?)";
        Object[] params = new Object[]{room.getRoomName(), room.getFloor(), room.getPricePerNight(), room.getMaxGuests()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DECIMAL, Types.INTEGER};
        
        return jdbcTemplate.update(insertQuery, params, types);
    }

    /**
     * Deletes the room with the specified room_name in the database. 
     * @param roomName - The name of the room to be deleted
     */
    
    @Override
    public void deleteRoom(Room room) {
        jdbcTemplate.setDataSource(getDataSource());
        
        String deleteQuery = "DELETE FROM room_features WHERE room_ID = " + room.getRoomID();
        jdbcTemplate.update(deleteQuery);
        deleteQuery = "DELETE FROM room WHERE room_ID = " + room.getRoomID();    
        jdbcTemplate.update(deleteQuery);
    }

    /**
     * 
     * @param room - The room object that the database entry will be changed to
     * @param newRoomName - The new name of the room (optional change)
     * @return - The number of rows affected
     */
    
    @Override
    public int updateRoom(Room room) {
        jdbcTemplate.setDataSource(getDataSource());
        
        String updateQuery = "UPDATE room SET room_name = ?, floor = ?, price_per_night = ?, max_guests = ? WHERE room_id = ?";
        Object[] params = new Object[]{room.getRoomName(), room.getFloor(), room.getPricePerNight(), room.getMaxGuests(), room.getRoomID()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DECIMAL, Types.INTEGER, Types.VARCHAR};
     
        return jdbcTemplate.update(updateQuery, params, types);
    }

    /**
     * Queries the database to retrieve all data in the room table
     * @return - A List of Room objects from the database
     */
    
    @Override
    public List<Room> list() {
        jdbcTemplate.setDataSource(getDataSource());
        
        String query = "SELECT * FROM room";
        
        List<Room> roomList = jdbcTemplate.query(query, new RowMapper<Room>() {
            
            @Override
            public Room mapRow(ResultSet rs, int i) throws SQLException {
                Room room = new Room();
                
                room.setRoomID(rs.getInt("room_id"));
                room.setRoomName(rs.getString("room_name"));
                room.setFloor(rs.getString("floor"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setMaxGuests(rs.getInt("max_guests"));
                
                return room;
            }
        });
        
        return roomList;
    }

    @Override
    public void setRoomFeatures(List<Room> rooms) {
        for (final Room room : rooms){
            final HashMap<String, Boolean> features = new HashMap<String, Boolean>();
            features.put("Balcony", Boolean.FALSE);
            features.put("Breakfast in Bed", Boolean.FALSE);
            features.put("Jacuzzi", Boolean.FALSE);
            features.put("Netflix Enabled TV", Boolean.FALSE);
            features.put("Open Bar", Boolean.FALSE);
            features.put("Room Service", Boolean.FALSE);
            features.put("Wifi", Boolean.FALSE);
            
            String query = "SELECT feature_name FROM features f JOIN room_features rf ON f.feature_id = rf.feature_id WHERE room_id = " + room.getRoomID();
            
            jdbcTemplate.query(query, new RowMapper<Object>(){
                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    features.put(rs.getString("feature_name"), Boolean.TRUE);  
                    
                    return null; 
                }
            });
            
            room.setFeatures(features);
        }   
    }
    
    @Override 
    public void addRoomFeatures(Room room){
        jdbcTemplate.setDataSource(getDataSource());

        HashMap<String, Boolean> features = room.getFeatures();
        
        String deleteQuery = "DELETE FROM room_features WHERE room_id = " + room.getRoomID();
        jdbcTemplate.update(deleteQuery);
        
        if (!features.isEmpty()){
            Iterator iterator = features.entrySet().iterator();

            for (String key : features.keySet()){
                Map.Entry pair = (Map.Entry) iterator.next();

                if (features.get(key)){
                    System.out.println("Keys: " + key);
                    String insertQuery = "INSERT INTO room_features (room_id, feature_id) VALUES (?, (SELECT feature_id FROM features WHERE feature_name = ?))";
                    Object[] params = new Object[]{room.getRoomID(), key.split("=")[0]};
                    int[] types = new int[]{Types.INTEGER, Types.VARCHAR};

                    jdbcTemplate.update(insertQuery, params, types);
                }
            }
        }
        
//        for (String feature : features){
//            String insertQuery = "INSERT INTO room_features (room_id, feature_id) VALUES (?, (SELECT feature_id FROM features WHERE feature_name = ?))";
//            Object[] params = new Object[]{room.getRoomID(), feature};
//            int[] types = new int[]{Types.INTEGER, Types.VARCHAR};
//        
//            jdbcTemplate.update(insertQuery);
//        }
        
    }
    
    @Override
    public List<String> listFeatures() {
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
    
    /**
     * Queries the database for a particular room
     * @param roomName - The name of the room to be retrieved from the database
     * @return - An object representing a row in the room table
     */
    
    @Override
    public Room get(String roomName) {
        jdbcTemplate.setDataSource(getDataSource());
        
        String query = "SELECT * FROM room WHERE room_name = '" + roomName + "'";
        
        return jdbcTemplate.query(query, new ResultSetExtractor<Room>() {
 
        @Override
        public Room extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("room_id"));
                room.setRoomName(rs.getString("room_name"));
                room.setFloor(rs.getString("floor"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setMaxGuests(rs.getInt("max_guests"));

                return room;
            }
 
            return null;
        }
 
    });
        
    }
    
    
    /* ====== SEARCH FORM ====== */
    
    public List<Room> roomSearch(String sdate, String edate, int numOfGuests) {
        jdbcTemplate.setDataSource(getDataSource());
        
        System.out.println(sdate);
        System.out.println(edate);        
        
        String query = "SELECT * FROM room WHERE max_guests >= ? AND room_id NOT IN (SELECT room_id FROM booking WHERE check_in_date >= ? AND check_out_date <= ?)";
        Object[] params = new Object[] { numOfGuests, sdate, edate };
        int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR };

        List<Room> roomList = jdbcTemplate.query(query, params, types, new RowMapper<Room>() {
            
            @Override
            public Room mapRow(ResultSet rs, int i) throws SQLException {
                Room room = new Room();
                
                room.setRoomID(rs.getInt("room_id"));
                room.setRoomName(rs.getString("room_name"));
                room.setFloor(rs.getString("floor"));
                room.setPricePerNight(rs.getDouble("price_per_night"));
                room.setMaxGuests(rs.getInt("max_guests"));
                
                System.out.println("roomSearch");
                return room;
            }
        });
        
        return roomList;
    }

    @Override
    public int getMaxRoomID() {
        String query = "SELECT MAX(room_id) FROM room";
        
        List<String> roomList = jdbcTemplate.query(query, new RowMapper<String>() {
            
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getString(1);
            }
        });
        
        return Integer.parseInt(roomList.get(0));
    }
   
}
