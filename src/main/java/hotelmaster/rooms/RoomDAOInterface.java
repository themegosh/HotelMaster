package hotelmaster.rooms;

import hotelmaster.Room;
import java.util.List;

//Author - Danny Ardona

public interface RoomDAOInterface {    
    int insertRoom(Room room);
    int updateRoom(Room room, String newRoomName);
    void deleteRoom(String roomName);
    List<Room> list();
    Room get(String roomName);
}
