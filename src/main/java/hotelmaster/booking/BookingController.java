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
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView bookRoom(@PathVariable String roomViewURL){
        ModelAndView modelAndView = new ModelAndView("book");
                       
        List<Room> roomList = roomDAO.list();
        String URL = roomViewURL;
        System.out.println(URL);
        
        Booking bkng = new Booking();
        bkng.setAccount_id(777);
        
        for(int i = 0; i < roomList.size(); i++){
            if(roomList.get(i).getRoomViewURL().equalsIgnoreCase(URL)){
                System.out.println("Found URL: " + roomList.get(i).getRoomViewURL());
                
                //booking
                Booking booking = new Booking();
                modelAndView.addObject("booking", booking);
                
                Room room = new Room();
                modelAndView.addObject("room", roomList.get(i));
                
            modelAndView.addObject("bkng", bkng);
            modelAndView.setViewName("book");
            }
        }
        
        return modelAndView;
        
    }   
    
}
