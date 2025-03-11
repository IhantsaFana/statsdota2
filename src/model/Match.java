package model;

import java.util.Date;

public class Match {
    private int id;
    private Date date;

    public Match(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

}
