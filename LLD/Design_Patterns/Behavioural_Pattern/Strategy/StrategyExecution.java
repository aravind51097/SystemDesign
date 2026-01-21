package Behavioural_Pattern.Strategy;

public class StrategyExecution {
    public static void main(String[] args) {

        double revenue = 12.00;
        RidematchingService ride = new RidematchingService(new NearestMatchStategy());
        ride.matchRide("banglore marathalli");

        // Chamging behaviur at runTime
        if (revenue < 20) {
            System.out.println("Less revenue strategy change appiled ");
            ride.setNewStartegy(new SurgePriorityStrategy());
        }

        ride.matchRide("Kadubisanahalli");
    }
}
