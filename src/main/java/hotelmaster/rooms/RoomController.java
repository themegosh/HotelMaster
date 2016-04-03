package hotelmaster.rooms;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomController {

    @RequestMapping(value="/room", method = RequestMethod.GET)
    public String showRoomPage() {
        return "room";
    }

}
