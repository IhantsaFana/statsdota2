package dao;
import model.Team;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTeam(Team team) throws SQLException {
        String query = "INSERT INTO teams (name) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, team.getName());
        stmt.executeUpdate();
    }

    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM teams";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            teams.add(new Team(rs.getInt("id"), rs.getString("name")));
        }
        return teams;
    }
}
