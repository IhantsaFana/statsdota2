package view;

import controller.MatchStatsController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;

public class TopKillersPanel extends JPanel {
    public TopKillersPanel(MatchStatsController statsController) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("🏆 Top Killers in Matches");
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);

        String[] columnNames = {"Player ID", "Total Kills"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table));

        // Remplir le tableau avec les données
        List<Map<String, Object>> topKillers = statsController.getTopKillers();
        for (Map<String, Object> killer : topKillers) {
            tableModel.addRow(new Object[]{killer.get("player_id"), killer.get("total_kills")});
        }
    }
}
