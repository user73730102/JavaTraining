package asign5;

import java.util.List;
import java.util.Optional;

public interface BiddingService {
    void registerTeam(Team team);

    Optional<Team> findTeamByName(String teamName);

    List<String> getRegisteredTeamNames();
}
