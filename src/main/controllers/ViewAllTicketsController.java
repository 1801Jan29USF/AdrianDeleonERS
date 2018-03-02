package main.controllers;

import main.beans.Ticket;
import main.services.ViewAllTicketsService;
import main.services.ViewOwnTicketsService;
import main.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Functionality:
 */
public class ViewAllTicketsController implements HttpController{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Ticket> list = ViewAllTicketsService.viewAllTickets();
        ResponseUtil.writeObjectToResponse(list, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //no post
    }
}
