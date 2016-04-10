package hotelmaster.rooms;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import hotelmaster.Room;
import hotelmaster.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        
        String deleteQuery = "DELETE FROM room WHERE room_ID = " + room.getRoomID();    
        int count = jdbcTemplate.update(deleteQuery);
        if (count > 0)
            System.out.println("Room " + room.getRoomName() + " was successfully deleted");
        else
            System.out.println("Room " + room.getRoomName() + " does not exist in the database");
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
    
    public List<Room> roomSearch(String sdate, String edate) {
        jdbcTemplate.setDataSource(getDataSource());
        
        //String query = "SELECT * FROM room";
        
        
        
        String query = "SELECT * FROM booking"
            + "WHERE check_in_date >= '" + sdate + "' AND check_out_date <='" + edate + "'"
            + ";";
        
        List<Booking> bookingList = jdbcTemplate.query(query, new RowMapper<Booking>() {
            @Override
            public Booking mapRow(ResultSet rs, int i) throws SQLException {
                Booking bkng = new Booking();
                
                bkng.setAccount_id(rs.getInt("account_id"));
                bkng.setRoom_id(rs.getInt("room_id"));
                bkng.setStartDate(rs.getDate("check_in_date"));
                bkng.setEndDate(rs.getDate("check_out_date"));
                bkng.setNumGuests(rs.getInt("num_guests"));
                
                return bkng;
            }
        });
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
   
}
