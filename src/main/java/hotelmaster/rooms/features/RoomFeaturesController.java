package hotelmaster.rooms.features;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Danny
 */
@Controller
public class RoomFeaturesController {
    @Autowired
    private RoomFeaturesDAO featuresDAO;
    
    @RequestMapping(value = "roomFeatures")
    public ModelAndView listFeatures(ModelAndView model) throws IOException {
        List<String> features = featuresDAO.getFeatures();
        RoomFeaturesForm featuresForm = new RoomFeaturesForm();
        
        model.setViewName("roomFeatures");        
        model.addObject("features", features);
        model.addObject("featuresForm", featuresForm);
        
        return model;
    }
}
