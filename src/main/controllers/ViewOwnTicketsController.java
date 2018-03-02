package main.controllers;

import main.beans.Ticket;
import main.beans.User;
import main.services.LogInService;
import main.services.ViewOwnTicketsService;
import main.util.ResponseUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Functionality:
 */
public class ViewOwnTicketsController implements HttpController {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int author = req.getIntHeader("author");
        ArrayList<Ticket> list = ViewOwnTicketsService.viewOwnTickets(author);
        ResponseUtil.writeObjectToResponse(list, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //no post
    }
}
