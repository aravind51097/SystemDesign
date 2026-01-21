package Behavioural_Pattern.Observer;

import java.util.ArrayList;
import java.util.List;

//Channel with some functionalities 
interface Channel {

    void subscribe(Subscriber name);

    void unsubscribe(Subscriber name);

    void notifySubscribers(String videoTitle);

    void uploadVideo(String videoTitle);
}

// YouTube channel which get Subscribers and notifies them
public class YouTubeChannel implements Channel {

    private List<Subscriber> subscribers;
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber name) {
        subscribers.add(name);

    }

    @Override
    public void unsubscribe(Subscriber name) {
        subscribers.remove(name);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (Subscriber sub : subscribers) {
            System.out.println("New video uploaded ");
            sub.update(videoTitle, sub.getName());
        }
    }

    @Override
    public void uploadVideo(String videoTitle) {
        System.out.println("Uploading a video to ... " + channelName);
        notifySubscribers(videoTitle);
    }

}
