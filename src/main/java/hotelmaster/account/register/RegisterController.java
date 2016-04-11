/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.account.register;

import hotelmaster.account.Account;
import hotelmaster.account.AccountSession;
import hotelmaster.account.AccountsDao;
import hotelmaster.account.User;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
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
 * @author Doug
 */
@Controller
public class RegisterController {
    
    @Autowired
    private AccountsDao accountsDao;
    
    @Autowired
    private NotificationService notificationService;
    
    @Autowired
    private AccountSession accountSession;
    
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage() {
        
        //dont let them register again!
        if (accountSession.getAccount() != null) {
            notificationService.add("Error!", "You are already logged in!", NotificationType.ERROR);
            return new ModelAndView("redirect:home", "notificationService", notificationService);
        }
        
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        
        //add notification handling to this page
        modelAndView.addObject("notificationService", notificationService);
        
        User accountForm = new User();
        modelAndView.addObject("accountForm", accountForm);
        
        return modelAndView;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("accountForm") @Valid User accountForm,  BindingResult result, Errors errors) {
        
        //dont let them register again!
        if (accountSession.getAccount() != null) {
            notificationService.add("Error!", "You are already logged in!", NotificationType.ERROR);
            return new ModelAndView("redirect:home", "notificationService", notificationService);
        }
        
        ModelAndView modelAndView = new ModelAndView("register"); //viewing the login.jsp
        
        //add notification handling to this page
        modelAndView.addObject("notificationService", notificationService);
        
        if (!result.hasErrors()){
            System.out.println("Registration submitted: No Errors.");
            //create the account
            try {
                //try to register the new user
                //inserting returns the freshly generated ID
                accountSession.setAccount(accountsDao.insertNewAccount(accountForm)); 
                                
                //notify them of the successful registration and login
                notificationService.add("Success!", "You have successfully registered and are now logged in.", NotificationType.SUCCESS);
                
                //send a message to the message service
                return new ModelAndView("redirect:home");
                
            } catch (Exception e){
                result.rejectValue("error", "", e.getMessage());
            }
        } else {
            System.out.println("Registration submitted: Errors. ");
            modelAndView.addObject("accountForm", accountForm);
            modelAndView.setViewName("register");
        }
        //try to register
        System.out.println("FirstName " + accountForm.getFirstName());
        System.out.println("LastName " + accountForm.getLastName());
        System.out.println("Email " + accountForm.getEmail());
        System.out.println("Password " + accountForm.getPassword());
        
        return modelAndView;
    }
}
