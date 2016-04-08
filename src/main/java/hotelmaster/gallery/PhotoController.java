/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import hotelmaster.account.Account;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Trevor
 */
@Controller
public class PhotoController {
    
    @Autowired
    private PhotoDAO photoDAO;
    
    @RequestMapping(value={"/getPhoto"})
    public void getPhoto(@RequestParam("ID") Integer ID, HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        Photo photo = photoDAO.getPhotoByID(ID);
            
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(photo.getImage());
        response.getOutputStream().close();
    }
}
