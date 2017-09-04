package test.hk.banner_viewpager;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        final MyView myView = (MyView) findViewById(R.id.mybutton);
        myView.setmyOnClickListener(new MyView.myOnClickListener() {
            @Override
            public void myClick() {
                Toast.makeText(MyViewActivity.this,"自定义view",Toast.LENGTH_SHORT).show();
                ObjectAnimator.ofFloat(myView,"rotation",0,
                        360).start();//启始值  最后值
                startActivity( new Intent(MyViewActivity.this,MainActivity.class));
            }
        });
      



    }
}
