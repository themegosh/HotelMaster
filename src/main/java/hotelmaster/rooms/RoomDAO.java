package hotelmaster.rooms;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import hotelmaster.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

//Author - Danny Ardona

public class RoomDAO implements RoomDAOInterface {

    private JdbcTemplate jdbcTemplate;
        
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * Inserts a room into the database. Note that the room name is a unique field in the database.
     * @param room - The room to be inserted
     * @return - The number of rows affected
     */
    @Override
    public int insertRoom(Room room) {
        String insertQuery = "INSERT INTO room VALUES (room_name, floor, price_per_night, max_guests) VALUES (?, ?, ?, ?)";
        Object[] params = new Object[]{room.getRoomName(), room.getFloor(), room.getPricePerNight(), room.getMaxGuests()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DECIMAL, Types.INTEGER};
        
        return jdbcTemplate.update(insertQuery, params, types);
    }

    /**
     * Deletes the room with the specified room_name in the database. 
     * @param roomName - The name of the room to be deleted
     */
    
    @Override
    public void deleteRoom(String roomName) {
        String deleteQuery = "DELETE FROM room WHERE room_name = ?";    
        int count = jdbcTemplate.update(deleteQuery, roomName, Types.VARCHAR);
        if (count > 0)
            System.out.println("Room " + roomName + " was successfully deleted");
        else
            System.out.println("Room " + roomName + " does not exist in the database");
    }

    /**
     * 
     * @param room - The room object that the database entry will be changed to
     * @param newRoomName - The new name of the room (optional change)
     * @return - The number of rows affected
     */
    
    @Override
    public int updateRoom(Room room, String newRoomName) {
        String updateQuery = "UPDATE room SET room_name = ?, floor = ?, price_per_night = ?, max_guests = ? WHERE room_name = ?";
        Object[] params = new Object[]{newRoomName, room.getFloor(), room.getPricePerNight(), room.getMaxGuests(), room.getRoomName()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DECIMAL, Types.INTEGER, Types.VARCHAR};
     
        return jdbcTemplate.update(updateQuery, params, types);
    }

    /**
     * Queries the database to retrieve all data in the room table
     * @return - A List of Room objects from the database
     */
    
    @Override
    public List<Room> list() {
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
   
}
