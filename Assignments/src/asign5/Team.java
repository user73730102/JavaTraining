package asign5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Team containing a name and a list of players.
 */
public class Team {
    private final String name;
    private final List<Player> players;

    public Team(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        this.players.add(player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPlayers in team '").append(name).append("':\n");
        sb.append("----------------------------------------\n");
        for (Player player : players) {
            sb.append("- ").append(player).append("\n");
        }
        sb.append("----------------------------------------");
        return sb.toString();
    }
}
