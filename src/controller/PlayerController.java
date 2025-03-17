package controller;

import model.Player;
import model.DatabaseConnection;
import dao.PlayerDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PlayerController {
    private PlayerDAO playerDAO;

    public PlayerController() {
        Connection connection = DatabaseConnection.connect();
        if (connection != null) {
            this.playerDAO = new PlayerDAO(connection);
        } else {
            throw new RuntimeException("Database connection failed");
        }
    }

    // Ajoute un joueur et retourne true si réussi
    public boolean addPlayer(String name, int teamId, int position) {
        try {
            Player player = new Player(0, name, teamId, position);
            playerDAO.addPlayer(player);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retourne la liste de tous les joueurs
    public List<Player> getAllPlayers() {
        try {
            return playerDAO.getAllPlayers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Retourne les meilleurs joueurs par stats
    public Map<String, Player> getTopStatsPlayers() {
        try {
            return playerDAO.getTopStatsPlayers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
