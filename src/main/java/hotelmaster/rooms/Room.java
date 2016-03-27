package hotelmaster.rooms;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class Room implements RoomDAO {

    private Logger logger = LoggerFactory.getLogger(Room.class);
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public boolean roomExists(String roomName) {
        try {
            logger.debug("Checking Room in Room table using Spring Jdbc template");
            int result = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROOM WHERE room_name=?", Integer.class, roomName);
            if (result > 0){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
