package view;

import controller.MatchStatsController;
import model.DatabaseConnection;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Établir la connexion à la base de données
        Connection connection = DatabaseConnection.connect();

        // Initialiser le contrôleur des statistiques
        MatchStatsController statsController = new MatchStatsController(connection);

        // Menu de sélection
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Dota2 Match Statistics =====\n(Eo amin'ilay 3 mbola misy tsy mety");
            System.out.println("1. Show Top Killers");
            System.out.println("2. Show Team Statistics");
            System.out.println("3. Show Team with Most First Kills");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    statsController.displayTopKillers();
                    break;
                case 2:
                    System.out.print("Enter Team ID: ");
                    int teamId = scanner.nextInt();
                    statsController.displayTeamStats(teamId);
                    break;
                case 3:
                    statsController.displayTopFirstKillTeam();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}