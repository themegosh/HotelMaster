/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.register;

import hotelmaster.account.Account;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Doug
 */
@Controller
public class RegisterController {
    @Autowired
    Account accountSession;
    
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        modelAndView.addObject("accountSession", accountSession); //inject the session
        UserForm uf = new UserForm();
        modelAndView.addObject("userForm", uf);
        
        return modelAndView;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("userForm") UserForm uf, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        modelAndView.addObject("accountSession", accountSession); //inject the session
        
        //try to register
        System.out.println("FirstName " + uf.getFirstName());
        System.out.println("LastName " + uf.getLastName());
        System.out.println("Email " + uf.getEmail());
        System.out.println("Password " + uf.getPassword());
        System.out.println("ConfirmPassword " + uf.getConfirmPassword());
        
        return modelAndView;
    }
}
