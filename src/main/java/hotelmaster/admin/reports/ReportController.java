package hotelmaster.admin.reports;

import hotelmaster.Report;
import hotelmaster.account.AccountLevel;
import hotelmaster.account.AccountSession;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
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
    private ReportDAO reportDAO;
    @Autowired 
    private RoomDAO roomDAO;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private AccountSession accountSession;    
    
    @RequestMapping(value = "/admin/reports")
    public ModelAndView showForm(ModelAndView model) throws IOException {
        
        if (accountSession.getAccount() == null || accountSession.getAccount().getAccountLevel() == AccountLevel.USER) {
            notificationService.add("Error!", "You do not have the required permissions to access the page", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        
        ReportForm reportForm = new ReportForm();
        TreeMap<String, String> floors = roomDAO.getFloors();

        model.addObject("floors", floors);
        model.addObject("reportForm", reportForm);
        model.setViewName("admin/reports");
        
        return model;
    }
    
    @RequestMapping(value = "/admin/reports", method = RequestMethod.POST)
    public ModelAndView listResults(@ModelAttribute("reportForm") ReportForm reportForm, ModelAndView model) throws IOException {
        
        if (accountSession.getAccount() == null || accountSession.getAccount().getAccountLevel() == AccountLevel.USER) {
            notificationService.add("Error!", "You do not have the required permissions to access the page", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        
        List<Report> report = reportDAO.listBookings(reportForm.getCheckInDate(), reportForm.getCheckOutDate(), reportForm.getLowerPricePerNight(), reportForm.getUpperPricePerNight(), reportForm.getFloor());
        TreeMap<String, String> floors = roomDAO.getFloors();
        
        double total = 0;
        
        for (Report r : report){
            
            total += Double.parseDouble(r.getTotalPrice());
        }
        
        model.addObject("floors", floors);
        model.addObject("total", String.format("%.2f", total));
        model.addObject("report", report);
        model.addObject("reportForm", reportForm);
        model.setViewName("admin/reports");
               
        return model;
    }
}
