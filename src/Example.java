import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLEditorKit;

import java.nio.charset.*;

class Example {
    public static void main(String[] args)throws Exception{
        JFrame f=new JFrame("网络爬虫");

        f.setSize(500,400);
        f.setLocation(200, 200);

        f.setLayout(new FlowLayout());

        JLabel l = new JLabel("请输入一个要进行爬虫的url：");
        JTextField t=new JTextField("https://www.dstang.com");
        JButton b = new JButton();
        JTextArea ta = new JTextArea();

        b.setText("开始");
        t.setPreferredSize(new Dimension(140, 30));
        ta.setPreferredSize(new Dimension(400, 300));

        String tv = t.getText();

        f.add(l);
        f.add(t);
        f.add(b);
        f.add(ta);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        ConcurrentLinkedQueue<String> urls =
                new ConcurrentLinkedQueue<>();
        //按钮监听器
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String url1="该网页里有如下网址:\n";
                urls.add(tv);
                //  urls.add( "https://www.dstang.com" );
                int cnt=0;
                while(!urls.isEmpty()){
                    String url = urls.poll();

                    System.out.println(url);
                    url1 = url1 +url+"\n";
                    ta.setText(url1);
                    new Thread( ()-> {
                        try{
                            String content = download(
                                    new URL(url), "gb2312");
                            List<String> moreUrl = parse( content );
                            urls.addAll(moreUrl);

                            //System.out.println(moreUrl);
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }).start();

                    if(cnt++>5) break;
                    try{ Thread.sleep(4000); }catch(InterruptedException ex){}
                }
            }
        });
    }


    static List<String> parse(String text) {
        String patternString =
                "\\s*href\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))\\s*";
        Pattern pattern = Pattern.compile(patternString,
                Pattern.CASE_INSENSITIVE  );  //  Pattern.MULTILINE
        Matcher matcher = pattern.matcher( text );
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String href = matcher.group(1);
            href = href.replaceAll("\'","").replaceAll("\"","");
            if(href.startsWith("http:") )
                list.add(href);
        }
        return list;
    }

    static String download( URL url, String charset)
            throws Exception
    {
        try(InputStream input
                    = url.openStream();
            ByteArrayOutputStream output
                    = new ByteArrayOutputStream())
        {
            byte[] data = new byte[1024];
            int length;
            while((length=input.read(data))!=-1){
                output.write(data,0,length);
            }
            byte[] content = output.toByteArray();
            return new String(content, Charset.forName(charset));
        }
    }
}
