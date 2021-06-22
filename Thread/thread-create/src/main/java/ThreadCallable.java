import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class ThreadCallable implements Callable<Boolean> {

    String url;
    String file;

    public ThreadCallable(String url, String file) {
        this.url = url;
        this.file = file;
    }


    public static void main(String[] args) {
        ThreadCallable thread1 = new ThreadCallable("https://img-blog.csdnimg.cn/20210505110101933.jpg","1.jpg");
        ThreadCallable thread2 = new ThreadCallable("https://img-blog.csdnimg.cn/20210505122924307.png","2.png");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Boolean> r1 = executorService.submit(thread1);
        Future<Boolean> r2 = executorService.submit(thread2);

        try {
            Boolean rs1 = r1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(r1);
        try {
            Boolean rs2 = r2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(r2);

        executorService.shutdown();

    }

    @Override
    public Boolean call() throws Exception {
        WebDownloaderCallbale webDownloaderCallbale = new WebDownloaderCallbale();
        webDownloaderCallbale.downloader(url,file);
        return true;
    }
}

class WebDownloaderCallbale{

    public void downloader(String url, String file){
        try {
            FileUtils.copyURLToFile(new URL(url) ,new File(file));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io错误！");
        }
    }

}
