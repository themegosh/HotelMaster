/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking.confirm;

import hotelmaster.Booking;
import hotelmaster.account.AccountSession;
import hotelmaster.booking.BookingDAO;
import hotelmaster.booking.BookingSession;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import hotelmaster.rooms.RoomDAO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/rooms")
public class BookingConfirmController {
    
    @Autowired
    private BookingDAO bookingDAO;
    
    @Autowired
    private RoomDAO roomDAO;
    
    @Autowired
    private BookingSession bookingSession;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value="{roomViewURL}/book/confirm", method = RequestMethod.GET)
    public ModelAndView confirmBookingGet(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("bookingConfirm");
        
        if (accountSession.getAccount() == null) {
            notificationService.add("Error:", "Please login first", NotificationType.ERROR);
            return new ModelAndView("redirect:/login");
        }
        if (bookingSession.getBooking()== null) {
            notificationService.add("Error:", "Please choose a room first", NotificationType.ERROR);
            return new ModelAndView("redirect:/rooms");
        }
        
        Booking booking = bookingSession.getBooking();
        
        System.out.println("Confirm: " + booking.getBookingDate());
        //modelAndView.setViewName("redirect:unauthorized");
        booking.setAccount_id(accountSession.getAccount().getId());
        bookingDAO.insertBooking(booking);
        
        bookingSession.cancelBooking();
        modelAndView.setViewName("bookingConfirm");
        
        return modelAndView;
        
    }
    
    @RequestMapping(value="{roomViewURL}/book/confirm", method = RequestMethod.POST)
    public ModelAndView confirmBookingPost(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("bookingConfirm");
        
        if (accountSession.getAccount() == null) {
            notificationService.add("Error:", "Please login first", NotificationType.ERROR);
            return new ModelAndView("redirect:/login");
        }
        if (bookingSession.getBooking()== null) {
            notificationService.add("Error:", "Please book a room first", NotificationType.ERROR);
            return new ModelAndView("redirect:/rooms");
        }
        
        Booking booking = bookingSession.getBooking();
        
        System.out.println("Confirm: " + booking.getBookingDate());
        //modelAndView.setViewName("redirect:unauthorized");
        booking.setAccount_id(accountSession.getAccount().getId());
        bookingDAO.insertBooking(booking);
        
        bookingSession.cancelBooking();
        modelAndView.setViewName("bookingConfirm");
        return modelAndView;
        
    }
    
}
