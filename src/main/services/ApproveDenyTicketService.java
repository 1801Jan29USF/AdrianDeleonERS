package main.services;

import main.dao.TicketDAO;

/**
 * Functionality:
 */
public class ApproveDenyTicketService {
    public static boolean approve(int tk_id){
        return TicketDAO.approveDenyTicket(tk_id, true);
    }
    public static boolean deny(int tk_id){
        return TicketDAO.approveDenyTicket(tk_id, false);
    }
}
