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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author GEORGE
 */
@Controller
public class PhotosController {
    
    @Autowired
    private PhotoDAO photoDAO;
    
    @Autowired
    private RoomDAO roomDAO;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value = "/admin/photos", method = RequestMethod.GET)
    public ModelAndView listPhotos(ModelAndView model) throws IOException {
        
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
    
    @RequestMapping(value = "/admin/photos/add", method = RequestMethod.POST)
    public ModelAndView addPhoto(@ModelAttribute("photoBucket") PhotoBucket photo, ModelAndView model) throws IOException{
        
        Photo p = new Photo();
        
        MultipartFile f = photo.getFile();
        byte[] image = f.getBytes();
        
        p.setRoomID(photo.getRoomID());
        p.setImage(image);
        p.setTitle(photo.getTitle());
        
        photoDAO.insertPhoto(p);
        
        model.setViewName("redirect:/admin/photos");
        
        return model;
    }
    
    @RequestMapping(value = "/admin/photos/delete", method = RequestMethod.POST)
    public ModelAndView deletePhoto(@RequestParam("imageID") int imageID, ModelAndView model) throws IOException{       
            
        int deleted = photoDAO.deletePhoto(imageID);
        
        if(deleted == 0){
            notificationService.add("Error!", "You do not have the required permissions to access the page", NotificationType.ERROR);
            return new ModelAndView("redirect:/admin/photos");
        } else {
            notificationService.add("Great!", "Photo has been deleted", NotificationType.SUCCESS);
            return new ModelAndView("redirect:/admin/photos");
        }
    }
    
    @RequestMapping(value = "/admin/photos/update", method = RequestMethod.POST)
    public ModelAndView setPrimaryPhoto(@RequestParam("imageID") int imageID, @RequestParam("roomID") int roomID, ModelAndView model) throws IOException{       
            
        int currPrimary = photoDAO.getCurrPrimaryPhoto(roomID);
        photoDAO.unsetCurrPrimaryPhoto(currPrimary);
        photoDAO.setPrimaryPhoto(imageID);
        model.setViewName("redirect:/admin/photos");
        
        return model;
    }
    
}
