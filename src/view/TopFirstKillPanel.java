package view;

import controller.MatchStatsController;
import javax.swing.*;
import java.awt.*;

public class TopFirstKillPanel extends JPanel {
    public TopFirstKillPanel(MatchStatsController statsController) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("🔥 Team with Most First Kills");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        int bestTeamId = statsController.getTopFirstKillTeam();
        JLabel resultLabel = new JLabel(bestTeamId != -1
            ? "🥇 Team ID: " + bestTeamId
            : "❌ No First Kill data available.");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel, BorderLayout.CENTER);
    }
}
