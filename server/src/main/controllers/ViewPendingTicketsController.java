package main.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import main.beans.Ticket;
import main.services.ApproveDenyTicketService;
import main.services.ViewAllTicketsService;
import main.util.ResponseUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Functionality:
 */
public class ViewPendingTicketsController implements HttpController {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Ticket> tickets = ViewAllTicketsService.viewPendingTickets();
        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(tickets).getAsJsonArray();
        res.getWriter().print(myCustomArray);
    }

    //approve deny
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
        JSONObject jsonObject;
        int id = -1;
        boolean accept = false;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(json);
            id = Integer.parseInt(String.valueOf(jsonObject.get("tk_id")));
            accept = Boolean.parseBoolean(String.valueOf(jsonObject.get("bool")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(accept){
            if(ApproveDenyTicketService.approve(id)){
                ResponseUtil.writeObjectToResponse("good", res);
            }
            else{
                res.setStatus(401);
            }
        }
        else{
            if (ApproveDenyTicketService.deny(id)) {
                ResponseUtil.writeObjectToResponse("good", res);
            }
            else{
                res.setStatus(401);
            }
        }
    }

}
