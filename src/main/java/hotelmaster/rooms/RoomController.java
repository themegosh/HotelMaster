package hotelmaster.rooms;

import hotelmaster.Room;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//Author - Danny Ardona
//Create a RoomForm and inject it in the modelandview
@Controller
public class RoomController {

    @Autowired
    private RoomDAO roomDAO;
    
    @RequestMapping(value = "/room")
    public ModelAndView listRoom(ModelAndView model) throws IOException {
        List<Room> roomList = roomDAO.list();
        RoomForm rf = new RoomForm();
        //Room room = new Room();
        
        model.addObject("roomList", roomList);
        model.addObject("roomForm", new RoomForm());
        //model.addObject("room", room);
        model.setViewName("room");
               
        return model;
    }
    
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ModelAndView addRoom(@ModelAttribute("roomForm") Room room, ModelAndView model, @RequestParam String action, HttpServletRequest request, BindingResult br){
        Room r = new Room();
        r.setRoomName(request.getParameter("roomName"));
        r.setFloor(request.getParameter("floor"));
        r.setPricePerNight(Double.parseDouble(request.getParameter("pricePerNight")));
        r.setMaxGuests(Integer.parseInt(request.getParameter("maxGuests")));
        
        if (action.equalsIgnoreCase("add"))
            roomDAO.insertRoom(room);
        else if (action.equalsIgnoreCase("delete")){
            r.setRoomID(Integer.parseInt(request.getParameter("roomID")));
            roomDAO.deleteRoom(room);   
        }
        else if (action.equalsIgnoreCase("edit")){
            r.setRoomID(Integer.parseInt(request.getParameter("roomID")));
            roomDAO.updateRoom(room);
        }

            
        List<Room> roomList = roomDAO.list();
        RoomForm rf = new RoomForm();
        //Room room = new Room();
        
        model.addObject("roomList", roomList);
        model.addObject("roomForm", new RoomForm());
        //model.addObject("room", room);
        model.setViewName("room");
        
        return model;
    }
}
