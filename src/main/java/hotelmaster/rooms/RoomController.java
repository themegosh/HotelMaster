package hotelmaster.rooms;

import hotelmaster.Room;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Danny
 */

@Controller
public class RoomController {

    @Autowired
    private RoomDAO roomDAO;
    
    @RequestMapping(value = "/room")
    public ModelAndView listRoom(ModelAndView model) throws IOException {
        List<Room> roomList = roomDAO.list();
        RoomForm rf = new RoomForm();
        List<String> features = roomDAO.listFeatures();
        roomDAO.setRoomFeatures(roomList);
        
        model.addObject("roomList", roomList);
        model.addObject("roomForm", new RoomForm());
        model.addObject("features", features);
        model.setViewName("room");
               
        return model;
    }
    
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ModelAndView addRoom(@ModelAttribute("roomForm") Room room, ModelAndView model, @RequestParam String action, HttpServletRequest request, BindingResult br){
        Room r = new Room();
        
        r.setRoomName(room.getRoomName());
        r.setFloor(room.getFloor());
        r.setPricePerNight(room.getPricePerNight());
        r.setMaxGuests(room.getMaxGuests());
        r.setFeaturesTest(room.getFeaturesTest());
        
        String[] selectedFeatures = room.getFeaturesTest();
        
        for (int i = 0; i < selectedFeatures.length; i++){
            r.getFeatures().put(selectedFeatures[i], Boolean.TRUE);
        }
        
        r.setFeatures(r.getFeatures());
                        
        if (action.equalsIgnoreCase("add")){
            roomDAO.insertRoom(r);
            r.setRoomID(roomDAO.getMaxRoomID());
            System.out.println("RoomID = " + r.getRoomID());
            
            //Iterator iterator = r.getFeatures()
            
            roomDAO.addRoomFeatures(r);
        }
        else if (action.equalsIgnoreCase("delete")){
            r.setRoomID(Integer.parseInt(request.getParameter("roomID")));
            roomDAO.deleteRoom(room);   
        }
        else if (action.equalsIgnoreCase("edit")){
            r.setRoomID(Integer.parseInt(request.getParameter("roomID")));
            roomDAO.updateRoom(room);
            roomDAO.addRoomFeatures(r);
        }

            
        List<Room> roomList = roomDAO.list();
        RoomForm rf = new RoomForm();
        List<String> features = roomDAO.listFeatures();
        roomDAO.setRoomFeatures(roomList);
        
        model.addObject("roomList", roomList);
        model.addObject("roomForm", new RoomForm());
        model.addObject("features", features);
        model.setViewName("room");
        
        return model;
    }
}
