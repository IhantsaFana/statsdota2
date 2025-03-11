package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchStatsDAO {
    private Connection connection;

    public MatchStatsDAO(Connection connection) {
        this.connection = connection;
    }

    // 1. Qui a le plus de kills lors des matchs ?
    public List<Map<String, Object>> getTopKillers() throws SQLException {
        String query = """
            SELECT player_id, SUM(kills) AS total_kills 
            FROM match_stats 
            GROUP BY player_id 
            ORDER BY total_kills DESC 
            LIMIT 1
        """;
        List<Map<String, Object>> topKillers = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Map<String, Object> playerData = new HashMap<>();
                playerData.put("player_id", rs.getInt("player_id"));
                playerData.put("total_kills", rs.getInt("total_kills"));
                topKillers.add(playerData);
            }
        }
        return topKillers;
    }

    // 2. Tableau des stats d'une équipe (top kills, deaths, assists)
    public List<Map<String, Object>> getTeamStats(int teamId) throws SQLException {
        String query = """
            SELECT p.name, SUM(ms.kills) AS total_kills, SUM(ms.deaths) AS total_deaths, SUM(ms.assists) AS total_assists
            FROM players p
            JOIN match_stats ms ON p.id = ms.player_id
            WHERE p.team_id = ?
            GROUP BY p.id, p.name
            ORDER BY total_kills DESC
        """;

        List<Map<String, Object>> teamStats = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, teamId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> playerStats = new HashMap<>();
                playerStats.put("name", rs.getString("name"));
                playerStats.put("kills", rs.getInt("total_kills"));
                playerStats.put("deaths", rs.getInt("total_deaths"));
                playerStats.put("assists", rs.getInt("total_assists"));
                teamStats.add(playerStats);
            }
        }
        return teamStats;
    }
    
    // public List<Map<String, Object>> beStats = new ArrayList<>();

    // 🔥 3. L'équipe avec le plus de First Kills
    public int getTopFirstKillTeam() throws SQLException {
        String query = """
            SELECT p.team_id, COUNT(*) AS first_kills
            FROM match_stats ms
            JOIN players p ON ms.player_id = p.id
            WHERE ms.kills = (SELECT MAX(ms2.kills) FROM match_stats ms2 WHERE ms2.match_id = ms.match_id)
            GROUP BY p.team_id
            ORDER BY first_kills DESC
            LIMIT 1
        """;

        int bestTeamId = -1;
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                bestTeamId = rs.getInt("team_id");
            }
        }
        return bestTeamId;
    }
}
