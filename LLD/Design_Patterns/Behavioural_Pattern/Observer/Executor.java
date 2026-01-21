package Behavioural_Pattern.Observer;

public class Executor {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel("makeYouDreamTrue");
        channel.subscribe(new EmailSubscriber("Aravind"));
        channel.subscribe(new MobileApp("Sarala"));

        System.out.println();
        channel.uploadVideo("Its Hard Work");

    }
}
