package main.dao;

import main.util.ConnectionUtility;
import main.beans.User;

import java.sql.*;

/**
 * Functionality:
 */
public class UserDAO {
    //C
//    public static boolean registerUser(String user, String pass, String fname, String lname, String email){
//        try (Connection c = ConnectionUtility.getConnection()){
//            PreparedStatement ps = c.prepareStatement(
//                    "INSERT INTO ers_users(u_user, u_pass, u_fname, u_lname, u_email) " +
//                            "VALUES(?,?,?,?,?)");
//            ps.setString(1, user);
//            ps.setString(2, pass);
//            ps.setString(3, fname);
//            ps.setString(4, lname);
//            ps.setString(5, email);
//            return ps.executeQuery().rowInserted();
//        } catch (SQLException e) {
//            return false;
//        }
//    }
    //R
    public static boolean logIn(String username, String pass){
        try (Connection c = ConnectionUtility.getConnection()){
            System.out.println("logging in");
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM ers_users " +
                            "WHERE u_user = ?" +
                            "AND u_pass = ?");
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                User.setCurrentUser(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //U
//    public boolean updateAccountPassword(String user, String oldPass, String newPass){
//        return false;
//    }
//    public boolean updateAccountName(String user, String pass, String newFirstName, String newLastName){
//        return false;
//    }
//    public boolean updateAccountEmail(String user, String pass, String newEmail){
//        return false;
//    }
    //D
//    public void removeAccount(String user, String pass){
//
//    }
}
