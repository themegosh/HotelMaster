/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Trevor
 */
@Primary
@Repository
public class SearchDAO implements SearchDAOInterface {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    
    @Override
    public List<SearchResult> getAllRooms() {
        String query = "SELECT * FROM room";
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        List<SearchResult> resultList = new ArrayList<SearchResult>();
        
        //map columns to room object
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        for (Map<String, Object> row : rows) {
            SearchResult result = new SearchResult();
            result.setNumOfGuests((int)row.get("max_guests"));
            resultList.add(result);
        }
        
        //return list to be used by controller
        return resultList;
    }
    
}