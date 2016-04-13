package hotelmaster.rooms;

import hotelmaster.Room;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Danny
 */

public interface RoomDAOInterface {    
    int insertRoom(Room room);
    int updateRoom(Room room);
    int getMaxRoomID();
    void deleteRoom(Room room);
    void addRoomFeatures(Room room);
    void setRoomFeatures(List<Room> rooms);
    List<Room> list();
    List<String> listFeatures();
    Room get(String roomName);
    TreeMap<String, String> getFloors();
}
