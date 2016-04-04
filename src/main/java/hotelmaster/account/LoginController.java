/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @Autowired
    Account accountSession;
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }
    
    @RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
    public ModelAndView showLoginSuccess() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSuccess");
        modelAndView.addObject("userName", accountSession.getFirstName() + accountSession.getLastName());       
        System.out.println("LoginController: /loginSuccess account:" + accountSession.toString());
        
        return new ModelAndView("loginSuccess", "userName", accountSession.getFirstName() + " " + accountSession.getLastName());
        //return modelAndView;
    }
    
}
