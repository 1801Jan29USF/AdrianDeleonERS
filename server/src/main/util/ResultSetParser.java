package main.util;

import main.beans.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Functionality:
 */
public class ResultSetParser {
    public static ArrayList<Ticket> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            double amount = rs.getDouble(2);
            String submitTime = rs.getTimestamp(3).toString();
            String resolveTime = (rs.getTimestamp(4) != null) ? rs.getTimestamp(4).toString() : "";
            String desc = rs.getString(5);
            //File receipt = rs.getBlob(6);
            int author = rs.getInt(7);
            int resolver = (rs.getInt(8));
            int status = rs.getInt(9);
            int type = rs.getInt(10);
            tickets.add(new Ticket(id, amount, submitTime, resolveTime, desc, author, resolver, status, type));
        }
        return tickets;
    }
}
