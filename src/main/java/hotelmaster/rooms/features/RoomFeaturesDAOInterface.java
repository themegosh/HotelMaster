package hotelmaster.rooms.features;

import java.util.List;

/**
 *
 * @author Danny
 */
public interface RoomFeaturesDAOInterface {
    List<String> getFeatures();
    void editRoomFeatures(List<String> features, String roomID);
}
