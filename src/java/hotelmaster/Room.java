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
    
    int id;
    String floor;
    int roomNum;
    List<Photo> photos;
    HashMap<String, Boolean> features;
    List<Review> reviews;
    
}
