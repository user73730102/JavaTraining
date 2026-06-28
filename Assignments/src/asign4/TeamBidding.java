package asign4;

import java.util.Optional;
import java.util.Scanner;

/**
 * Entry point for the Team Bidding application.
 */
public class TeamBidding {
    public static void main(String[] args) {
        // Programming to an interface: BiddingService
        BiddingService biddingService = new BiddingServiceImpl();
        initializeData(biddingService);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Welcome to the Team Bidding Search System ---");
            System.out.println("Available teams: " + String.join(", ", biddingService.getRegisteredTeamNames()));

            while (true) {
                System.out.print("\nEnter team name to search (or type 'exit' to quit): ");
                String teamQuery = scanner.nextLine().trim();

                if (teamQuery.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting search system. Goodbye!");
                    break;
                }

                Optional<Team> matchedTeam = biddingService.findTeamByName(teamQuery);
                if (matchedTeam.isPresent()) {
                    System.out.println(matchedTeam.get());
                } else {
                    System.out.println("Team not found! Please check the spelling and try again.");
                }
            }
        }
    }

    private static void initializeData(BiddingService biddingService) {
        // Mumbai Indians
        Team mi = new Team("Mumbai Indians");
        mi.addPlayer(new Player("Rohit Sharma", 16.0));
        mi.addPlayer(new Player("Jasprit Bumrah", 12.0));
        mi.addPlayer(new Player("Suryakumar Yadav", 8.0));
        biddingService.registerTeam(mi);

        // Chennai Super Kings
        Team csk = new Team("Chennai Super Kings");
        csk.addPlayer(new Player("MS Dhoni", 12.0));
        csk.addPlayer(new Player("Ravindra Jadeja", 16.0));
        csk.addPlayer(new Player("Ruturaj Gaikwad", 6.0));
        biddingService.registerTeam(csk);

        // Royal Challengers Bangalore
        Team rcb = new Team("Royal Challengers Bangalore");
        rcb.addPlayer(new Player("Virat Kohli", 15.0));
        rcb.addPlayer(new Player("Glenn Maxwell", 11.0));
        rcb.addPlayer(new Player("Faf du Plessis", 7.0));
        biddingService.registerTeam(rcb);
    }
}
