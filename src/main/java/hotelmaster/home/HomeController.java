/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping(value="")
    public String index(){
        return "index";
    }
    
    @RequestMapping (value = "login")
    public ModelAndView viewLogin(Model model){

        Object obj = new String("Tacos"); //test

        return new ModelAndView("login", "loginObj", obj);
    }
    
}
