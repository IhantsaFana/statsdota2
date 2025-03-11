package controller;

import dao.MatchDAO;
import model.Match;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MatchController {
    private MatchDAO matchDAO;

    public MatchController(Connection connection) {
        this.matchDAO = new MatchDAO(connection);
    }

    // 🔥 Ajouter un nouveau match
    public void addMatch(Match match) {
        try {
            matchDAO.addMatch(match);
            System.out.println("✅ Match ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de l'ajout du match.");
        }
    }

    // 🔥 Récupérer tous les matchs
    public void displayAllMatches() {
        try {
            List<Match> matches = matchDAO.getAllMatches();
            if (matches.isEmpty()) {
                System.out.println("⚠️ Aucun match trouvé.");
                return;
            }

            System.out.println("\n📅 Liste des matchs :");
            for (Match match : matches) {
                System.out.println("Match ID: " + match.getId() + " | Équipe A: " + //match.getTeamA() +
                        " vs Équipe B: " + // match.getTeamB() + 
                		" | Date: " + match.getDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Erreur lors de la récupération des matchs.");
        }
    }
}
