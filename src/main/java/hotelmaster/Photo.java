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
    Long imageID;
    Long roomID;
    byte[] image;
    String title;
    
    
    //constructors
    public Photo() { }
    
    public Photo(Long imageID, Long roomID, byte[] image, String title) {
        this.imageID = imageID;
        this.roomID = roomID;
        this.image = image;
        this.title = title;
    }
    
    //Getters and setters
    public Long getImageID() {
        return imageID;
    }
    
    public void setImageID(Long imageID){
        this.imageID = imageID;
    }
    
    public Long getRoomID() {
        return roomID;
    }
    
    public void setRoomID(Long RoomID){
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
