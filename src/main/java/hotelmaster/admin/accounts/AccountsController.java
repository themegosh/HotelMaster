/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.admin.accounts;

import hotelmaster.Room;
import hotelmaster.account.Account;
import hotelmaster.account.AccountsDao;
import hotelmaster.account.User;
import hotelmaster.notification.NotificationService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) throws IOException {
        
        List<Account> accounts = accountsDao.getAccounts();
        model.addObject("accountsList", accounts);
        
        User accountForm = new User();
        model.addObject("accountForm", accountForm);
        
        model.setViewName("admin.accounts");
        return model;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView updateUser(ModelAndView model) throws IOException {
        
        List<Account> accounts = accountsDao.getAccounts();
        model.addObject("accountsList", accounts);
        
        User accountForm = new User();
        model.addObject("accountForm", accountForm);
        
        model.setViewName("admin.accounts");
        return model;
    }
    
}
