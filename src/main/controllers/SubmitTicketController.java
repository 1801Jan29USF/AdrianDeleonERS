package main.controllers;

import main.services.SubmitTicketService;
import main.util.ResponseUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Functionality:
 */
public class SubmitTicketController implements HttpController {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //no get
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("stc post");
        String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
        System.out.println(json);
        JSONObject jsonObject;
        String desc = "";
        double amount = -1;
        int type_id = -1, author = -1;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(json);
            author = Integer.parseInt(jsonObject.get("author").toString());
            desc = (String) jsonObject.get("desc");
            amount = Double.parseDouble(jsonObject.get("amount").toString());
            type_id = Integer.parseInt(jsonObject.get("type").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!SubmitTicketService.submitTicket(author, amount, desc, type_id)){
            res.setStatus(401);
        }
        else{
            ResponseUtil.writeObjectToResponse("good", res);
        }
    }
}
