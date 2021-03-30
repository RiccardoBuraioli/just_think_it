package dao;

import java.sql.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import connector.Connector;
import entity.CoordinateMap;
import entity.ShopUser;


public class ShopRepository {

    private final Connector connector;
    private static final Logger logger = LoggerFactory.getLogger(ShopRepository.class);

    
    public ShopRepository() {
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }



    public int insertShop(ShopUser shopUser) {

        ResultSet rs = null;
        int shopID = 0;

        String sql = "call registrazione_negozio(?,?,?,?,?,?,?,?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
        	pstmt.setString(1,shopUser.getEmail());
        	pstmt.setString(2, shopUser.getPassword());        	
        	pstmt.setString(3, shopUser.getNome());
        	pstmt.setString(4, shopUser.getIndirizzo());
        	pstmt.setString(5, shopUser.getCitta());
            pstmt.setString(6,shopUser.getTipologia());
            pstmt.setString(7,"Negozio");
            pstmt.setString(8,shopUser.getRecapitoTel());
       


            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    shopID = rs.getInt(1);
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
        return shopID;
    }

  
   


    public ShopUser getShopByID(int id) {

        String sql = "call trova_negozio(?)";
        ResultSet rs = null;
        ShopUser shopUser = new ShopUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) { 
            	CoordinateMap coord = new CoordinateMap(Double.parseDouble(rs.getString("latitudine")),Double.parseDouble(rs.getString("longitudine")), id);
            	shopUser.setId(id);
                shopUser.setNome(rs.getString("NomeNegozio"));
                shopUser.setCoord(coord);
                shopUser.setIndirizzo(rs.getString("IndirizzoNeg"));
                shopUser.setTipologia(rs.getString("Tipologia"));
                shopUser.setRecapitoTel(rs.getString("RecapitoTel"));
            }

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        } return shopUser;
    }


   
    public void deleteNegozio(int id) {
     
    	UserDao userd= new UserDao();
    	userd.deleteVolunteer(id);
      
    }

 
}
