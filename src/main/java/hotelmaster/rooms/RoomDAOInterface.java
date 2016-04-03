package hotelmaster.rooms;

import hotelmaster.Room;

public interface RoomDAOInterface {    
    int insertRoom(Room room);
    void deleteRoom(String roomName);
}
