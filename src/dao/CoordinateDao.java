package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sothawo.mapjfx.Coordinate;

import connector.Connector;

public class CoordinateDao {

	private Connector connector;
	private int idUtente;
    private static final Logger logger = LoggerFactory.getLogger(CoordinateDao.class);

    
    public CoordinateDao() {
    	
    	 // a couple of markers using the provided ones
    	this.connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	
    
    }
	
 
    
    public void setCoordinate(int idUtente,String lat, String lon) {
    	   ResultSet rs = null;
         
           String sql = "call aggiungi_coordinate(?,?,?)";

           try (Connection conn = connector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	   pstmt.setInt(1, idUtente);
        	   pstmt.setString(2, lat);
        	   pstmt.setString(3, lon);

               int rowAffected = pstmt.executeUpdate();
               if (rowAffected == 1) {

                   rs = pstmt.getGeneratedKeys();
             
               }
           } catch (SQLException ex) {
               logger.debug(ex.getMessage());
           } finally {
               try {
                   if (rs != null) rs.close();
               } catch (SQLException e) {
                   logger.debug(e.getMessage());
               }
           }
  
    	
    }
    
    
    public Coordinate getCoordinate() {

    	String sql;
    	String lat=""; 
    	String lon ="";
    	
       	sql = "call get_coordinate(?)";
    
    	ResultSet res = null;
    	try (Connection conn = connector.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setInt(1, idUtente);
               res = stmt.executeQuery();

               while (res.next()) {
            	  
            	   lat = res.getString("latitudine");
            	   lon = res.getString("longitudine");
            	   
               }
           } catch (SQLException ex) {
        	   logger.debug(ex.getMessage());
           } finally {
               try {
                   if (res != null) res.close();
               } catch (SQLException e) {
            	   logger.debug(e.getMessage());
               }
           }
    
    		Coordinate coordinate = new Coordinate(Double.parseDouble(lat), Double.parseDouble(lon));
    		logger.debug( " COORDINATE VOLONTARIO " + coordinate.getLatitude() + " " +coordinate.getLongitude() );
    		return coordinate;
    	
    }
    
    public void close() {
    	try {
			connector.getConnection().close();
		} catch (SQLException e) {
			
     	   logger.debug(e.getMessage());

		}
    }
	
}
