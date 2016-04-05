/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.logout;

import hotelmaster.account.login.*;
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
public class LogoutController {
    
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView showLogout(HttpServletRequest htrequest) {
        
        //remove the session
        htrequest.getSession().removeAttribute("account");
        
        ModelAndView modelAndView = new ModelAndView("redirect:home"); //viewing the login.jsp
        
        return modelAndView;
    }
        
}
