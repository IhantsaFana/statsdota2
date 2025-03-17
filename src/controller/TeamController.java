package controller;

import dao.TeamDAO;
import model.Team;
import model.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TeamController {
    private TeamDAO teamDAO;

    public TeamController() {
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            this.teamDAO = new TeamDAO(connection);
        } else {
            throw new RuntimeException("❌ Erreur de connexion à la base de données");
        }
    }

    // Ajoute une équipe et retourne true si réussi
    public boolean addTeam(String name) {
        try {
            Team team = new Team(0, name);
            teamDAO.addTeam(team);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retourne la liste de toutes les équipes
    public List<Team> getAllTeams() {
        try {
            return teamDAO.getAllTeams();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
