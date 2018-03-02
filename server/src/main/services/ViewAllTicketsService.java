package main.services;

import main.beans.Ticket;
import main.dao.TicketDAO;

import java.util.ArrayList;

/**
 * Functionality:
 */
public class ViewAllTicketsService {
    public static ArrayList<Ticket> viewAllTickets(){
        return TicketDAO.viewAllTickets();
    }
    public static ArrayList<Ticket> viewPendingTickets(){
        return TicketDAO.viewAllTickets(0);
    }
}
