/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.login;

import hotelmaster.account.Account;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
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
        
        return modelAndView;
    }
        
}
