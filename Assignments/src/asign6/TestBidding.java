package asign6;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class TestBidding {
    public static void main(String[] args) {
        BiddingService biddingService = new BiddingServiceImpl();
        loadDataFromFile(biddingService, "src/asign6/bidding_data.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Welcome to the Team Bidding Search System ---");
        System.out.println("Available teams: " + String.join(", ", biddingService.getRegisteredTeamKeys()));

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Search players by team key");
            System.out.println("2. Find player by name");
            System.out.println("3. Find players with bidding amount less than...");
            System.out.println("4. Find players with bidding amount between...");
            System.out.println("5. Find players by role in a team");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("6") || choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting search system. Goodbye!");
                break;
            }

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter team key to search (e.g., csk, rcb, mi): ");
                        String teamQuery = scanner.nextLine();
                        Team matchedTeam = biddingService.findTeamByKey(teamQuery);
                        System.out.println("\nPlayers in " + matchedTeam + ":");
                        List<Player> players = biddingService.getPlayersByTeam(matchedTeam);
                        players.forEach(p -> System.out.println("- " + p));
                        break;
                    case "2":
                        System.out.print("Enter player name: ");
                        String name = scanner.nextLine();
                        Player player = biddingService.findPlayerByName(name);
                        if (player != null) {
                            System.out.println("Found: " + player);
                        } else {
                            System.out.println("Player not found.");
                        }
                        break;
                    case "3":
                        System.out.print("Enter maximum bidding amount: ");
                        double max = Double.parseDouble(scanner.nextLine());
                        List<Player> lessThanPlayers = biddingService.findPlayersByBiddingAmountLessThan(max);
                        System.out.println("Players with bidding amount < " + max + ":");
                        lessThanPlayers.forEach(p -> System.out.println("- " + p));
                        break;
                    case "4":
                        System.out.print("Enter minimum bidding amount: ");
                        double minAmt = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter maximum bidding amount: ");
                        double maxAmt = Double.parseDouble(scanner.nextLine());
                        List<Player> betweenPlayers = biddingService.findPlayersByBiddingAmountBetween(minAmt, maxAmt);
                        System.out.println("Players with bidding amount between " + minAmt + " and " + maxAmt + ":");
                        betweenPlayers.forEach(p -> System.out.println("- " + p));
                        break;
                    case "5":
                        System.out.print("Enter team key: ");
                        String tKey = scanner.nextLine();
                        Team team = biddingService.findTeamByKey(tKey);
                        System.out.print("Enter role (e.g., Batter, Bowler, All-rounder): ");
                        String role = scanner.nextLine();
                        List<Player> rolePlayers = biddingService.findPlayersByRoleInTeam(team, role);
                        System.out.println(role + "s in " + team.getName() + ":");
                        rolePlayers.forEach(p -> System.out.println("- " + p));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (TeamNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }
        }
        scanner.close();
    }

    private static void loadDataFromFile(BiddingService biddingService, String filePath) {
        try {
            Files.lines(Paths.get(filePath))
                .filter(line -> !line.trim().isEmpty() && !line.startsWith("#"))
                .forEach(line -> {
                    String[] parts = line.split(",");
                    if (parts[0].equals("TEAM")) {
                        biddingService.registerTeam(new Team(parts[1], parts[2], parts[3]));
                    } else if (parts[0].equals("PLAYER")) {
                        try {
                            Team team = biddingService.findTeamByKey(parts[1]);
                            biddingService.addPlayerToTeam(team, new Player(Integer.parseInt(parts[2]), parts[3], parts[4], Double.parseDouble(parts[5])));
                        } catch (TeamNotFoundException e) {
                            System.out.println("Error adding player: " + e.getMessage());
                        }
                    }
                });
        } catch (IOException e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }
    }
}
