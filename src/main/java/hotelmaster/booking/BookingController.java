/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking;

import hotelmaster.Booking;
import hotelmaster.Photo;
import hotelmaster.Room;
import hotelmaster.gallery.PhotoDAO;
import hotelmaster.rooms.RoomDAO;
import hotelmaster.search.SearchParams;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value="{roomViewURL}/book", method = RequestMethod.GET)
    public ModelAndView noAccess(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        
        modelAndView.setViewName("redirect:unauthorized");
        
        return modelAndView;
        
    }
    
    @RequestMapping(value="{roomViewURL}/unauthorized", method = RequestMethod.GET)
    public ModelAndView unauthorized(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        
        modelAndView.setViewName("unauthorized");
        
        return modelAndView;
        
    }
    
    
    @RequestMapping(value="{roomViewURL}/book", method = RequestMethod.POST)
    public ModelAndView bookRoom(@PathVariable String roomViewURL, @ModelAttribute("booking") @Valid Booking booking,  BindingResult result, HttpServletRequest htrequest, Errors errors){
        ModelAndView modelAndView = new ModelAndView("book");
        
        //Room
        Room room = roomDAO.getByURL(roomViewURL);
        modelAndView.addObject("room", room);
        
        
        //Set Variables        
        booking.setStartDate(booking.getStartDate());
        booking.setEndDate(booking.getEndDate());
        booking.setNumGuests(booking.getNumGuests());
        booking.setNumNights(booking.getStartDate(), booking.getEndDate());
        
        //Total Cost
        double getCost = booking.getNumNights() * room.getPricePerNight();
        String roundedCost = String.format("%.2f", getCost);
        double totalCost = Double.parseDouble(roundedCost);
        
        booking.setTotalCost(totalCost);
                
        modelAndView.setViewName("book");
        
        return modelAndView;
        
    }   
    
}
