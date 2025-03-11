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

    public void displayTopKillers() {
        try {
            List<Map<String, Object>> topKillers = matchStatsDAO.getTopKillers();
            System.out.println("\n🔥 Top Killer(s) in Matches:");
            for (Map<String, Object> killer : topKillers) {
                System.out.println("Player ID: " + killer.get("player_id") + " | Total Kills: " + killer.get("total_kills"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error retrieving top killers.");
        }
    }

    public void displayTeamStats(int teamId) {
        try {
            List<Map<String, Object>> teamStats = matchStatsDAO.getTeamStats(teamId);
            System.out.println("\n📊 Team Statistics (Team ID: " + teamId + "):");
            System.out.printf("%-15s %-10s %-10s %-10s%n", "Player", "Kills", "Deaths", "Assists");
            for (Map<String, Object> player : teamStats) {
                System.out.printf("%-15s %-10d %-10d %-10d%n",
                        player.get("name"), player.get("kills"), player.get("deaths"), player.get("assists"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error retrieving team stats.");
        }
    }
    
    public void displayBeStats(int teamId) {
    	try {
    		List<Map<String, Object>> BeStats = matchStatsDAO.getTeamStats(teamId);
    	} catch (SQLException e) {
    		e.printStackTrace();
    		System.out.print("Erreur");
    	}
    }

    public void displayTopFirstKillTeam() {
        try {
            int bestTeamId = matchStatsDAO.getTopFirstKillTeam();
            if (bestTeamId != -1) {
                System.out.println("\n🏆 Team with Most First Kills: Team ID " + bestTeamId);
            } else {
                System.out.println("\n❌ No First Kill data available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Error retrieving top First Kill team.");
        }
    }
}
