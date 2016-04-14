/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Danny
 */

public class Room {
    
    //Variables for the Room table in the database
    private int roomID;
    private String roomName;
    private String floor;
    private double pricePerNight;
    private int maxGuests;
    private String roomViewURL;
    
    private HashMap<String, Boolean> features;
    private Set<String> featuresTest;
    
    private List<Photo> photos;
    private Photo photo;
    
    //List<Review> reviews;

    //Empty constructor
    public Room(){
        features = new HashMap<String, Boolean>();
        
        features.put("Balcony", Boolean.FALSE);
        features.put("Breakfast in Bed", Boolean.FALSE);
        features.put("Jacuzzi", Boolean.FALSE);
        features.put("Netflix Enabled TV", Boolean.FALSE);
        features.put("Open Bar", Boolean.FALSE);
        features.put("Room Service", Boolean.FALSE);
        features.put("Wifi", Boolean.FALSE);
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
    

    public Set<String> getFeaturesTest() {
        return featuresTest;
    }

    public void setFeaturesTest(Set<String> featuresTest) {
        this.featuresTest = featuresTest;
    } 
    
    public List<Photo> getPhotos(){
        return photos;
    }
    
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    
    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
    
    
    public final void setRoomViewURL(String roomName){
        roomViewURL = roomName.trim().replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
        roomViewURL = roomViewURL.replaceAll("[\\-| |\\.]+", "-");
        roomViewURL = roomViewURL.toLowerCase();
    }
    
}
