/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.register;

import hotelmaster.account.Account;
import hotelmaster.account.AccountFactory;
import hotelmaster.account.User;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
        Account accountForm = new User();
        modelAndView.addObject("accountForm", accountForm);
        
        return modelAndView;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("accountForm") @Valid Account accountForm,  BindingResult result, HttpServletRequest htrequest, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) { //already logged in, redirect
            return new ModelAndView("redirect:home");
        }
        
        if (!result.hasErrors()){
            System.out.println("Registration submitted: No Errors.");
            //create the account
            try {
                //try to register the new user
                accountSession = new AccountFactory().registerUser(accountForm);
                
                //if we've gotten here, we assume theyve registered successfully
                htrequest.getSession().setAttribute("accountSession", accountSession);
                //send a message to the message service
                return new ModelAndView("redirect:home");
                
            } catch (Exception e){
                result.rejectValue("error", "", e.getMessage());
            }
        } else {
            System.out.println("Registration submitted: Errors.");
            //result.reject("Errors: Youve been rejected!");
            modelAndView.addObject("accountForm", accountForm);
            modelAndView.setViewName("register");
        }
        //try to register
        System.out.println("FirstName " + accountForm.getFirstName());
        System.out.println("LastName " + accountForm.getLastName());
        System.out.println("Email " + accountForm.getEmail());
        System.out.println("Password " + accountForm.getPassword());
        
        return modelAndView;
    }
}
