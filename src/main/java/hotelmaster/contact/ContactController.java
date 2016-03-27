/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GEORGE
 */
@Controller
@RequestMapping({"/"})
public class ContactController {
    
    @RequestMapping(value={"", "contact"})
    public String contact(){
        return "contact";
    }
    
    
}
