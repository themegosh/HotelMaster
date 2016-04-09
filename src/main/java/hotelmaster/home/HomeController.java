/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.home;

import hotelmaster.Photo;
import hotelmaster.account.Account;
import hotelmaster.gallery.PhotoDAO;
import hotelmaster.notification.Notification;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
public class HomeController {
    
    @Autowired
    private PhotoDAO photoDAO;
    
    @Autowired
    private NotificationService notificationService;
        
    @RequestMapping(value={"/", "/home"})
    public ModelAndView home(HttpServletRequest htrequest){
        ModelAndView modelAndView = new ModelAndView("home"); //viewing the home.jsp
        
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) {
            System.out.println("HomeController: /home accountSession:" + accountSession.toString());
        }
        //add notification handling to this page
        modelAndView.addObject("notificationService", notificationService);
        
        notificationService.add("Test", "NORMAL", NotificationType.NORMAL);
        notificationService.add("Test", "ERROR", NotificationType.ERROR);
        notificationService.add("Test", "SUCCESS", NotificationType.SUCCESS);
        notificationService.add("Test", "WARNING", NotificationType.WARNING);
        
        //do stuff for the home page
        List<Photo> photoList = photoDAO.getAllPhotos();
        modelAndView.addObject("photoList", photoList);
        
        return modelAndView;
    }
    
    
}
