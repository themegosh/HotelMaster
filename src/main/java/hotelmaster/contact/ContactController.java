/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.contact;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GEORGE
 */


@Controller
@RequestMapping(value="/contact")
public class ContactController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String viewContact(Map<String, Object> model) {
        Contact contactForm = new Contact();    
        model.put("contactForm", contactForm);
 
        return "contact";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@ModelAttribute("contactForm") Contact contact,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("name: " + contact.getName());
        System.out.println("email: " + contact.getEmail());
        System.out.println("subject: " + contact.getSubject());
        System.out.println("message: " + contact.getMessage());
         
        return "ContactFormSuccess";
    }
}