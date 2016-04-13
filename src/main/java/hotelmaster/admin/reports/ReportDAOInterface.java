package hotelmaster.admin.reports;

import hotelmaster.Booking;
import hotelmaster.Report;
import java.util.List;

/**
 *
 * @author Danny
 */
public interface ReportDAOInterface {
    List<Report> listBookings(String checkInDate, String checkOutDate, double lowerPricePerNight, double upperPricePerNight, String floor);
}
