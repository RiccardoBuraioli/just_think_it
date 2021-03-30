package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.Donazione;
import entity.DonazioneTab;

public class DonationDao {
	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";

    private List<DonazioneTab> listDon;
    private final Connector connector;
    private static final Logger logger = LoggerFactory.getLogger(DonationDao.class);
	
    
    
    
   public boolean modificaDonazione(int idDon) {
	   String sql = "call modifica_donazione(?)";

         eseguiQuery(idDon, sql);
		return false;
        
	   
   }


public void eseguiQuery(int idDon, String sql) {
	int rowAffected;
	try (Connection conn = connector.getConnection();
	      PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		 pstmt.setInt(1, idDon);
   
	     rowAffected = pstmt.executeUpdate();

	     if (rowAffected == 1) {
	         logger.debug(SUCCESS);
	     } else logger.debug(FAILED);


	 } catch (SQLException ex) {
	     logger.debug((ex.getMessage()));
     
	 }
}
    
    
   public int creaDonazione(Donazione dono ) {
   
	   		int rowAffected;
	   	

      	    String sql = "call crea_donazione(?,?,?,?,?)";

              try (Connection conn = connector.getConnection();
                   PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	  pstmt.setInt(1, dono.getIdCaritas() );
            	  pstmt.setInt(2, dono.getIdUtente());
            	  pstmt.setInt(3, dono.getTipologia());
            	  pstmt.setString(4,dono.getDescrizione());
            	  pstmt.setString(5, dono.getIndirizzo());
              	
              
                  rowAffected = pstmt.executeUpdate();

                  if (rowAffected == 1) {
                      logger.debug(SUCCESS);
                  } else logger.debug(FAILED);


              } catch (SQLException ex) {
                  logger.debug((ex.getMessage()));
           
              }
			return 0;
             
          
   }
    

   public List<DonazioneTab> visualizzaDonazioni(int codCaritas){
	   
	   	String sql = "call visualizza_donazioni(?) ";

		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, codCaritas );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   listDon.add(new DonazioneTab(res.getInt("cod_dona"),res.getInt("cod_volontario"), res.getString("tipo"), res.getString("descrizione"), res.getString("IndirizzoVolontario"), res.getString("consegnato")));
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
    	
    	
    	
    	
    	return this.listDon;
	   
   }
   
   
   
   
    
    public DonationDao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	listDon = new ArrayList<>();
    }


	public boolean cancellaDonazione(int idDon) {
		   String sql = "call cancella_donazione(?)";

	         eseguiQuery(idDon, sql);
			return false;
	        
	
	}
}
