/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.notification;

/**
 *
 * @author mathe_000
 */
public class Notification {
    private String title;
    private String message;
    private NotificationType notificationType;

    public Notification(String title, String message, NotificationType notificationType) {
        this.title = title;
        this.message = message;
        this.notificationType = notificationType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
    
    public String getAlertClass(){
        String alert = "";
        
        switch (notificationType) {
            case NORMAL:
                alert = "alert-info";
                break;
            case WARNING:
                alert = "alert-warning";
                break;
            case SUCCESS:
                alert = "alert-success";
                break;
            case ERROR:
                alert = "alert-danger";
                break;              
        }
        
        return alert;
    }
}
