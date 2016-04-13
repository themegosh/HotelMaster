/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

import java.util.Date;

/**
 *
 * @author mathe_000
 */
public class Booking {
    private String startDate;
    private String endDate;
    private String bookingDate;
    private int numGuests;
    private int numNights;
    private int roomID;
    private int account_id;
    private int booking_id;
    private double totalCost;
    private String bookingURL;

    public Booking(){}
    
    public Booking(String startDate, String endDate, int numGuests, int room, int account){
        this.startDate = startDate;
        this.endDate = endDate;
        this.numGuests = numGuests;
        this.roomID = room;
        this.account_id = account;
        //this.id = id;
    }
    
    public int getBooking_id(){
        return booking_id;
    }
    
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    
    public int getNumNights() {
        return numNights;
    }

    public void setNumNights(int numNights) {
        this.numNights = numNights;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public void setNumNights(String fromDate,String toDate)
   {    
       java.util.Calendar cal1 = new java.util.GregorianCalendar();
       java.util.Calendar cal2 = new java.util.GregorianCalendar();
       System.out.println(fromDate + " and " + toDate);
       //split year, month and days from the date using StringBuffer.
       StringBuffer sBuffer = new StringBuffer(fromDate);
       String yearFrom = sBuffer.substring(0,4);
       String monFrom = sBuffer.substring(5,7);
       String ddFrom = sBuffer.substring(8,10);
       int intYearFrom = Integer.parseInt(yearFrom);
       int intMonFrom = Integer.parseInt(monFrom);
       int intDdFrom = Integer.parseInt(ddFrom);

       // set the fromDate in java.util.Calendar
       cal1.set(intYearFrom, intMonFrom, intDdFrom);

       //split year, month and days from the date using StringBuffer.
       StringBuffer sBuffer1 = new StringBuffer(toDate);
       String yearTo = sBuffer1.substring(0,4);
       String monTo = sBuffer1.substring(5,7);
       String ddTo = sBuffer1.substring(8,10);
       int intYearTo = Integer.parseInt(yearTo);
       int intMonTo = Integer.parseInt(monTo);
       int intDdTo = Integer.parseInt(ddTo);

       // set the toDate in java.util.Calendar
       cal2.set(intYearTo, intMonTo, intDdTo);

       //call method daysBetween to get the number of days between two dates
       int numNights = nightsBetween(cal1.getTime(),cal2.getTime());
       
       this.numNights = numNights;
   }
    
    public int nightsBetween(Date d1, Date d2)
    {
       return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public String getBookingURL() {
        return bookingURL;
    }

    public void setBookingURL(String bookingURL) {
        this.bookingURL = bookingURL;
    }
    
}
