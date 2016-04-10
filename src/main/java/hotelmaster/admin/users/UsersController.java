/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.admin.users;

import hotelmaster.Room;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
@RequestMapping(value = "/admin")
public class UsersController {
    
    @RequestMapping(value = "/users")
    public ModelAndView listRoom(ModelAndView model) throws IOException {
        model.setViewName("admin.users");
        return model;
    }
    
}
