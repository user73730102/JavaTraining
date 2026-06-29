package asign5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (Team t : this.teams.keySet()) {
            if (t.getKey().equalsIgnoreCase(team.getKey())) {
                throw new RegisterTeamException("Team with key '" + team.getKey() + "' is already registered");
            }
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
        for (Team t : teams.keySet()) {
            if (t.getKey().equalsIgnoreCase(teamKey)) {
                return t;
            }
        }
        throw new TeamNotFoundException("Team not found! Please check the key and try again.");
    }

    @Override
    public List<Player> getPlayersByTeam(Team team) {
        return teams.get(team);
    }

    @Override
    public List<String> getRegisteredTeamKeys() {
        List<String> keys = new ArrayList<>();
        for (Team team : teams.keySet()) {
            keys.add(team.getKey());
        }
        return keys;
    }
}
