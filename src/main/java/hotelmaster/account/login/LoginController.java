/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.login;

import hotelmaster.account.Account;
import hotelmaster.account.AccountFactory;
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
public class LoginController {
    
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(HttpServletRequest htrequest) {
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) {
            return new ModelAndView("redirect:home");
        }
        ModelAndView modelAndView = new ModelAndView("login"); //viewing the login.jsp
        Login loginForm = new Login();
        modelAndView.addObject("loginForm", loginForm);
        
        return modelAndView;
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("loginForm") @Valid Login loginForm,  BindingResult result, HttpServletRequest htrequest, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("login"); //viewing the login.jsp
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) { //already logged in, redirect
            return new ModelAndView("redirect:home");
        }
               
        if (!result.hasErrors()){
            System.out.println("Login submitted: No Errors.");
            //create the account
            try {
                //try to login the user
                accountSession = new AccountFactory().loginEmail(loginForm);
                
                //if we've gotten here, we assume theyve registered successfully
                htrequest.getSession().setAttribute("accountSession", accountSession);
                //send a message to the message service
                return new ModelAndView("redirect:home");
                
            } catch (Exception e){
                //result.rejectValue("error", "", e.getMessage());
                //result.reject(e.getMessage());
                result.reject("", e.getMessage());
            }
        } else {
            System.out.println("Login submitted: Errors.");
            //result.reject("Errors: Youve been rejected!");
            modelAndView.addObject("loginForm", loginForm);
            modelAndView.setViewName("login");
        }
        //try to register
        System.out.println("Email " + loginForm.getEmail());
        System.out.println("Password " + loginForm.getPassword());
        
        return modelAndView;
    }
        
}
