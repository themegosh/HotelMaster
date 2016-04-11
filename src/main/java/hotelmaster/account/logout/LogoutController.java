/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.logout;

import hotelmaster.account.AccountSession;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Doug
 */
@Controller
public class LogoutController {
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value="/logout")
    public ModelAndView showLogout() {
        
        //send them home
        ModelAndView modelAndView = new ModelAndView("redirect:home");
        
        //add notification handling to this page
        modelAndView.addObject("notificationService", notificationService);
        
        if (accountSession.getAccount() != null) {
            accountSession.setAccount(null); //nulify the account
            notificationService.add("Success!", "Successfully logged out.", NotificationType.SUCCESS);
        } else {
            notificationService.add("Warning!", "You are trying to log out when you're not logged in!", NotificationType.WARNING);
        }
        
        return modelAndView;
    }
        
}
