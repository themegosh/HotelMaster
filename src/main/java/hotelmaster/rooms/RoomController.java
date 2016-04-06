package hotelmaster.rooms;

import hotelmaster.Room;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Author - Danny Ardona

@Controller
public class RoomController {

    @Autowired
    private RoomDAO roomDAO;
    
    @RequestMapping(value = "/room")
    public ModelAndView listRoom(ModelAndView model) throws IOException {
        List<Room> roomList = roomDAO.list();
        Room room = new Room();
        model.addObject("room", room);
        model.addObject("roomList", roomList);
        model.setViewName("room");
        return model;
    }
    
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ModelAndView addRoom(@ModelAttribute Room room){
        roomDAO.insertRoom(room);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/deleteRoom", method = RequestMethod.GET)
    public ModelAndView deleteRoom(HttpServletRequest request){
        String roomName = request.getParameter("roomName");
        roomDAO.deleteRoom(roomName);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/editRoom", method = RequestMethod.GET)
    public ModelAndView editRoom(HttpServletRequest request){
        String roomName = request.getParameter("roomName");
        Room room = roomDAO.get(roomName);
        roomDAO.updateRoom(room, roomName);
        
        return new ModelAndView("redirect:/");
    }
}
