import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadRunnable implements Runnable {

    String url;
    String file;

    public ThreadRunnable(String url, String file) {
        this.url = url;
        this.file = file;
    }

    public void run(){
        WebDownloaderRunnable webDownloader = new WebDownloaderRunnable();
        webDownloader.downloader(url,file);
    }

    public static void main(String[] args) {
        ThreaadDownloader thread1 = new ThreaadDownloader("https://img-blog.csdnimg.cn/20210505110101933.jpg","1.jpg");
        ThreaadDownloader threaadDownloader = new ThreaadDownloader("https://img-blog.csdnimg.cn/20210505122924307.png","2.png");
        new Thread(thread1).start();
        new Thread(threaadDownloader).start();
    }

}

class WebDownloaderRunnable{

    public void downloader(String url, String file){
        try {
            FileUtils.copyURLToFile(new URL(url) ,new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io错误！");
        }
    }

}
