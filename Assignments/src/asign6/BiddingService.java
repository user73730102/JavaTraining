package asign6;

import java.util.List;

public interface BiddingService {
    void registerTeam(Team team);
    void addPlayerToTeam(Team team, Player player);
    Team findTeamByKey(String teamKey);
    List<Player> getPlayersByTeam(Team team);
    List<String> getRegisteredTeamKeys();
    
    // Additional functionalities
    Player findPlayerByName(String playerName);
    List<Player> findPlayersByBiddingAmountLessThan(double amount);
    List<Player> findPlayersByBiddingAmountBetween(double minAmount, double maxAmount);
    List<Player> findPlayersByRoleInTeam(Team team, String role);
}
