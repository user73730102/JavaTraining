package asign4;

import java.util.List;
import java.util.Optional;

/**
 * Interface defining operations for managing and searching teams and their players.
 */
public interface BiddingService {
    /**
     * Registers a new team into the bidding system.
     * 
     * @param team the team to register
     */
    void registerTeam(Team team);

    /**
     * Searches for a team by its name (case-insensitive).
     * 
     * @param teamName the name of the team to find
     * @return an Optional containing the Team if found, or empty otherwise
     */
    Optional<Team> findTeamByName(String teamName);

    /**
     * Retrieves all registered team names.
     * 
     * @return an unmodifiable list of team names
     */
    List<String> getRegisteredTeamNames();
}
