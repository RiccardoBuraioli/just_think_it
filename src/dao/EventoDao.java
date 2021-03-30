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
import entity.EventTab;
import entity.PartecipaEvento;

public class EventoDao {

	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private List<EventTab> listEv;
    private static final Logger logger = LoggerFactory.getLogger(EventoDao.class);


    private final Connector connector;
	
	
    public EventoDao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	listEv = new ArrayList<>();
    }
	
    
    public List<EventTab> cercaEventi(int idShop){

	   	String sql = "call visualizza_tuoi_eventi(?) ";
		ResultSet res = null;
		int i = 0;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idShop );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   listEv.add(new EventTab(res.getString("NomeEvento"),res.getString("NomeCaritas"), res.getString("NoteEvento"), res.getFloat("PrezzoEvento"), res.getInt("numPartecipanti"), res.getInt("CodiceCaritas")));
	        	  
	        	   this.listEv.get(i).setStatoEvento(res.getString("Completato"));
	        	   this.listEv.get(i).setImportoRaggiunto(res.getFloat("Importo"));	        	 
	        	   this.listEv.get(i).setRapportoDenaro();
	        	  
	        	   i++;
	           }
	       } catch (SQLException ex) {
	           logger.debug(ex.getMessage());
	       } 
    	
    	
    	
    	
    	return listEv;
    	
    }
	
    
    public List<EventTab> cercaEventiCaritas(int idCar){

	   	String sql = "call visualizza_eventi_caritas(?) ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idCar );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   this.listEv.add(new EventTab( res.getInt("id") ,res.getString("NomeEvento"), res.getString("NoteEvento"), res.getFloat("PrezzoEvento"),res.getString("NomeNegozio"), res.getInt("numPartecipanti"), res.getInt("CodiceNegozio")));
	        	   EventTab temp = this.listEv.get(i);
	        	   logger.debug(temp.getNoteEvento());
	        	   temp.setStatoEvento(res.getString("Completato"));
	        	   temp.setImportoRaggiunto(res.getFloat("Importo"));
	        	 
	        	   temp.setRapportoDenaro();
	        	  i++;
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
    	
    	
    	
    	
    	return listEv;
    	
    }
    
    
    
    public EventTab creaEvento(EventTab event) {
		   	
    	int rowAffected;
  	    String sql = "call crea_evento(?,?,?,?,?,?)";

          try (Connection conn = connector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(1, event.getCodiceNegozio());
        	  pstmt.setString(2, event.getNomeEvento());
        	  pstmt.setString(3, event.getNoteEvento());
        	  pstmt.setString(4, event.getTipoEvento());
        	  pstmt.setFloat(5,event.getPrezzoEvento());
        	  
          	  pstmt.setInt(6, event.getIdCaritas());
           
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  logger.debug(SUCCESS);
              } else logger.debug(FAILED);


          } catch (SQLException ex) {
              logger.debug((ex.getMessage()));
          }
		    	
    	
    	return event;
    	
    }
    
   public boolean creaPartecipazione(PartecipaEvento partepaEvento) {
	   int rowAffected;
  	
 	    String sql = "call partecipa_evento(?,?,?)";

         try (Connection conn = connector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	       	  pstmt.setInt(1, partepaEvento.getcodice());
	       	  pstmt.setInt(2, partepaEvento.getVolo());
	       	  pstmt.setFloat(3,partepaEvento.getImporto());
     
             rowAffected = pstmt.executeUpdate();

             if (rowAffected == 1) {
                 logger.debug(SUCCESS);
                 return false;
             } else {
            	 logger.debug(FAILED);             
            	 return true;
             }


         } catch (SQLException ex) {
             logger.debug((ex.getMessage()));
         }
		    	
   	
   	return false;
	   
   }
    
   
   public boolean deliteEvent(String evento) {
	   
	   int rowAffected;
 	
	    String sql = "call cancella_evento(?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	       	  pstmt.setString(1, evento);
      
            rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            } else { logger.debug(FAILED); return false;}


        } catch (SQLException ex) {
            logger.debug((ex.getMessage()));
        }
		    	
        return true;
        
   }
   
   
   public boolean modificaEvento(int idEve) {
	   
	   
	   int rowAffected;
 	
	    String sql = "call modifica_evento(?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	       	  pstmt.setInt(1, idEve);
      
            rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            } else { logger.debug(FAILED); return false;}


        } catch (SQLException ex) {
            logger.debug((ex.getMessage()));
        }
		    	
        return true;
        
	   
	   
	   
   }
   
   
}
