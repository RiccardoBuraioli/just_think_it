package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;

public class LoginDao {
	final Connector connector;
    private String tableUser;
    private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);

    
    
	  public String getTableUser() {
	        return this.tableUser;
	    }
	  
	  public void setTableUser(String a) {
		  this.tableUser = a;
	  }
	
	
	public LoginDao() {
		
		this.connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
	}
	
	
	
	  public String checkLogin(String email, String password) {
	        String sqlUser = "SELECT Tipo FROM utenti WHERE Email = ? AND Password = ?";
	      
	        ResultSet res = null;
	        String returnePriv = null;

	        //Cerca nei volontari
	        try (Connection conn = connector.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sqlUser)) {

	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            res = stmt.executeQuery();

	            while (res.next()) {
	                String priv = res.getString("Tipo");
	                returnePriv = priv;
	              
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
       	 if( returnePriv != null) {
 			setTableUser(returnePriv);
       	 }
				return returnePriv;
	    }


	 
	    public int returnID(String email) {

	    	int resID = 0;
	    	String sql = "SELECT id_utente FROM utenti WHERE Email = ?";
	    	ResultSet res = null;
	    	try (Connection conn = connector.getConnection();
	                PreparedStatement stmt = conn.prepareStatement(sql)) {

	               stmt.setString(1, email);
	               res = stmt.executeQuery();

	               while (res.next()) {
	            	   resID = res.getInt("id_utente");
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
	    	
	   
	    	return resID;
	    	
	    }

	    
	  
	
}
