/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.util;

import hotelmaster.account.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Doug
 */
public class ApplicationContextProvider implements ApplicationContextAware {
    
    private static ApplicationContext context;
     
    public ApplicationContext getApplicationContext() {
        return context;
    }
     
    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
    
}
