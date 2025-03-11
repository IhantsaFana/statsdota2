package model;

public class MatchStats {
    private int id;
    private int matchId;
    private int playerId;
    private int kills;
    private int deaths;
    private int assists;

    public MatchStats(int id, int matchId, int playerId, int kills, int deaths, int assists) {
        this.id = id;
        this.matchId = matchId;
        this.playerId = playerId;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
    }

    // Getters et Setters
    public int getId() { return id; }
    public int getMatchId() { return matchId; }
    public int getPlayerId() { return playerId; }
    public int getKills() { return kills; }
    public int getDeaths() { return deaths; }
    public int getAssists() { return assists; }
    
    public void setMatchId(int matchId) { this.matchId = matchId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public void setKills(int kills) { this.kills = kills; }
    public void setDeaths(int deaths) { this.deaths = deaths; }
    public void setAssists(int assists) { this.assists = assists; }

}
