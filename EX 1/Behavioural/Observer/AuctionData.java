import java.util.ArrayList;
import java.util.List;

public class AuctionData implements Subject {
    private final List<Observer> observers;
    private String item;
    private double highestBid;
    private String highestBidder;

    public AuctionData(String item) {
        this.item = item;
        this.observers = new ArrayList<>();
        this.highestBid = 0.0;
        this.highestBidder = "None";
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(item, highestBid, highestBidder);
        }
    }

    public void placeBid(String bidder, double amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = bidder;
            System.out.println("New highest bid placed by " + bidder + ": $" + amount);
            notifyObservers();
        } else {
            System.out.println("Bid too low! Current highest is $" + highestBid);
        }
    }
}
