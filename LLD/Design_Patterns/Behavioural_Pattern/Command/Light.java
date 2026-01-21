package Behavioural_Pattern.Command;


//receiver who will gonna receive the commands
public class Light {

    public void on() {
        System.out.println("Ligth Turned on ...");
    }

    public void off() {
        System.out.println("Light Turned off ...");
    }

}
