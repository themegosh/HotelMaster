/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmaster.booking;

import hotelmaster.Booking;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GEORGE
 */
@Primary
@Repository
public class BookingDAO implements BookingDAOInterface{
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public DriverManagerDataSource getDataSource(){
        
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://dmdev.ca:3306/themegos_hotel_master");
        datasource.setUsername("themegos_hotel_m");
        datasource.setPassword("A2b8rbd6%rT9");
        
        return datasource;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.setDataSource(getDataSource());
    }
    
    @Override
    public int insertBooking(Booking booking) {
        
        //String sDate, String eDate, int numGuests, int numNights, int roomID, int accountID, int totalCost
        
        jdbcTemplate.setDataSource(getDataSource());
        
        String insertQuery = "INSERT INTO booking (account_id, room_id, booking_date, check_in_date, check_out_date, num_guests) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{booking.getAccount_id(), booking.getRoomID(), booking.getBookingDate(), booking.getStartDate(), booking.getEndDate(), booking.getNumGuests()};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER, Types.DATE, Types.DATE, Types.DATE, Types.INTEGER};
        
        return jdbcTemplate.update(insertQuery, params, types);
    }
    
    
    
    
}
