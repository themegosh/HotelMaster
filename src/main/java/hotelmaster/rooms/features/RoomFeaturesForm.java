package hotelmaster.rooms.features;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author Danny
 */
@Component
public class RoomFeaturesForm {
    private ArrayList<String> features;

    public ArrayList<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }
    
    
}
