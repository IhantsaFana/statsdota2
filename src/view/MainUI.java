package view;

import javax.swing.*;
import java.awt.*;
import controller.MatchStatsController;
import model.DatabaseConnection;
import java.sql.Connection;

public class MainUI extends JFrame {
    private JPanel contentPanel;
    private MatchStatsController statsController;

    public MainUI() {
        // Connexion DB
        Connection connection = DatabaseConnection.connect();
        statsController = new MatchStatsController(connection);

        // Configuration fenêtre
        setTitle("Dota2 Match Statistics");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Barre de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem topKillers = new JMenuItem("Show Top Killers");
        JMenuItem teamStats = new JMenuItem("Show Team Statistics");
        JMenuItem topFirstKills = new JMenuItem("Show Team with Most First Kills");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(topKillers);
        menu.add(teamStats);
        menu.add(topFirstKills);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel principal
        contentPanel = new JPanel(new BorderLayout());
        add(contentPanel);

        // Gestion événements
        topKillers.addActionListener(e -> setPanel(new TopKillersPanel(statsController)));
        teamStats.addActionListener(e -> {
            String teamId = JOptionPane.showInputDialog("Enter Team ID:");
            if (teamId != null) setPanel(new TeamStatsPanel(statsController, Integer.parseInt(teamId)));
        });
        topFirstKills.addActionListener(e -> setPanel(new TopFirstKillPanel(statsController)));
        exit.addActionListener(e -> System.exit(0));
    }

    private void setPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainUI().setVisible(true));
    }
}
