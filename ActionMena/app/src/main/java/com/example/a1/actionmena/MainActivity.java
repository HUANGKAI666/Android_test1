package com.example.a1.actionmena;


import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {
    private LinearLayout itme1;
    private LinearLayout itme2;
    private LinearLayout itme3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //查看网络是否连接
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        if (activeNetworkInfo!=null){
//            Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(MainActivity.this,"no",Toast.LENGTH_SHORT).show();
//        }
        itme1 = (LinearLayout) findViewById(R.id.itme1);
        itme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hhh",Toast.LENGTH_SHORT).show();

            }
        });


    }
}