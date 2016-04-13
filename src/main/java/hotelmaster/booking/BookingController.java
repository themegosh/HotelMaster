/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking;

import hotelmaster.Booking;
import hotelmaster.Room;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import hotelmaster.rooms.RoomDAO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class BookingController {
    
    @Autowired
    private BookingDAO bookingDAO;
    
    @Autowired
    private RoomDAO roomDAO;
    
    @Autowired
    private BookingSession bookingSession;
    
    @Autowired
    private NotificationService notificationService;
    
    
    
    @RequestMapping(value="{roomViewURL}/book", method = RequestMethod.GET)
    public ModelAndView noAccess(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        
        if (bookingSession.getBooking()== null) {
            notificationService.add("Error: ", "Please try booking a room first", NotificationType.ERROR);
            return new ModelAndView("redirect:/home", "notificationService", notificationService);
        }
        
        Booking booking = bookingSession.getBooking();
        
        Room room = roomDAO.getByURL(roomViewURL);
        modelAndView.addObject("room", room);
        
        System.out.println("Booking: " + booking.getBookingDate());
        //Set Variables        
        booking.setBookingDate(booking.getBookingDate());
        booking.setStartDate(booking.getStartDate());
        booking.setEndDate(booking.getEndDate());
        booking.setNumGuests(booking.getNumGuests());
        booking.setNumNights(booking.getStartDate(), booking.getEndDate());
        
        System.out.println("Room: " + booking.getRoomID());
        
        //Total Cost
        double getCost = booking.getNumNights() * room.getPricePerNight();
        String roundedCost = String.format("%.2f", getCost);
        double totalCost = Double.parseDouble(roundedCost);
        
        booking.setTotalCost(totalCost);        
        modelAndView.setViewName("book");
        
        return modelAndView;
    }
    
    
    @RequestMapping(value="{roomViewURL}/book", method = RequestMethod.POST)
    public ModelAndView bookRoom(@PathVariable String roomViewURL, @ModelAttribute("booking") @Valid Booking booking,  BindingResult result, HttpServletRequest htrequest, Errors errors){
        ModelAndView modelAndView = new ModelAndView("book");
        
        //Room
        Room room = roomDAO.getByURL(roomViewURL);
        modelAndView.addObject("room", room);
        
        System.out.println("Booking: " + booking.getBookingDate());
        //Set Variables        
        booking.setBookingDate(booking.getBookingDate());
        booking.setStartDate(booking.getStartDate());
        booking.setEndDate(booking.getEndDate());
        booking.setNumGuests(booking.getNumGuests());
        booking.setNumNights(booking.getStartDate(), booking.getEndDate());
        
        System.out.println("Room: " + booking.getRoomID());
        
        //Total Cost
        double getCost = booking.getNumNights() * room.getPricePerNight();
        String roundedCost = String.format("%.2f", getCost);
        double totalCost = Double.parseDouble(roundedCost);
        
        booking.setTotalCost(totalCost);        
        modelAndView.setViewName("book");
        
        bookingSession.setBooking(booking);
        
        return modelAndView;
        
    }   
    
}
