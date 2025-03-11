package dao;
import model.Match;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO {
    private Connection connection;

    public MatchDAO(Connection connection) {
        this.connection = connection;
    }

    public void addMatch(Match match) throws SQLException {
        String query = "INSERT INTO matches (date_played) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setTimestamp(1, new Timestamp(match.getDate().getTime()));
        stmt.executeUpdate();
    }

    public List<Match> getAllMatches() throws SQLException {
        List<Match> matches = new ArrayList<>();
        String query = "SELECT * FROM matches";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            matches.add(new Match(rs.getInt("id"), rs.getTimestamp("date_played")));
        }
        return matches;
    }
}
