package hotelmaster.admin.reports;

import hotelmaster.Report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Danny
 */
@Primary
@Repository
public class ReportDAO implements ReportDAOInterface {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
   
    private JdbcTemplate jdbcTemplate;

    
    @Override
    public List<Report> listBookings(String checkInDate, String checkOutDate, double lowerPricePerNight, double upperPricePerNight, String floor){
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        List<Report> reportList;
        
        if (floor.equalsIgnoreCase("All")){
            String selectQuery =  "SELECT b.account_id, b.room_id, b.check_in_date, b.check_out_date, r.room_name, r.price_per_night, r.floor, b.check_out_date - b.check_in_date FROM booking b JOIN room r ON b.room_id = r.room_id "
                    + "WHERE check_in_date >= ? AND check_out_date <= ? AND price_per_night BETWEEN ? AND ?";
            Object[] params = new Object[]{checkInDate, checkOutDate, lowerPricePerNight, upperPricePerNight};
            int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE};

            reportList = jdbcTemplate.query(selectQuery, params, types, new RowMapper<Report>() {

                @Override
                public Report mapRow(ResultSet rs, int i) throws SQLException {
                    Report report = new Report();

                    report.setAccountID(rs.getInt("account_id"));
                    report.setRoomID(rs.getInt("room_id"));
                    report.setCheckInDate(rs.getString("check_in_date"));
                    report.setCheckOutDate(rs.getString("check_out_date"));
                    report.setRoomName(rs.getString("room_name"));
                    report.setPricePerNight(rs.getDouble("price_per_night"));
                    report.setFloor(rs.getString("floor"));
                    report.setLengthOfStay(Integer.parseInt(rs.getString("b.check_out_date - b.check_in_date")));
                    report.setTotalPrice(report.getPricePerNight() * report.getLengthOfStay());
                    
                    return report;
                }
            });
        }
        else {
            String selectQuery =  "SELECT b.account_id, b.room_id, b.check_in_date, b.check_out_date, r.room_name, r.price_per_night, r.floor, b.check_out_date - b.check_in_date FROM booking b JOIN room r ON b.room_id = r.room_id "
                    + "WHERE check_in_date >= ? AND check_out_date <= ? AND price_per_night BETWEEN ? AND ? AND FLOOR = ?";
            Object[] params = new Object[]{checkInDate, checkOutDate, lowerPricePerNight, upperPricePerNight, floor};
            int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR};

            reportList = jdbcTemplate.query(selectQuery, params, types, new RowMapper<Report>() {

                @Override
                public Report mapRow(ResultSet rs, int i) throws SQLException {
                    Report report = new Report();

                    report.setAccountID(rs.getInt("account_id"));
                    report.setRoomID(rs.getInt("room_id"));
                    report.setCheckInDate(rs.getString("check_in_date"));
                    report.setCheckOutDate(rs.getString("check_out_date"));
                    report.setRoomName(rs.getString("room_name"));
                    report.setPricePerNight(rs.getDouble("price_per_night"));
                    report.setFloor(rs.getString("floor"));
                    report.setLengthOfStay(Integer.parseInt(rs.getString("b.check_out_date - b.check_in_date")));
                    report.setTotalPrice(report.getPricePerNight() * report.getLengthOfStay());
                    
                    return report;
                }
            });
        }
        
        
        return reportList;
    }
}
