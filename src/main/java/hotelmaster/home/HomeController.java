/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.home;

import hotelmaster.Photo;
import hotelmaster.account.Account;
import hotelmaster.gallery.PhotoDAO;
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
        
    @RequestMapping(value={"/", "/home"})
    public ModelAndView home(HttpServletRequest htrequest){
        ModelAndView modelAndView = new ModelAndView("home"); //viewing the home.jsp
        
        Account accountSession = (Account)htrequest.getSession().getAttribute("accountSession");
        if (accountSession != null) {
            System.out.println("HomeController: /home accountSession:" + accountSession.toString());
        }
        
        //do stuff for the home page
        Photo photo = new Photo();
        List<Photo> photoList = photoDAO.list();
        
        modelAndView.addObject("photo", photo);
        modelAndView.addObject("photoList", photoList);
        
        return modelAndView;
    }
    
    
}
