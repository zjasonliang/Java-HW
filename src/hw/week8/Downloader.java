package hw.week8;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.Date;

class DownloadThread extends Thread {
    private String url;
    private String file;

    public DownloadThread(String url) {
        this.url = url;
        this.file = url.replace("https://www.", "")
                .replace("http://www.", "")
                .replace(".cn.", "")
                .replace(".com.", "")
                .concat(".htm");
    }

    @Override
    public void run() {
        System.out.println(url);
        System.out.println(file);
        try {
            download(new URL(url), file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    private void download(URL url, String file)
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
    public static void main(String[] args) {
        final String[] urls = {
                "http://www.pku.edu.cn",
                "https://www.baidu.com",
                "https://www.sina.com.cn",
                "http://www.dstang.com"
        };

        long start = new Date().getTime();

        DownloadThread [] threads = new DownloadThread[4];

        for (int i = 0; i < urls.length; i++) {
            threads[i] = new DownloadThread(urls[i]);
            threads[i].start();
        }


        // Wait for all threads to die.
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = new Date().getTime();

        System.out.println("Time elapsed: " + (double)(end - start) / 1000 + " second(s)");
    }
}
