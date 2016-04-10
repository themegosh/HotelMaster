/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.search;

import hotelmaster.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Trevor
 */
@Controller
public class SearchController {
    
    @Autowired
    private SearchDAO searchDAO;
    
    @RequestMapping(value={"/getResults"})
    public void getResults() {
        List<Room> resultList = searchDAO.getAllRooms();
        
    }
    
}
