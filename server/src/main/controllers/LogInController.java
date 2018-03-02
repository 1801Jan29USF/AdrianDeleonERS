package main.controllers;

import main.beans.User;
import main.services.LogInService;
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
public class LogInController implements HttpController {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //no get
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
        JSONObject jsonObject;
        String user = "", pass = "";
        try {
            jsonObject = (JSONObject) new JSONParser().parse(json);
            user = (String) jsonObject.get("user");
            pass = (String) jsonObject.get("pass");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!LogInService.login(user, pass)){
            res.setStatus(401);
        }
        else{
            if(User.getCurrentUser().getRole_id() == 0){
                ResponseUtil.writeObjectToResponse(User.getCurrentUser(), res);
            }
            else if(User.getCurrentUser().getRole_id() == 1){
                ResponseUtil.writeObjectToResponse(User.getCurrentUser(), res);
            }
        }
    }
}
