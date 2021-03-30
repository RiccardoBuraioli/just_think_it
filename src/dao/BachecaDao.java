package dao;

import connector.Connector;
import entity.Necessita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class BachecaDao {
	Connector connector;
	List<Necessita> necessita;
    private static final Logger logger = LoggerFactory.getLogger(BachecaDao.class);

	
	
	
	public BachecaDao() {
		
		
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	necessita = new ArrayList<>();
	}
	
	
	
	public List<Necessita> visualizzaNecessita(int idCaritas) {
		
	   	String sql = "call visualizza_necessità(?) ";
	
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idCaritas );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   necessita.add(new Necessita(res.getInt("id_necessità"), res.getString("tipologia"),res.getString("richiesta"), res.getString("urgenza")));
		       
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
		
	return necessita;
		
		
		
	}
	
	public int creaNecessita(Necessita necessita, int codCaritas) {
		 ResultSet rs = null;
	        int necID = 0;

	        String sql = "call crea_necessità(?,?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	           
	        	pstmt.setString(1,necessita.getTipologia());
	        	pstmt.setString(2, necessita.getUrgenza());        	
	        	pstmt.setString(3, necessita.getDescrizione());
	        	pstmt.setInt(4, codCaritas);

	            int rowAffected = pstmt.executeUpdate();
	            if (rowAffected == 1) {

	                rs = pstmt.getGeneratedKeys();
	                if (rs.next())
	                    necID = rs.getInt(1);
	            }
	        } catch (SQLException ex) {
	        	  logger.debug(ex.getMessage());	
	        	  } finally {
	            try {
	                if (rs != null) rs.close();
	            } catch (SQLException e) {
	            	  logger.debug(e.getMessage());	            }
	        }
	        return necID;
	}
	
	
	public boolean eliminaNecessita(int nece) {
		 
		  
		   int rowAffected;
	        String sql = "call elimina_necessità(?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	           
	        	pstmt.setInt(1,nece);
	        	

	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	            	logger.debug("SUCCESS!");
	            } else { logger.debug("FAIlED"); return false;}


	        } catch (SQLException ex) {
	        	logger.debug(ex.getMessage());
	        }
			    	
	        return true;
	        
	}
	
}
