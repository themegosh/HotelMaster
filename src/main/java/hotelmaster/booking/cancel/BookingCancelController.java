/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking.cancel;

import hotelmaster.Booking;
import hotelmaster.account.AccountSession;
import hotelmaster.booking.BookingSession;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author GEORGE
 */

@Controller
@RequestMapping("/rooms")
public class BookingCancelController {
    
    @Autowired
    private BookingSession bookingSession;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value="{roomViewURL}/book/cancel", method = RequestMethod.GET)
    public ModelAndView cancelBooking(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("cancel");
        
//        if (accountSession.getAccount() == null) {
//            notificationService.add("Error:", "Please login first", NotificationType.ERROR);
//            return new ModelAndView("redirect:/login");
//        }
        if (bookingSession.getBooking()== null) {
            notificationService.add("Error:", "Please choose a room first", NotificationType.ERROR);
            return new ModelAndView("redirect:/rooms");
        } else {
        
            bookingSession.cancelBooking();

            modelAndView.setViewName("redirect:/home");

            notificationService.add("Hey!", "Your Booking Has Been Cancelled", NotificationType.SUCCESS);
            return modelAndView;
        }
        
    }
    
}
