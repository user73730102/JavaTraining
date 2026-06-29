package asign5;

public class Player {
    private int jerseyNo;
    private String name;
    private String role;
    private double biddingAmount; 

    public Player(int jerseyNo, String name, String role, double biddingAmount) {
        if (biddingAmount < 0) {
            throw new IllegalArgumentException("Bidding amount cannot be negative");
        }
        this.jerseyNo = jerseyNo;
        this.name = name;
        this.role = role;
        this.biddingAmount = biddingAmount;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getBiddingAmount() {
        return biddingAmount;
    }

    @Override
    public String toString() {
        return "#" + jerseyNo + " " + name + " (" + role + ") : $" + biddingAmount + " Million";
    }
}
