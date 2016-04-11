/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.admin.accounts;

import hotelmaster.Room;
import hotelmaster.account.Account;
import hotelmaster.account.AccountLevel;
import hotelmaster.account.AccountSession;
import hotelmaster.account.AccountsDao;
import hotelmaster.notification.NotificationService;
import hotelmaster.notification.NotificationType;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mathe_000
 */
@Controller
@RequestMapping(value = "/admin/accounts")
public class AccountsController {
    
    @Autowired
    private AccountsDao accountsDao;
    
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
        
        List<Account> accounts = accountsDao.getAccounts();
        model.addObject("accountsList", accounts);
        
        Account accountForm = new Account();
        model.addObject("accountForm", accountForm);
        
        model.setViewName("admin.accounts");
        return model;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView updateUser(ModelAndView model, HttpServletRequest request, @ModelAttribute("accountForm") @Valid Account accountForm, BindingResult result, Errors errors) throws IOException {
        
        if (accountSession.getAccount() == null) {
            notificationService.add("Error!", "You don't have the required permissions to be there!", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        else if (accountSession.getAccount().getAccountLevel() == AccountLevel.USER){
            notificationService.add("Error!", "You don't have the required permissions to be there!", NotificationType.ERROR);
            return new ModelAndView("redirect:/home");
        }
        
        //determine if we're saving or deleting
        if (request.getParameter("save") != null) {
            //workaround for accessLevel checkbox
            if (request.getParameter("accessLevel") == null)
                accountForm.setAccountLevel(AccountLevel.USER);
            else
                accountForm.setAccountLevel(AccountLevel.ADMIN);

            //update the account
            accountsDao.updateAccountDetails(accountForm);

            notificationService.add("Success!", accountForm.getFirstName() + " " + accountForm.getLastName() + "'s account has been updated.", NotificationType.SUCCESS);
        } else { //deleting
            accountsDao.deleteAccount(accountForm.getEmail());
            notificationService.add("Success!", accountForm.getFirstName() + " " + accountForm.getLastName() + "'s account has been deleted.", NotificationType.SUCCESS);
        }
        
        
        System.out.println("POST accountForm: " + accountForm.toString());
        
        //this should be last, after applying the change
        List<Account> accounts = accountsDao.getAccounts();
        model.addObject("accountsList", accounts);
        
        //add notification handling to this page
        model.addObject("notificationService", notificationService);
        
        model.setViewName("admin.accounts");
        return model;
    }
    
}
