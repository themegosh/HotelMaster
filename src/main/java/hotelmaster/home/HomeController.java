/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.home;

import hotelmaster.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
@RequestMapping({"/"})
public class HomeController {
    
    @Autowired
    Account accountSession;
    
    @RequestMapping(value={"", "home"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home"); //viewing the home.jsp
        modelAndView.addObject("accountSession", accountSession); //inject the session
        
        //do stuff for the home page
        
        return modelAndView;
    }
    
    
}
