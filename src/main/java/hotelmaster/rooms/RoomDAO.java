package hotelmaster.rooms;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;

import hotelmaster.Room;

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
    
}
