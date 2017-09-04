package test.hk.com.imagelodervolley;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import test.hk.com.imagelodervolley.been.NewData;
import test.hk.com.imagelodervolley.http.Requstes;

import static android.Manifest.permission.INTERNET;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private static String URL = "http://www.imooc.com/api/teacher?type=4&num=30";
    private List<NewData> listdata;
    private ImageLoader imageLoader;
    private DisplayImageOptions displayImageOptions;
    public static boolean flag;

    public Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            listdata = new ArrayList<NewData>();
            listdata = (List<NewData>) msg.obj;
            listView.setAdapter(new Myadapte(MainActivity.this, listdata, imageLoader, displayImageOptions));

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Requstes requstes = new Requstes();
        requstes.getJson(URL, this, mHandler);
        initView();
        DisplayImageOptions();
        internet();






    }

    public void internet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {

        } else {
            Toast.makeText(this,"断网了……",Toast.LENGTH_LONG).show();
        }
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
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
        //滑动到哪显示到哪

        listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));


    }

    private void initView() {
        listView = (ListView) findViewById(R.id.id_list_item);
    }
}
