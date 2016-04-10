/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

//Author - Danny Ardona

public class Room {
    
    //Variables for the Room table in the database
    private int roomID;
    private String roomName;
    private String floor;
    private double pricePerNight;
    private int maxGuests;
    private String roomViewURL;
    
    HashMap<String, Boolean> features;
    
    List<Photo> photos;
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
        
        setRoomViewURL(roomName);
    }
    
    //Getters and setters
    public int getRoomID() {
        return roomID;
    }
    
    public void setRoomID(int roomID){
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
        setRoomViewURL(roomName);
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
        
    public String getRoomViewURL(){
        
        return roomViewURL;
    }

    public HashMap<String, Boolean> getFeatures() {
        return features;
    }

    public void setFeatures(HashMap<String, Boolean> features) {
        this.features = features;
    }
    
    public final void setRoomViewURL(String roomName){
        roomViewURL = roomName.trim().replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
        roomViewURL = roomViewURL.replaceAll("[\\-| |\\.]+", "-");
        roomViewURL = roomViewURL.toLowerCase();
    }
    
}
