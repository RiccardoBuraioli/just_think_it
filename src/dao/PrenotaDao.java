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
import entity.PartecipaTurno;
import entity.Orario;
import entity.Turno;
import entity.TurnoTab;

public class PrenotaDao {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private static final Logger logger = LoggerFactory.getLogger(PrenotaDao.class);

    
	private String[] resGiorno = {null, null, null, null, null, null, null, null};
	
	public PrenotaDao() {
		
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
        
	}
	
		
		
	
	
	public String[] visualizzaGiorni() {
		
		
	   	String sql = "Select * from giorni order by num_giorno ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           res = stmt.executeQuery();
	           
	
	           
	           while (res.next()) {
	        	   resGiorno[i] = res.getString("Nome");
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
		return resGiorno;
		
		
		
	}
	
	
	

	public List<Orario> visualizzaOrario() {
		List<Orario> oraArrayList = new ArrayList<>();
		ResultSet res = null;
		String sql = "Select ora_inizio, ora_fine from orari ";
		
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
			
			res = stmt.executeQuery();

			while (res.next()) {
				oraArrayList.add(new Orario(res.getString("ora_inizio"), res.getString("ora_fine")));
			
			 } } catch (SQLException ex) {
		            logger.debug(ex.getMessage());
		        } finally {
		            try {
		                if (res != null) res.close();
		            } catch (SQLException e) {
		                logger.debug(e.getMessage());
		            }
		        }
		
		return oraArrayList;

	}
	
	
	
	public boolean partecipazioneTurno(PartecipaTurno turno) {
	
    	int rowAffected;
  	    String sql = "call prenota_turno(?,?,?, ?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(3, turno.getCodiceCaritas());
        	  pstmt.setInt(1, turno.getCodiceVolontario());
        	  pstmt.setInt(2, turno.getCodiceTurno());
        	  pstmt.setString(4, turno.getCurriculum());
           
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  logger.debug(SUCCESS);
              } else logger.debug(FAILED);


          } catch (SQLException ex) {
              logger.debug((ex.getMessage()));
          }
		    	
   
    	return true;
    	
	}
	
	
	public int trovaTurno(Turno turno ) {
		String sql;
		
		int id = 0;
		
	   	sql = "call trova_id_turno(?,?,?)";
	
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setString(1, turno.getGiorno());
	           stmt.setString(2, turno.getOrai());
	           stmt.setString(3, turno.getOraf());
	           res = stmt.executeQuery();
	
	           while (res.next()) {
	        	  id = res.getInt("id_turno");
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

		return id;
		
	}





	public List<TurnoTab> visualizzaTurni(int idCaritas) {
		String 	sql = "call Visualizza_turno_caritas(?)";
		ResultSet res = null;
		List<TurnoTab> listTurn = new ArrayList<>();
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setInt(1,idCaritas);
	       
	           res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   listTurn.add(new TurnoTab(res.getInt("numMaxParte"), res.getInt("id_turno") ,res.getInt("codCar"),res.getString("Giorno"), res.getString("OraInizio"),res.getString("OraFine"),  res.getString("Note"),  res.getInt("Partecipanti")));
	        	 
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
		return listTurn;
	}
	
	
	
	public boolean cancellaTurno(int idTurn) {
		   int rowAffected;
		    String sql = "call cancella_turno(?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, idTurn);
	      
	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	                logger.debug(SUCCESS);
	            } else { logger.debug(FAILED); return false;}


	        } catch (SQLException ex) {
	            logger.debug((ex.getMessage()));
	        }
			    	
	        return true;
	
	}
	
	
	
	public boolean creaTurno(int codCar,String nomGiorn, String newNote,String oraIniz, String oraFin, int numParte) {
		  int rowAffected;
	 	
		    String sql = "call crea_turno(?,?,?,?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, codCar);
		       	  pstmt.setString(2, newNote);
		       	  pstmt.setString(3, oraIniz);
		       	  pstmt.setString(4, oraFin);
		       	  pstmt.setInt(5, numParte);
		       	  pstmt.setString(6, nomGiorn);


	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	                logger.debug(SUCCESS);
	            } else { logger.debug(FAILED); return true;}


	        } catch (SQLException ex) {
	            logger.debug((ex.getMessage()));
	        }
		return false;
		
	}
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		
		   int rowAffected;
	 	
		    String sql = "call modifica_turno(?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, idTurn);
		       	  pstmt.setInt(2, codCar);
		       	  pstmt.setString(3, newNote);
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
