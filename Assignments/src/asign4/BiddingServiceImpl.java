package asign4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Concrete implementation of the BiddingService interface.
 */
public class BiddingServiceImpl implements BiddingService {
    private final List<Team> teams;

    public BiddingServiceImpl() {
        this.teams = new ArrayList<>();
    }

    @Override
    public void registerTeam(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null.");
        }
        this.teams.add(team);
    }

    @Override
    public Optional<Team> findTeamByName(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            return Optional.empty();
        }
        return teams.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teamName.trim()))
                .findFirst();
    }

    @Override
    public List<String> getRegisteredTeamNames() {
        List<String> names = new ArrayList<>();
        for (Team team : teams) {
            names.add(team.getName());
        }
        return Collections.unmodifiableList(names);
    }
}
