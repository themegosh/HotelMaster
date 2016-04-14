/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.admin.photos;

import hotelmaster.Photo;
import hotelmaster.Room;
import hotelmaster.account.Account;
import hotelmaster.account.AccountLevel;
import hotelmaster.account.AccountSession;
import hotelmaster.gallery.PhotoDAO;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
import hotelmaster.rooms.RoomDAO;
import hotelmaster.rooms.RoomForm;
import java.io.IOException;
import java.util.List;
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
 * @author GEORGE
 */
@Controller
@RequestMapping(value = "/admin/photos")
public class PhotosController {
    
    @Autowired
    private PhotoDAO photoDAO;
    
    @Autowired
    private RoomDAO roomDAO;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) throws IOException {
        
        if (accountSession.getAccount() == null) {
            notificationService.add("Error!", "You don't have the required permissions to be there!", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        else if (accountSession.getAccount().getAccountLevel() == AccountLevel.USER){
            notificationService.add("Error!", "You don't have the required permissions to be there!", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        
        List<Room> roomList = roomDAO.list();
        List<Photo> photoList = photoDAO.getAllPhotos();
        
        model.addObject("roomList", roomList);;
        model.addObject("photoList", photoList);
        model.setViewName("admin.photos");
               
        return model;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView updateUser(ModelAndView model, HttpServletRequest request, @ModelAttribute("accountForm") @Valid Account accountForm, BindingResult result, Errors errors) throws IOException {
       return model;
    }
    
}
