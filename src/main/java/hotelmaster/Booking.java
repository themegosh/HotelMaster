/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

import hotelmaster.account.User;
import java.util.Date;

/**
 *
 * @author mathe_000
 */
public class Booking {
    Date startDate;
    Date endDate;
    int numGuests;
    int room_id;
    int account_id;
    int booking_id;
    
    public Booking(){}
    
    public Booking(Date startDate, Date endDate, int numGuests, int room, int account){
        this.startDate = startDate;
        this.endDate = endDate;
        this.numGuests = numGuests;
        this.room_id = room;
        this.account_id = account;
        //this.id = id;
    }
    
    public int getBooking_id(){
        return booking_id;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    
}
