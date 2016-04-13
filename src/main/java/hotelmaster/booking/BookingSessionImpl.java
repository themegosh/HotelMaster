/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking;

import hotelmaster.Booking;
import java.io.Serializable;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author GEORGE
 */
@Component("bookingSession")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value=WebApplicationContext.SCOPE_SESSION)
public class BookingSessionImpl implements BookingSession, Serializable{

    private Booking booking;
    
    public BookingSessionImpl() {
    }
    
    @Override
    public Booking getBooking() {
        return booking;
    }


    @Override
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public void cancelBooking() {
        this.booking = null;
    }
    
}
