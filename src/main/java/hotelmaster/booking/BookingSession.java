/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking;

import hotelmaster.Booking;


/**
 *
 * @author GEORGE
 */
public interface BookingSession {
    public Booking getBooking();
    public void setBooking(Booking booking);
    public void cancelBooking(Booking booking);
}
