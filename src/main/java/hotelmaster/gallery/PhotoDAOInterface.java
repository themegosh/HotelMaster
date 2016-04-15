/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.gallery;

import hotelmaster.Photo;
import java.util.List;

/**
 *
 * @author Trevor
 */
public interface PhotoDAOInterface {
    List<Photo> getAllPhotos();
    Photo getPhotoByID(int id);
    List<Photo> getPhotosByRoomID(int roomID);
    int insertPhoto(Photo photo);
    int deletePhoto(int imageID);
    int setPrimaryPhoto(int imageID);
    int getCurrPrimaryPhoto(int currRoomID);
    public int unsetCurrPrimaryPhoto(int imageID);
}