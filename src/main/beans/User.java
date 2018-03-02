package main.beans;

/**
 * Functionality:
 */
public class User {
    private static User currentUser = new User();
    private int id;
    private String username;
    private String pass;
    private String fname;
    private String lname;
    private String email;
    private int role_id;

    private User(int id, String username, String pass, String fname, String lname, String email, int role_id) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.role_id = role_id;
    }

    private User() {

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(int id, String username, String pass, String fname, String lname, String email, int role_id){
        currentUser = new User(id, username, pass, fname, lname, email, role_id);
    }

    public String getUsername() {
        return username;
    }
    public String getPass() {
        return pass;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getEmail() {
        return email;
    }
    public int getRole_id() {
        return role_id;
    }
    public int getId() {
        return id;
    }
}
