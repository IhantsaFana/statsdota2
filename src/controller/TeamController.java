package controller;

import model.Team;
import model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamController {
    private Connection connection;

    public TeamController() {
        this.connection = DatabaseConnection.connect();
    }

    public void addTeam(String name) {
        String query = "INSERT INTO teams (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("✅ Équipe ajoutée !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM teams";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                teams.add(new Team(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }
}
