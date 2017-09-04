package com.example.a1.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button alphaBt;
    private Button scaleBt;
    private Button translateBt;
    private Button rotateBt;

    private ImageView imageView;
    private Animation loadAimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alphaBt = (Button) findViewById(R.id.bt1);
        scaleBt = (Button) findViewById(R.id.bt2);
        translateBt = (Button) findViewById(R.id.bt3);
        rotateBt = (Button) findViewById(R.id.bt4);
        imageView = (ImageView) findViewById(R.id.img1);

//        alphaBt.setOnClickListener(this);
//        scaleBt.setOnClickListener(this);
//        rotateBt.setOnClickListener(this);
//        translateBt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            //透明
            case R.id.bt1:
                loadAimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                imageView.startAnimation(loadAimation);

                break;

//缩放
            case R.id.bt2:
                loadAimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                imageView.setAnimation(loadAimation);

                break;

//旋转
            case R.id.bt3:
                loadAimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                imageView.setAnimation(loadAimation);

                break;

//移动
            case R.id.bt4:
                loadAimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                imageView.setAnimation(loadAimation);

                break;

            default:
                break;


        }

    }
}

