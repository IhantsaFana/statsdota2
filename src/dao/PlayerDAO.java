package dao;

import model.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
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
}
