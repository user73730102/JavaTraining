package asign7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BiddingServiceJdbcImpl implements BiddingService {

    public BiddingServiceJdbcImpl() {
        createTablesIfNotExist();
    }

    private void createTablesIfNotExist() {
        String teamTableSql = "CREATE TABLE IF NOT EXISTS team (" +
                "key_name VARCHAR(10) PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "city VARCHAR(50))";
                
        String playerTableSql = "CREATE TABLE IF NOT EXISTS player (" +
                "jersey_no INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "role VARCHAR(30), " +
                "bidding_amount DOUBLE, " +
                "team_key VARCHAR(10), " +
                "FOREIGN KEY (team_key) REFERENCES team(key_name))";

        try (Connection conn = JdbcFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(teamTableSql);
            stmt.execute(playerTableSql);
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    @Override
    public void registerTeam(Team team) {
        if (team == null) {
            throw new RegisterTeamException("Team cannot be null");
        }
        String sql = "INSERT INTO team (key_name, name, city) VALUES (?, ?, ?)";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, team.getKey());
            stmt.setString(2, team.getName());
            stmt.setString(3, team.getCity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // If already exists, we ignore or log. We use SQLState 23000 for duplicate entry
            if (e.getSQLState().startsWith("23")) {
                // Ignore if it already exists to allow the file to be loaded without exceptions.
            } else {
                throw new RegisterTeamException("Error registering team: " + e.getMessage());
            }
        }
    }

    @Override
    public void addPlayerToTeam(Team team, Player player) {
        if (team == null || player == null) {
            throw new AddPlayerToTeamException("Team and Player cannot be null");
        }
        String sql = "INSERT INTO player (jersey_no, name, role, bidding_amount, team_key) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, player.getJerseyNo());
            stmt.setString(2, player.getName());
            stmt.setString(3, player.getRole());
            stmt.setDouble(4, player.getBiddingAmount());
            stmt.setString(5, team.getKey());
            stmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getSQLState().startsWith("23")) {
                // Ignore if already exists
            } else {
                throw new AddPlayerToTeamException("Error adding player: " + e.getMessage());
            }
        }
    }

    @Override
    public Team findTeamByKey(String teamKey) {
        String sql = "SELECT * FROM team WHERE key_name = ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, teamKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Team(rs.getString("key_name"), rs.getString("name"), rs.getString("city"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new TeamNotFoundException("Team not found! Please check the key and try again.");
    }

    @Override
    public List<Player> getPlayersByTeam(Team team) {
        List<Player> players = new ArrayList<>();
        if (team == null) return players;
        String sql = "SELECT * FROM player WHERE team_key = ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, team.getKey());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    players.add(new Player(rs.getInt("jersey_no"), rs.getString("name"),
                            rs.getString("role"), rs.getDouble("bidding_amount")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<String> getRegisteredTeamKeys() {
        List<String> keys = new ArrayList<>();
        String sql = "SELECT key_name FROM team";
        try (Connection conn = JdbcFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                keys.add(rs.getString("key_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keys;
    }

    @Override
    public Player findPlayerByName(String playerName) {
        String sql = "SELECT * FROM player WHERE name = ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, playerName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(rs.getInt("jersey_no"), rs.getString("name"),
                            rs.getString("role"), rs.getDouble("bidding_amount"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Player> findPlayersByBiddingAmountLessThan(double amount) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM player WHERE bidding_amount < ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    players.add(new Player(rs.getInt("jersey_no"), rs.getString("name"),
                            rs.getString("role"), rs.getDouble("bidding_amount")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<Player> findPlayersByBiddingAmountBetween(double minAmount, double maxAmount) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM player WHERE bidding_amount BETWEEN ? AND ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, minAmount);
            stmt.setDouble(2, maxAmount);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    players.add(new Player(rs.getInt("jersey_no"), rs.getString("name"),
                            rs.getString("role"), rs.getDouble("bidding_amount")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<Player> findPlayersByRoleInTeam(Team team, String role) {
        List<Player> players = new ArrayList<>();
        if (team == null) return players;
        String sql = "SELECT * FROM player WHERE team_key = ? AND role = ?";
        try (Connection conn = JdbcFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, team.getKey());
            stmt.setString(2, role);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    players.add(new Player(rs.getInt("jersey_no"), rs.getString("name"),
                            rs.getString("role"), rs.getDouble("bidding_amount")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }
}
