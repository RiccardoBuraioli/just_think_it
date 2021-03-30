package dao;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.VolunteerUser;

//CRUD create read update delete

public class VolunteerRepository {

    private final Connector connector;
    private static final Logger logger = LoggerFactory.getLogger(VolunteerRepository.class);



    public VolunteerRepository() {
    	 this.connector= new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }

   


    public VolunteerUser getVolunteerByID(int id) {

        String sql = "SELECT  Nome, Cognome, Indirizzo, RecapitoTel, CartaDiCredito FROM volontari WHERE ID=?";
        ResultSet rs = null;
        VolunteerUser vUser = new VolunteerUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

            	vUser.setId(id);
                vUser.setNome(rs.getString("Nome"));
                vUser.setCognome(rs.getString("Cognome"));
                vUser.setIndirizzo(rs.getString("Indirizzo"));
             
                vUser.setRecapitoTel(rs.getString("RecapitoTel"));
                vUser.setCc(rs.getString("CartaDiCredito"));
            }

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        } return vUser;
    }
    



	public int insertVolunteer(VolunteerUser volunteerUser) {

        ResultSet rs = null;
        int volunteerID = 0;

        String sql = "call registrazione_volontario(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	pstmt.setString(1, volunteerUser.getEmail());
        	pstmt.setString(2, volunteerUser.getPassword());
        	pstmt.setInt(3, 1);
        	pstmt.setString(4,  volunteerUser.getNascita());
        	pstmt.setString(5, volunteerUser.getCognome());
        	pstmt.setString(6, volunteerUser.getRecapitoTel());
        	pstmt.setString(7, volunteerUser.getIndirizzo());
        	pstmt.setString(8, volunteerUser.getCc());
        	pstmt.setString(9,volunteerUser.getCitta());
        	pstmt.setString(10, volunteerUser.getNome());
          
          
   
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    volunteerID = rs.getInt(1);
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

        return volunteerID;
    }


   

    public void deleteVolunteer(int id) {
    	UserDao userd= new UserDao();
    	userd.deleteVolunteer(id);
    }

  


}
