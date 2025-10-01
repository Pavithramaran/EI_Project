public class Main {
    public static void main(String[] args) {
        AuctionData auction = new AuctionData("Antique Vase");

        // Observers
        Bidder b1 = new Bidder("Alice", auction);
        Bidder b2 = new Bidder("Bob", auction);
       

        // Place bids
        auction.placeBid("Alice", 100);
        auction.placeBid("Bob", 150);
        auction.placeBid("Alice", 140);  // rejected, lower
        auction.placeBid("Charlie", 200);
    }
}
