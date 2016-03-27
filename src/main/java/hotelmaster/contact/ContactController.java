/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GEORGE
 */
@Controller
public class ContactController {
    
    @RequestMapping(value="/contact", method = RequestMethod.GET)
    public String showLoginPage() {
        return "contact";
    }
    
}
