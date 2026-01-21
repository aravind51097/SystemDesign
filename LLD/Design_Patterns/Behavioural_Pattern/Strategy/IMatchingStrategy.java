package Behavioural_Pattern.Strategy;

//Strategy Inteface 
public interface IMatchingStrategy {
    void macth(String location);

}
/* List of statergies that are implemented  */
class NearestMatchStategy implements IMatchingStrategy {

    @Override
    public void macth(String location) {
        System.out.println("Matching ride based on Nearest Strategy for ::" + location);
    }

}

class SurgePriorityStrategy implements IMatchingStrategy {

    @Override
    public void macth(String location) {
        System.out.println("Matching ride based on SurgePriorityStrategy for ::" + location);
    }

}

class AirPostStrategy implements IMatchingStrategy {

    @Override
    public void macth(String location) {
        System.out.println("Matching ride based on AirPostStrategy for ::" + location);
    }

}
