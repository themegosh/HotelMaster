package hotelmaster.admin.reports;

import hotelmaster.Report;
import java.io.IOException;
import java.util.List;
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
    
    @RequestMapping(value = "/reports")
    public ModelAndView listBookings(ModelAndView model) throws IOException {
        
        ReportForm reportForm = new ReportForm();
        
        model.addObject("reportForm", reportForm);
        model.setViewName("reports");
               
        return model;
    }
    
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public ModelAndView listRoom(@ModelAttribute("reportForm") ReportForm reportForm, ModelAndView model) throws IOException {
        
        List<Report> report = bookingsDAO.listBookings(reportForm.getCheckInDate(), reportForm.getCheckOutDate(), reportForm.getLowerPricePerNight(), reportForm.getUpperPricePerNight(), reportForm.getFloor());
        
        double total = 0;
        
        for (Report r : report){
            total += Double.parseDouble(r.getTotalPrice());
        }
        
        model.addObject("total", total);
        model.addObject("report", report);
        model.addObject("reportForm", reportForm);
        model.setViewName("reports");
               
        return model;
    }
}
