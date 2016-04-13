package hotelmaster.admin.reports;

import hotelmaster.Report;
import hotelmaster.rooms.RoomDAO;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Danny
 */

@Controller
public class ReportController {
    
    @Autowired
    private BookingsDAO bookingsDAO;
    @Autowired //Might have to make the roomDAO in RoomController public and access it somehow
    private RoomDAO roomDAO;
        
    @RequestMapping(value = "/reports")
    public ModelAndView showForm(ModelAndView model) throws IOException {
        
        ReportForm reportForm = new ReportForm();
        TreeMap<String, String> floors = roomDAO.getFloors();

        model.addObject("floors", floors);
        model.addObject("reportForm", reportForm);
        model.setViewName("reports");
        
        return model;
    }
    
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public ModelAndView listResults(@ModelAttribute("reportForm") ReportForm reportForm, ModelAndView model) throws IOException {
        
        List<Report> report = bookingsDAO.listBookings(reportForm.getCheckInDate(), reportForm.getCheckOutDate(), reportForm.getLowerPricePerNight(), reportForm.getUpperPricePerNight(), reportForm.getFloor());
        TreeMap<String, String> floors = roomDAO.getFloors();
        
        double total = 0;
        
        for (Report r : report){
            total += Double.parseDouble(r.getTotalPrice());
        }
        
        model.addObject("floors", floors);
        model.addObject("total", total);
        model.addObject("report", report);
        model.addObject("reportForm", reportForm);
        model.setViewName("reports");
               
        return model;
    }
}
