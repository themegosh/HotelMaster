/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.home;

import hotelmaster.Photo;
import hotelmaster.account.Account;
import hotelmaster.account.AccountSession;
import hotelmaster.gallery.PhotoDAO;
import hotelmaster.notification.NotificationService;
import hotelmaster.search.SearchDAO;
import hotelmaster.search.SearchParams;
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
    private SearchDAO searchDAO;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
        
    @RequestMapping(value={"/", "/home"})
    public ModelAndView home() {
        
        ModelAndView modelAndView = new ModelAndView("home"); //viewing the home.jsp
        
        if (accountSession.getAccount() != null)
            System.out.println("HomeController: /home accountSession:" + accountSession.getAccount().toString());
        
        //add notification handling to this page
        modelAndView.addObject("notificationService", notificationService);
                
        //gallery stuff
        List<Photo> photoList = photoDAO.getAllPhotos();
        modelAndView.addObject("photoList", photoList);
        
        //search stuff
        SearchParams searchParams = new SearchParams();
        modelAndView.addObject("searchParams", searchParams);
        
        return modelAndView;
    }
    
}
