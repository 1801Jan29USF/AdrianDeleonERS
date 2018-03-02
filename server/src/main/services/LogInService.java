package main.services;

import main.dao.UserDAO;

/**
 * Functionality:
 */
public class LogInService{
    public static boolean login(String user, String pass){
        return UserDAO.logIn(user, pass);
    }
}
