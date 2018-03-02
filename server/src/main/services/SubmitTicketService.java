package main.services;

import main.dao.TicketDAO;

/**
 * Functionality:
 */
public class SubmitTicketService {
    public static boolean submitTicket(int author, double amount, String desc, int type_id) {
        return amount > 0 && TicketDAO.submitTicket(author, amount, desc, type_id);
    }
}
