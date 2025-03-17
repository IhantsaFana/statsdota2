package dao;

import model.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerDAO {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Map<String, Player> getTopStatsPlayers() throws SQLException {
        Map<String, Player> topPlayers = new HashMap<>();
        String query = """
            SELECT player_id, 'Kill' AS stat_type, SUM(kills) AS total 
            FROM match_stats 
            GROUP BY player_id 
            ORDER BY total DESC 
            LIMIT 1
            UNION
            SELECT player_id, 'Death' AS stat_type, SUM(deaths) AS total 
            FROM match_stats 
            GROUP BY player_id 
            ORDER BY total DESC 
            LIMIT 1
            UNION
            SELECT player_id, 'Assist' AS stat_type, SUM(assists) AS total 
            FROM match_stats 
            GROUP BY player_id 
            ORDER BY total DESC 
            LIMIT 1;
            """;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int playerId = rs.getInt("player_id");
                String statType = rs.getString("stat_type");

                // Récupérer les informations du joueur
                Player player = getPlayerById(playerId);
                if (player != null) {
                    topPlayers.put(statType, player);
                }
            }
        }
        return topPlayers;
    }
    
	public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, team_id, position) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getTeamId());
            stmt.setInt(3, player.getPosition());
            stmt.executeUpdate();
            System.out.println("✅ Joueur ajouté !");
        }
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("team_id"), rs.getInt("position")));
            }
        }
        return players;
    }
    
    public Player getPlayerById(int playerId) throws SQLException {
        String query = "SELECT * FROM players WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("team_id"),
                        rs.getInt("position")
                    );
                }
            }
        }
        return null;
    }

}
