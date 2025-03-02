package view;

import controller.PlayerController;
import controller.TeamController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerController playerController = new PlayerController();
        TeamController teamController = new TeamController();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter une équipe");
            System.out.println("2. Ajouter un joueur");
            System.out.println("3. Voir toutes les équipes");
            System.out.println("4. Voir tous les joueurs");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'équipe : ");
                    String teamName = scanner.nextLine();
                    teamController.addTeam(teamName);
                    break;
                case 2:
                    System.out.print("Nom du joueur : ");
                    String playerName = scanner.nextLine();
                    System.out.print("ID de l'équipe : ");
                    int teamId = scanner.nextInt();
                    playerController.addPlayer(playerName, teamId);
                    break;
                case 3:
                    teamController.getAllTeams().forEach(t -> System.out.println(t.getName()));
                    break;
                case 4:
                    playerController.getAllPlayers().forEach(p -> System.out.println(p.getName()));
                    break;
                case 5:
                    System.out.println("Bye !");
                    return;
            }
        }
    }
}
