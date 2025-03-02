package model;

public class MatchStats {
    private int matchId;
    private int playerId;
    private int kills;
    private int deaths;
    private int assists;
    private boolean firstKill;

    public MatchStats(int matchId, int playerId, int kills, int deaths, int assists, boolean firstKill) {
        this.matchId = matchId;
        this.playerId = playerId;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.firstKill = firstKill;
    }

    public int getMatchId() { return matchId; }
    public int getPlayerId() { return playerId; }
    public int getKills() { return kills; }
    public int getDeaths() { return deaths; }
    public int getAssists() { return assists; }
    public boolean isFirstKill() { return firstKill; }
}
