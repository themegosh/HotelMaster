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
    
    @RequestMapping(value="{roomViewURL}/booking", method = RequestMethod.GET)
    public ModelAndView showRoomsDirectory(@PathVariable String roomViewURL){ //@RequestParam("roomViewURL") String URL
        ModelAndView modelAndView = new ModelAndView("booking");
               
        //List<Room> roomList = roomDAO.list();
        
//        String URL = roomViewURL;
//        System.out.println(URL);
//        
//        for(int i = 0; i < roomList.size(); i++){
//            if(roomList.get(i).getRoomViewURL().equalsIgnoreCase(URL)){
//                System.out.println("Found URL: " + roomList.get(i).getRoomViewURL());
//                Room room = new Room();
//                modelAndView.addObject("room", roomList.get(i));
//                modelAndView.setViewName("roomView");
//            }
//        }
        
        Booking bkng = new Booking();
        bkng.setAccount_id(777);
        modelAndView.addObject("bkng", bkng);
        modelAndView.setViewName("booking");
        
        return modelAndView;
        
    }
    
    
    
}
