package main.beans;

/**
 * Functionality:
 */
public class Ticket {
    private int id;
    private int author;
    private int resolver;
    private int status_id;
    private int type_id;
    private double amount;
    private String submitTime;
    private String resolveTime;
    private String desc;

    public Ticket(int id, double amount, String submitTime, String resolveTime, String desc, int author, int resolver, int status_id, int type_id) {
        this.id = id;
        this.amount = amount;
        this.submitTime = submitTime;
        this.resolveTime = resolveTime;
        this.desc = desc;
        this.author = author;
        this.resolver = resolver;
        this.status_id = status_id;
        this.type_id = type_id;
    }

    public Ticket(double amount, String desc, int author, int type_id) {
        this.amount = amount;
        this.desc = desc;
        this.author = author;
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }
    public int getAuthor() {
        return author;
    }
    public int getResolver() {
        return resolver;
    }
    public String getSubmitTime() {
        return submitTime;
    }
    public String getResolveTime() {
        return resolveTime;
    }
    public double getAmount() {
        return amount;
    }
    public String getDesc() {
        return desc;
    }
    public int getStatus_id() {
        return status_id;
    }
    public int getType_id() {
        return type_id;
    }
}
