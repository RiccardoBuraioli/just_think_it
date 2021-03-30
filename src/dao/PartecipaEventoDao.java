package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;

import entity.PartecipantiEvento;


public class PartecipaEventoDao {
	 private final Connector connector;
	 private PartecipantiEvento partecipanti;
	 private static final Logger logger = LoggerFactory.getLogger(PartecipaEventoDao.class);

	 
	 
	public PartecipaEventoDao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	partecipanti = new PartecipantiEvento();
	}

	public PartecipantiEvento contaPartecipanti(int idEvento) {
		
		
	   	String sql = "call visualizza_tuoi_eventi(?) ";
	   
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idEvento );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	 
	        	   partecipanti.setCount(res.getInt("count"));
	        	   partecipanti.setImportoTotale(res.getFloat("importoTotale"));
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
    	
    	
    	
    	
		
		
		return partecipanti;
		
	}
	
}
