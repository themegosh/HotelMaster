package hotelmaster.admin.reports;

import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 *
 * @author Danny
 */

@Component
public class ReportForm {
    @NotNull
    private String checkInDate;
    @NotNull
    private String checkOutDate;
    @NotNull
    private double lowerPricePerNight;
    @NotNull
    private double upperPricePerNight;
    @NotNull
    private String floor;

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getLowerPricePerNight() {
        return lowerPricePerNight;
    }

    public void setLowerPricePerNight(double lowerPricePerNight) {
        this.lowerPricePerNight = lowerPricePerNight;
    }

    public double getUpperPricePerNight() {
        return upperPricePerNight;
    }

    public void setUpperPricePerNight(double upperPricePerNight) {
        this.upperPricePerNight = upperPricePerNight;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    
}