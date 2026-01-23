package Structural_Pattern.Proxy;

public class ExecuteProxy {
    public static void main(String[] args) {

        IVideoDownloader downloader = new CachedProxyVideoDownloader();

        String video = downloader.downloadVideo("youtube.com/makeYou_DREAM_True");

        System.out.println(video);

        String video2 = downloader.downloadVideo("youtube.com/makeYou_DREAM_True");
        System.out.println(video2);

    }

}
