package asign5;

/**
 * Represents a Player in the bidding system.
 */
public class Player {
    private final String name;
    private final double biddingAmount; // In Millions

    public Player(String name, double biddingAmount) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        if (biddingAmount < 0) {
            throw new IllegalArgumentException("Bidding amount cannot be negative.");
        }
        this.name = name;
        this.biddingAmount = biddingAmount;
    }

    public String getName() {
        return name;
    }

    public double getBiddingAmount() {
        return biddingAmount;
    }

    @Override
    public String toString() {
        return String.format("%-20s : $%.2f Million", name, biddingAmount);
    }
}
