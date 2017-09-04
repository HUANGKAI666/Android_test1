package test.hk.com.KkDriving.ui;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import test.hk.com.KkDriving.R;
import test.hk.com.KkDriving.been.TestData;
import test.hk.com.KkDriving.been.Url;
import test.hk.com.KkDriving.tool.SharedPreferencesUtil;

import static test.hk.com.KkDriving.been.Url.TESTTYPE;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;

    private List<TestData> listdata = new ArrayList<TestData>();;

    public static boolean flag;
    private TextView one,four,a1,a2,b1,b2,b3,c1,c2,rand,order;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        internet();
        InitSelect();
        initBt();

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


    private void initBt() {



    }
    private void InitSelect() {

        one = (TextView) findViewById(R.id.one);
        four = (TextView) findViewById(R.id.four);
        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        b1 = (TextView) findViewById(R.id.b1);
        b2 = (TextView) findViewById(R.id.b2);
        c1 = (TextView) findViewById(R.id.c1);
        c2 = (TextView) findViewById(R.id.c2);
        rand = (TextView) findViewById(R.id.rand);
        order = (TextView) findViewById(R.id.order);
        go = (Button) findViewById(R.id.go);

go.setOnClickListener(this);
        one.setOnClickListener(this);
        four.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        rand.setOnClickListener(this);
        order.setOnClickListener(this);
        one.setBackgroundResource(R.drawable.yuanjiao);
        four.setBackgroundResource(R.drawable.yuanjiao);
        a1.setBackgroundResource(R.drawable.yuanjiao);
        a2.setBackgroundResource(R.drawable.yuanjiao);
        b1.setBackgroundResource(R.drawable.yuanjiao);
        b2.setBackgroundResource(R.drawable.yuanjiao);
        c1.setBackgroundResource(R.drawable.yuanjiao);
        c2.setBackgroundResource(R.drawable.yuanjiao);
        order.setBackgroundResource(R.drawable.yuanjiao);
        rand.setBackgroundResource(R.drawable.yuanjiao);
        if (one.isClickable()){
            go.setEnabled(true);
        }
        else {
            go.setEnabled(false);
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case  R.id.one:
               one.setBackgroundResource(R.drawable.yuanjiao_choice);
                four.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setInt(this,Url.SUBJECT,1);

                break;
            case  R.id.four:
                four.setBackgroundResource(R.drawable.yuanjiao_choice);
                one.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setInt(this,Url.SUBJECT,4);
                break;
            case  R.id.a1:
                a1.setBackgroundResource(R.drawable.yuanjiao_choice);
                a2.setBackgroundResource(R.drawable.yuanjiao);
                b1.setBackgroundResource(R.drawable.yuanjiao);
                b2.setBackgroundResource(R.drawable.yuanjiao);
                c1.setBackgroundResource(R.drawable.yuanjiao);
                c2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"a1");
                break;
            case  R.id.a2:
                a2.setBackgroundResource(R.drawable.yuanjiao_choice);
                a1.setBackgroundResource(R.drawable.yuanjiao);
                b1.setBackgroundResource(R.drawable.yuanjiao);
                b2.setBackgroundResource(R.drawable.yuanjiao);
                c1.setBackgroundResource(R.drawable.yuanjiao);
                c2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"a2");

                break;
            case  R.id.b1:
                b1.setBackgroundResource(R.drawable.yuanjiao_choice);
                a1.setBackgroundResource(R.drawable.yuanjiao);
                a2.setBackgroundResource(R.drawable.yuanjiao);
                b2.setBackgroundResource(R.drawable.yuanjiao);
                c1.setBackgroundResource(R.drawable.yuanjiao);
                c2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"b1");
                break;
            case  R.id.b2:
                b2.setBackgroundResource(R.drawable.yuanjiao_choice);
                a1.setBackgroundResource(R.drawable.yuanjiao);
                a2.setBackgroundResource(R.drawable.yuanjiao);
                b1.setBackgroundResource(R.drawable.yuanjiao);
                c1.setBackgroundResource(R.drawable.yuanjiao);
                c2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"b2");
                break;
            case  R.id.c1:
                c1.setBackgroundResource(R.drawable.yuanjiao_choice);
                a1.setBackgroundResource(R.drawable.yuanjiao);
                a2.setBackgroundResource(R.drawable.yuanjiao);
                b2.setBackgroundResource(R.drawable.yuanjiao);
                b1.setBackgroundResource(R.drawable.yuanjiao);
                c2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"c1");
                break;
            case  R.id.c2:
                c2.setBackgroundResource(R.drawable.yuanjiao_choice);
                a1.setBackgroundResource(R.drawable.yuanjiao);
                a2.setBackgroundResource(R.drawable.yuanjiao);
                b1.setBackgroundResource(R.drawable.yuanjiao);
                c1.setBackgroundResource(R.drawable.yuanjiao);
                b2.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this,Url.MODEL,"c2");
                break;
            case  R.id.rand:
                rand.setBackgroundResource(R.drawable.yuanjiao_choice);
                order.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this, TESTTYPE,"rand");
                break;
            case  R.id.order:
                order.setBackgroundResource(R.drawable.yuanjiao_choice);
                rand.setBackgroundResource(R.drawable.yuanjiao);
                SharedPreferencesUtil.setString(this, TESTTYPE,"order");
                break;
            case  R.id.go:


              startActivity( new Intent(this,Main2Activity.class));
                break;


        }

    }
}
