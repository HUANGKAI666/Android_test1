package test.hk.com.jsoup_pachong;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import static android.R.id.list;


public class MainActivity extends AppCompatActivity {
    private  adapter a;
    private Runnable runnable;
    private ListView listview;
    private List<Data> datas = new ArrayList<>();
    private ImageLoader imageLoader;
    private DisplayImageOptions displayImageOptions;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            datas = (List<Data>) msg.obj;
//            a.setNotifyOnChange(true);
            listview.setAdapter(a);
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager systemService = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = systemService.getActiveNetworkInfo();
        if (info != null) {
            Thread();

        }else {
                Toast.makeText(MainActivity.this,"断网了。。。。。",Toast.LENGTH_LONG).show();
        }
        listview = (ListView) findViewById(R.id.id_listview);
        DisplayImageOptions();
        a = new adapter(this,R.layout.itme,datas,displayImageOptions,imageLoader);
        listview.setAdapter(a);




    }
    //使用imageloader的功能设置图片
    private void DisplayImageOptions() {
        imageLoader = ImageLoader.getInstance();
        displayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher_round)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(20))//圆弧
                .build();
        //滑动到哪显示到哪

        listview.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));


    }

    private void Thread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 修改http包中的header,伪装成浏览器进行抓取
//                conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0");Document doc = conn.get
                try {
                    Document doc = Jsoup.connect("http://www.qiushibaike.com/")
                            .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/20100101" +
                                    " Firefox/32.0").get();
//                    Elements els = doc.getElementsByClass("contentHerf");
//                    Elements els = doc.select("a[class=contentHerf]");
                    Elements els = doc.select(".article");
                    Log.d("kk1", els.toString());

//                    for (int i = 0; i<els.size(); i++){
//                        els.get(i).text();
//                        Log.d("kk3", els.get(i).text());
//                    }


                    for (Element element : els) {
                        String text = element.select(".content").text();
                        String image = element.select("img").attr("src");
//                        String name = element.select("img[src$=.JPEG]").attr("alt");
                        String name= element.select("h2").text();
                        Data data = new Data();
                        data.setImg(image);
                        data.setName(name);
                        data.setText(text);
                        datas.add(data);
                        Message message = handler.obtainMessage();
                        message.obj = datas;
                        handler.sendMessage(message);
                        Log.d("kk1", " " + datas.size());
                        Log.d("kk1", image);
                        Log.d("kk1", name);
                        Log.d("kk1", text);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }
}
