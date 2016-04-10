/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.search;

import hotelmaster.Room;
import java.util.List;

/**
 *
 * @author Trevor
 */
public interface SearchDAOInterface {
    List<Room> getAllRooms();
}
