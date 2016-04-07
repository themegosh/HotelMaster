/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.admin;

import hotelmaster.account.Account;
import hotelmaster.account.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
public class AdminController {
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView showLoginPage(HttpServletRequest htrequest) {
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession == null)             
            return new ModelAndView("redirect:home");
        else if (accountSession.getClass() == User.class)
            return new ModelAndView("redirect:home");
            
        
        
        ModelAndView modelAndView = new ModelAndView("admin.home");
        
        return modelAndView;
    }
}
