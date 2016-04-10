package hotelmaster.rooms;

import hotelmaster.Room;
import java.util.List;

//Author - Danny Ardona

public interface RoomDAOInterface {    
    int insertRoom(Room room);
    int updateRoom(Room room);
    void deleteRoom(Room room);
    List<Room> list();
    Room get(String roomName);
}
