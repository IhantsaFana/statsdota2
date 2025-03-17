package controller;

import dao.MatchStatsDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MatchStatsController {
    private MatchStatsDAO matchStatsDAO;

    public MatchStatsController(Connection connection) {
        this.matchStatsDAO = new MatchStatsDAO(connection);
    }

    // Retourne la liste des meilleurs killers
    public List<Map<String, Object>> getTopKillers() {
        try {
            return matchStatsDAO.getTopKillers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Retourne les stats d'une équipe
    public List<Map<String, Object>> getTeamStats(int teamId) {
        try {
            return matchStatsDAO.getTeamStats(teamId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Retourne l'ID de l'équipe avec le plus de First Kills
    public int getTopFirstKillTeam() {
        try {
            return matchStatsDAO.getTopFirstKillTeam();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
