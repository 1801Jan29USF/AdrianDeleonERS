package main.services;

import main.beans.Ticket;
import main.dao.TicketDAO;

import java.util.ArrayList;

/**
 * Functionality:
 */
public class ViewOwnTicketsService {
    public static ArrayList<Ticket> viewOwnTickets(int author){
        return TicketDAO.viewOwnTickets(author);
    }
}
