package main.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Functionality:
 */
public interface HttpController {
    void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
    void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
