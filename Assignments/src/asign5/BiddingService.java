package asign5;

import java.util.List;

public interface BiddingService {
    void registerTeam(Team team);
    void addPlayerToTeam(Team team, Player player);
    Team findTeamByKey(String teamKey);
    List<Player> getPlayersByTeam(Team team);
    List<String> getRegisteredTeamKeys();
}
