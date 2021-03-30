package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.EmailEntity;

public class EmailDao {
	Connector connector;
	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private List<EmailEntity> emailList;
    private static final Logger logger = LoggerFactory.getLogger(EmailDao.class);

	
	public EmailDao() {
    	this.connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
	}
	
	
	public int inviaEmail(EmailEntity email) {

   		int rowAffected;
  	    String sql = "call inserisci_email(?,?,?,?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setString(1, email.getIdMittente() );
        	  pstmt.setString(2, email.getIdDestinatario());
        	  pstmt.setString(3, email.getMessaggio());
        	  pstmt.setString(4,email.getOggetto());
        	
          	
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  logger.debug(SUCCESS);
              } else logger.debug(FAILED);


          } catch (SQLException ex) {
              logger.debug((ex.getMessage()));
          }
		
          
          return 0;
         
      
		
		
	}
	
	
	
	
	public List<EmailEntity> visualizzaEmail(String idUtente){
	
	 	String sql = "call visuallizza_email(?) ";
	 	ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1,idUtente );

	           res = stmt.executeQuery();
	           
	
	           
	           while (res.next()) {
	        	   emailList.add( new EmailEntity(res.getInt("id_email"), res.getString("messaggio"), res.getString("oggetto")));
	        	   
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
	
		
		
		
		
		return emailList;
		
		
		
	}
	
	
	public String[] visualizzaMittenteDestinatario(int idDest, int idMit) {
		
		String sql = "call visualizza_mittente_destinatario(?,?,?,?) ";
	   	String[] emailMD = {"",""};
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            CallableStatement stmt = conn.prepareCall((sql))) {
				stmt.setInt(1, idMit );
				stmt.setInt(2, idDest );
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

	          res = stmt.executeQuery(); 
	         
	            emailMD[0] = stmt.getString("email_m");
	            emailMD[1] = stmt.getString("email_d");
	            
	            
	       } catch (SQLException ex) {
	           logger.debug(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               logger.debug(e.getMessage());
	           }
	       }
	
		
	
		return emailMD;
	}
	
	
	
}
