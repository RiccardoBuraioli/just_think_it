
/*
package dao;



import entity.VolunteerUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connector.Connector;

public class Utilities {

    private Connector connector;

    public Utilities(Connector connector) {
        this.connector = connector;
    }
    
    
    
    
    
    

    public boolean checkIfBanned(String email) {
        String sql = "SELECT Email FROM bannedUser WHERE Email = ? ";
        ResultSet resultSet = null;
        Boolean res = false;


        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String mail = resultSet.getString("Email");
                if (mail.equals(email)) {
                    res = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return res;
    }

    public String checkEmail(String email) {
        String sql = "SELECT Email FROM utenti WHERE Email = ?";
        ResultSet res = null;
        String returnedEmail = "";


        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.setString(3, email);
            res = stmt.executeQuery();

            while (res.next()) {
                String mail = res.getString("Email");
                if (mail.equals(email)) {
                    returnedEmail = email;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnedEmail;
    }

    public boolean checkEmailBoolean(String email) {
        String sql = "SELECT Email FROM utenti WHERE Email = ?";
        ResultSet resultSet = null;
        Boolean res = false;


        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.setString(3, email);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String mail = resultSet.getString("Email");
                if (mail.equals(email)) {
                    res = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return res;
    }



    public boolean checkPassword(String email, String password) {
        String sql = "SELECT Password FROM utenti WHERE Email = ?";
        ResultSet res = null;
        boolean check = false;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.setString(3, email);

            res = stmt.executeQuery();

            while (res.next()) {
                String psw = res.getString("Password");
                if (psw.equals(password)) {
                    check = true;

                } else check = false;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return check;
    }


    public List<String> getAllBanned() {
        List<String> banned = new ArrayList<>();

        String sql = "SELECT * FROM bannedUser";

        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {

                String email = resultSet.getString("Email");
                banned.add(email);
            }
            return banned;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalStateException("error fetching users", ex);
        }
    }

    public void printBannedInTab(List<String> banned){
        if (banned.isEmpty()){
            System.out.println("\n\t ***** NO BANNED USERS *****\n");
        }
        else {
            System.out.println("\n" + "Banned Users Email:");
            for (String str : banned) {
                System.out.println(str + "\n");
            }
        }
    }

}*/
