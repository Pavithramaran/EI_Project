public class Bidder implements Observer {
    private String name;

    public Bidder(String name, Subject auctionData) {
        this.name = name;
        auctionData.registerObserver(this);
    }

    @Override
    public void update(String item, double bidAmount, String bidder) {
        System.out.println("[" + name + "] notified: Item " + item + 
                           " new highest bid $" + bidAmount + 
                           " by " + bidder);
    }
}
