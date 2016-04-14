package hotelmaster.rooms;

import java.util.HashMap;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

/**
 *
 * @author Danny
 */
@Component
public class RoomForm {
    @NotNull
    @Size(min=1, max = 75)
    private String roomName;
    @NotNull
    @Size(min=1, max = 75)
    private String floor;
    @NotNull
    @Min(value=0)
    private double pricePerNight;
    @NotNull
    @Min(value=1)
    @Max(value=9)
    private int maxGuests;
    private HashMap<String, Boolean> features;
    private Set<String> featuresTest;
    
    public RoomForm(){
    }
    
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public HashMap<String, Boolean> getFeatures() {
        return features;
    }

    public void setFeatures(HashMap<String, Boolean> features) {
        this.features = features;
    }
    
    public Set<String> getFeaturesTest() {
        return featuresTest;
    }

    public void setFeaturesTest(Set<String> featuresTest) {
        this.featuresTest = featuresTest;
    }

    
}
