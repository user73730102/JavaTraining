package asign6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiddingServiceImpl implements BiddingService {
    private Map<Team, List<Player>> teams;

    public BiddingServiceImpl() {
        this.teams = new HashMap<>();
    }

    @Override
    public void registerTeam(Team team) {
        if (team == null) {
            throw new RegisterTeamException("Team cannot be null");
        }
        if (this.teams.keySet().stream().anyMatch(t -> t.getKey().equalsIgnoreCase(team.getKey()))) {
            throw new RegisterTeamException("Team with key '" + team.getKey() + "' is already registered");
        }
        this.teams.put(team, new ArrayList<>());
    }

    @Override
    public void addPlayerToTeam(Team team, Player player) {
        if (team == null || player == null) {
            throw new AddPlayerToTeamException("Team and Player cannot be null");
        }
        List<Player> players = this.teams.get(team);
        if (players == null) {
            throw new AddPlayerToTeamException("Team '" + team.getKey() + "' is not registered yet");
        }
        players.add(player);
    }

    @Override
    public Team findTeamByKey(String teamKey) {
        return teams.keySet().stream()
                .filter(t -> t.getKey().equalsIgnoreCase(teamKey))
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException("Team not found! Please check the key and try again."));
    }

    @Override
    public List<Player> getPlayersByTeam(Team team) {
        return teams.get(team);
    }

    @Override
    public List<String> getRegisteredTeamKeys() {
        return teams.keySet().stream()
                .map(Team::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Player findPlayerByName(String playerName) {
        return teams.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getName().equalsIgnoreCase(playerName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Player> findPlayersByBiddingAmountLessThan(double amount) {
        return teams.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getBiddingAmount() < amount)
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findPlayersByBiddingAmountBetween(double minAmount, double maxAmount) {
        return teams.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getBiddingAmount() >= minAmount && p.getBiddingAmount() <= maxAmount)
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> findPlayersByRoleInTeam(Team team, String role) {
        List<Player> teamPlayers = teams.get(team);
        if (teamPlayers == null) {
            return new ArrayList<>();
        }
        return teamPlayers.stream()
                .filter(p -> p.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }
}
