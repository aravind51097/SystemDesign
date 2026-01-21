package Behavioural_Pattern.Strategy;

/* Service that deal directly with interface not with concrete class 
    makes strategy possible
*/
public class RidematchingService {
    private IMatchingStrategy strategy;

    public RidematchingService(IMatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setNewStartegy(IMatchingStrategy strategy) {
        System.out.println("Stategy changed to " + strategy.getClass().toString());
        this.strategy = strategy;

    }

    public void matchRide(String location) {
        System.out.println("start Matching Ride ");
        strategy.macth(location);
    }
}
