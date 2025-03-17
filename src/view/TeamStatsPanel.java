package view;

import controller.MatchStatsController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;

public class TeamStatsPanel extends JPanel {
    public TeamStatsPanel(MatchStatsController statsController, int teamId) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("📊 Team Statistics (Team ID: " + teamId + ")");
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        String[] columnNames = {"Player", "Kills", "Deaths", "Assists"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table));

        // Remplir le tableau avec les données
        List<Map<String, Object>> teamStats = statsController.getTeamStats(teamId);
        for (Map<String, Object> player : teamStats) {
            tableModel.addRow(new Object[]{
                player.get("name"), player.get("kills"), player.get("deaths"), player.get("assists")
            });
        }
    }
}
