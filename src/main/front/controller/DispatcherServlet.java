package main.front.controller;

import main.controllers.*;
import org.apache.catalina.servlets.DefaultServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Functionality:
 */
public class DispatcherServlet extends DefaultServlet{

    private LogInController lic = new LogInController();
    private SubmitTicketController stc = new SubmitTicketController();
    private ViewOwnTicketsController votc = new ViewOwnTicketsController();
    private ViewPendingTicketsController vptc = new ViewPendingTicketsController();
    private ViewAllTicketsController vatc = new ViewAllTicketsController();

    @Override
    public void init() throws ServletException {
        System.out.println("init");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers",
                "Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept, author");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType("application/json");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String url = req.getPathInfo();
        if(url.contains("/ERS-Project")){
            url = req.getPathInfo().substring("/ERS-Project".length());
        }
        if(url.startsWith("/static/")){
            super.doGet(req, res);
        }
        if(url.startsWith("/my-tickets")){//good
            votc.doGet(req, res);
        }
        else if(url.startsWith("/all-tickets")){//good
            vatc.doGet(req, res);
        }
        else{
            req.getRequestDispatcher("static/index.html").forward(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String url = req.getPathInfo();
        if(url.contains("/ERS-Project")){
            url = req.getPathInfo().substring("/ERS-Project".length());
        }
        if(url.startsWith("/login")){//good
            lic.doPost(req, res);
        }
        else if(url.startsWith("/submit-ticket")){//good
            stc.doPost(req, res);
        }
        else if(url.startsWith("/pending-tickets")){//good
            vptc.doPost(req, res);
        }
        else{
            req.getRequestDispatcher("static/index.html").forward(req, res);
        }
    }
}
