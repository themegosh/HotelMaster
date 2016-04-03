/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mathe_000
 */
public class Room {
    
    //Variables for the Room table in the database
    private int roomID;
    private String roomName;
    private String floor;
    private double pricePerNight;
    private int maxGuests;
    
    List<Photo> photos;
    HashMap<String, Boolean> features;
    List<Review> reviews;

    //Empty constructor
    public Room(){
        
    }
    
    //Constructor with parameters
    public Room(String roomName, String floor, double pricePerNight, int maxGuests){
        this.roomName = roomName;
        this.floor = floor;
        this.pricePerNight = pricePerNight;
        this.maxGuests = maxGuests;
    }
    
    //Getters and setters
    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }
    
    
}
