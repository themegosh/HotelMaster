/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster;

/**
 *
 * @author mathe_000
 */
public class Photo {
    
    //variables associated with the room_images table
    private int imageID;
    private int roomID;
    private byte[] image;
    private String title;
    private int primary;
    
    //constructors
    public Photo() { }
    
    public Photo(int imageID, int roomID, byte[] image, String title, int primary) {
        this.imageID = imageID;
        this.roomID = roomID;
        this.image = image;
        this.title = title;
        this.primary = primary;
    }
    
    //Getters and setters

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }
    
    public int getImageID() {
        return imageID;
    }
    
    public void setImageID(int imageID){
        this.imageID = imageID;
    }
    
    public int getRoomID() {
        return roomID;
    }
    
    public void setRoomID(int roomID){
        this.roomID = roomID;
    }
    
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
