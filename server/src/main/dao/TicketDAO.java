package main.dao;

import main.util.ConnectionUtility;
import main.beans.Ticket;
import main.util.ResultSetParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Functionality:
 */
public class TicketDAO {
    //C
    public static boolean submitTicket(int author, double amount, String desc, int type_id){
        System.out.println("submitting");
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO ers_tickets(tk_id, tk_amount, tk_description, tk_author, tk_type_id) " +
                            "VALUES(user_seq.nextval,?,?,?,?)");
            ps.setDouble(1, amount);
            ps.setString(2, desc);
            ps.setInt(3, author);
            ps.setInt(4, type_id);
            int succ = ps.executeUpdate();
            System.out.println(succ);
            return succ > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //R
    public static ArrayList<Ticket> viewOwnTickets(int author){
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM ers_tickets " +
                            "WHERE tk_author = ?");
            ps.setInt(1, author);
            ResultSet rs = ps.executeQuery();
            return ResultSetParser.parseResultSet(rs);
        } catch (SQLException e) {
            return null;
        }
    }
    public static ArrayList<Ticket> viewAllTickets(){
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM ers_tickets");
            ResultSet rs = ps.executeQuery();
            return ResultSetParser.parseResultSet(rs);
        } catch (SQLException e) {
            return null;
        }
    }
    public static ArrayList<Ticket> viewAllTickets(int status){
        ArrayList<Ticket> tickets = new ArrayList<>();
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement(
                    "SELECT * FROM ers_tickets " +
                            "WHERE tk_status_id = ?");
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tickets.add(new Ticket(
                        rs.getInt("tk_id"),
                        rs.getDouble("tk_amount"),
                        rs.getTimestamp("tk_submitted").toString(),
                        (rs.getTimestamp("tk_resolved") != null) ? rs.getTimestamp("tk_resolved").toString() : "",
                        rs.getString("tk_description"),
                        rs.getInt("tk_author"),
                        rs.getInt("tk_resolver"),
                        rs.getInt("tk_status_id"),
                        rs.getInt("tk_type_id")));
            }
            return tickets;
        } catch (SQLException e) {
            return null;
        }
    }
    //U
    public static boolean approveDenyTicket(int tk_id, boolean approved){
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE ers_tickets " +
                            "SET tk_status_id = ? " +
                            "WHERE tk_id = ?");
            int newStatus = (approved) ? 1 : 2;
            ps.setInt(1, newStatus);
            ps.setInt(2, tk_id);
            int succ = ps.executeUpdate();
            System.out.println(succ);
            return succ > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //D
    //we do not delete tickets from the database

}
