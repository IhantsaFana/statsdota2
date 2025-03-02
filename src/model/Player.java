package model;

public class Player {
    private int id;
    private String name;
    private int teamId;

    public Player(int id, String name, int teamId) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTeamId() { return teamId; }

    public void setName(String name) { this.name = name; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
}
