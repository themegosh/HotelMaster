/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.notification;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe_000
 */
@Component
public class NotificationService {
    
    private List<Notification> notifications;

    public NotificationService(){
        notifications = new ArrayList<>();
    }
    
    public NotificationService(List<Notification> notifications) {
        this.notifications = notifications;
    }
    
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
    
    public void clear(){
        notifications.clear();
    }
        
    public boolean isEmpty(){
        return notifications.isEmpty();
    }
    
    public void add(String title, String message, NotificationType notificationType){
        notifications.add(new Notification(title, message, notificationType));
    }
}
