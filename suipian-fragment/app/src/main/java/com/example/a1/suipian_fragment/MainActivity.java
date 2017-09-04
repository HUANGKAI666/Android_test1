package com.example.a1.suipian_fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
public  Display display;
  public   static   Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Display display = getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            setContentView(R.layout.activity_main2);
        } else {
            setContentView(R.layout.activity_main);
        }
        activity = this;
//        Button bt = (Button) findViewById(R.id.id_bt1);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //动态添加碎片fragment
////             1. 创建待添加的碎片实例。
////             2. 获取到 FragmentManager，在活动中可以直接调用 getFragmentManager()方法得到。
////             3. 开启一个事务，通过调用 beginTransaction()方法开启。
////             4. 向容器内加入碎片，一般使用 replace()方法实现，需要传入容器的 id 和待添加的碎
////              片实例。
////             5. ᨀ交事务，调用 commit()方法来完成。
////                Fragment f2 = new f2();
////                FragmentManager fm = getFragmentManager();
////                FragmentTransaction fragmentTransaction = fm.beginTransaction();
////                fragmentTransaction.replace(R.id.fl,f2);
////                fragmentTransaction.addToBackStack(null);//使他按返回建不会退出程序 而是返回
////                fragmentTransaction.commit();
//
//
//
//
//
//
//
//
//
//
//            }
//        });
//
//    }


    }
}
