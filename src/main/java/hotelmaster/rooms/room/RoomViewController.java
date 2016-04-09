/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.rooms.room;

import hotelmaster.Room;
import hotelmaster.rooms.RoomDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class RoomViewController {
    
    @Autowired
    private RoomDAO roomDAO;
    
    @RequestMapping(value="{roomViewURL}", method = RequestMethod.GET)
    public ModelAndView showRoomsDirectory(@RequestParam("roomViewURL") String URL){
        ModelAndView modelAndView = new ModelAndView("roomView");
               
        List<Room> roomList = roomDAO.list();
        
        for(int i = 0; i < roomList.size(); i++){
            if(roomList.get(i).getRoomViewURL().equalsIgnoreCase(URL)){
                Room room = new Room();
                modelAndView.addObject("room", room);
                modelAndView.setViewName("roomView");
            }
        }
        
        
        return modelAndView;
        
    }   
    
}
