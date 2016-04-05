/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.register;

import hotelmaster.account.Account;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
    
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(HttpServletRequest htrequest) {
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) {
            return new ModelAndView("redirect:home");
        }
        UserForm uf = new UserForm();
        modelAndView.addObject("userForm", uf);
        
        return modelAndView;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("userForm") @Valid UserForm uf,  BindingResult result, HttpServletRequest htrequest, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) {
            return new ModelAndView("redirect:home");
        }
        
        //result.rejectValue("email", "Somethings wrong...");
        //result.rejectValue("email", "a", "Woah there");
        //result.reject("email", "lolwut");
        
        if (!result.hasErrors()){
            System.out.println("Registration submitted: No Errors.");
            //create the account
            //result.reject("No errors: Youve been rejected anways!");
        } else {
            System.out.println("Registration submitted: Errors.");
            //result.reject("Errors: Youve been rejected!");
            modelAndView.addObject("userForm", uf);
            modelAndView.setViewName("register");
        }
        //try to register
        System.out.println("FirstName " + uf.getFirstName());
        System.out.println("LastName " + uf.getLastName());
        System.out.println("Email " + uf.getEmail());
        System.out.println("Password " + uf.getPassword());
        
        return modelAndView;
    }
}
