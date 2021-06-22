import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreaadDownloader extends Thread {

    String url;
    String file;

    public ThreaadDownloader(String url, String file) {
        this.url = url;
        this.file = file;
    }

    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,file);
    }

    public static void main(String[] args) {
        ThreaadDownloader thread1 = new ThreaadDownloader("https://img-blog.csdnimg.cn/20210505110101933.jpg","1.jpg");
        ThreaadDownloader threaadDownloader = new ThreaadDownloader("https://img-blog.csdnimg.cn/20210505122924307.png","2.png");
        thread1.start();
        threaadDownloader.start();
    }

}

class WebDownloader{

    public void downloader(String url, String file){
        try {
            FileUtils.copyURLToFile(new URL(url) ,new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io错误！");
        }
    }

}
