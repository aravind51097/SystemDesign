package Structural_Pattern.Proxy;

import java.util.HashMap;
import java.util.Map;

public class CachedProxyVideoDownloader implements IVideoDownloader {
    private RealVideoDownloader realVideoDownloader;
    private Map<String, String> cachedVideos = new HashMap<>();

    public CachedProxyVideoDownloader() {
        this.realVideoDownloader = new RealVideoDownloader();
    }

    @Override
    public String downloadVideo(String videoUrl) {
        if (cachedVideos.containsKey(videoUrl)) {
            System.out.println("returning video from chached response + " + videoUrl);
            return cachedVideos.get(videoUrl);
        }
        System.out.println("video not in cache , downloading.... ");

        String video = realVideoDownloader.downloadVideo(videoUrl);
        cachedVideos.put(videoUrl, video);
        return video;
    }

}
