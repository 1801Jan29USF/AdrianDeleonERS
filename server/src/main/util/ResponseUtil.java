package main.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.beans.Ticket;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Functionality:
 */

public class ResponseUtil {
    public static void writeObjectToResponse(Object obj, HttpServletResponse resp) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(obj);

        // actually write the json to the body of the request
        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
}