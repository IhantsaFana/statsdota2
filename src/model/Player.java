package model;

public class Player {
    private int id;
    private String name;
    private int teamId;
    private int position;

    public Player(int id, String name, int teamId, int position) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.position = position;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTeamId() { return teamId; }
    public int getPosition() { return position; }

    public void setName(String name) { this.name = name; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
    public void setPosition(int position) { this.position = position; }
}
