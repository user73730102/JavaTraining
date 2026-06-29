package asign5;

import java.util.List;
import java.util.Scanner;

public class TestBidding {
    public static void main(String[] args) {
        BiddingService biddingService = new BiddingServiceImpl();
        initializeData(biddingService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to the Team Bidding Search System ---");
        System.out.println("Available teams: " + String.join(", ", biddingService.getRegisteredTeamKeys()));

        while (true) {
            System.out.print("\nEnter team key to search (e.g., csk, rcb, mi) or 'exit' to quit: ");
            String teamQuery = scanner.nextLine();

            if (teamQuery.equalsIgnoreCase("exit")) {
                System.out.println("Exiting search system. Goodbye!");
                break;
            }

            try {
                Team matchedTeam = biddingService.findTeamByKey(teamQuery);
                System.out.println("\nPlayers in " + matchedTeam + ":");
                List<Player> players = biddingService.getPlayersByTeam(matchedTeam);
                for (Player player : players) {
                    System.out.println("- " + player);
                }
            } catch (TeamNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void initializeData(BiddingService biddingService) {
        Team mi = new Team("mi", "Mumbai Indians", "Mumbai");
        biddingService.registerTeam(mi);
        biddingService.addPlayerToTeam(mi, new Player(45, "Rohit Sharma", "Batter", 16.0));
        biddingService.addPlayerToTeam(mi, new Player(93, "Jasprit Bumrah", "Bowler", 12.0));
        biddingService.addPlayerToTeam(mi, new Player(63, "Suryakumar Yadav", "Batter", 8.0));

        Team csk = new Team("csk", "Chennai Super Kings", "Chennai");
        biddingService.registerTeam(csk);
        biddingService.addPlayerToTeam(csk, new Player(7, "MS Dhoni", "Wicketkeeper Batter", 12.0));
        biddingService.addPlayerToTeam(csk, new Player(8, "Ravindra Jadeja", "All-rounder", 16.0));
        biddingService.addPlayerToTeam(csk, new Player(31, "Ruturaj Gaikwad", "Batter", 6.0));

        Team rcb = new Team("rcb", "Royal Challengers Bangalore", "Bangalore");
        biddingService.registerTeam(rcb);
        biddingService.addPlayerToTeam(rcb, new Player(18, "Virat Kohli", "Batter", 15.0));
        biddingService.addPlayerToTeam(rcb, new Player(32, "Glenn Maxwell", "All-rounder", 11.0));
        biddingService.addPlayerToTeam(rcb, new Player(13, "Faf du Plessis", "Batter", 7.0));
    }
}
