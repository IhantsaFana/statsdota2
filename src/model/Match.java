package model;

import java.util.Date;

public class Match {
    private int id;
    private Date datePlayed;

    public Match(int id, Date datePlayed) {
        this.id = id;
        this.datePlayed = datePlayed;
    }

    public int getId() { return id; }
    public Date getDatePlayed() { return datePlayed; }

    public void setDatePlayed(Date datePlayed) { this.datePlayed = datePlayed; }
}
