package hw.week9;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class DownloadThread extends Thread {
    private String url;
    private File file;

    DownloadThread(String url, File downloadPath) {
        this.url = url;
        this.file = new File(downloadPath, this.produceFileName());
    }

    private String produceFileName() {
        return this.url.replace(".", "")
                .replace("/", "")
                .replace("www", "")
                .replace("https", "")
                .replace("http", "")
                .replace(":", "")
                .concat(".html");
    }

    @Override
    public void run() {
        System.out.println(url);
        System.out.println("Saved to file: " + file + '\n');

        try {
            download(new URL(url), file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void download(URL url, File file)
            throws IOException {
        try (InputStream input = url.openStream();
             OutputStream output = new FileOutputStream(file)) {
            byte[] data = new byte[1024];
            int length;
            while ((length = input.read(data)) != -1) {
                output.write(data, 0, length);
            }
        }
    }
}

public class Downloader {

    private ExecutorService pool = Executors.newCachedThreadPool();
    private File downloadPath;

    public Downloader() {
        this("data/");
    }

    public Downloader(String downloadPath) {
        this.downloadPath = new File(downloadPath);
        if (!this.downloadPath.exists())
            this.downloadPath.mkdir();
    }

    public void addTask(String url) {
        pool.submit(new DownloadThread(url, this.downloadPath));
    }


    public static void main(String[] args) {
        Downloader downloader = new Downloader();
        downloader.addTask("http://www.baidu.com");
    }
}
