package Structural_Pattern.Proxy;

public class RealVideoDownloader implements IVideoDownloader {

    @Override
    public String downloadVideo(String videoUrl) {
        System.out.println("Video is being download .. ");

        return "video downloaded for " + videoUrl;
    }

}
