package controller;

import model.Player;
import model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private Connection connection;

    public PlayerController() {
        this.connection = DatabaseConnection.connect();
    }

    public void addPlayer(String name, int teamId) {
        String query = "INSERT INTO players (name, team_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, teamId);
            stmt.executeUpdate();
            System.out.println("✅ Joueur ajouté !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("team_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }
}
