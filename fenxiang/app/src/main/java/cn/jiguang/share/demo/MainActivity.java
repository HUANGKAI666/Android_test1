package cn.jiguang.share.demo;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import static cn.jiguang.share.demo.PopWindow.progressDialog;


public class MainActivity extends Activity {
    private PopWindow popWindow;
    public static Activity mactivity;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);
        Button bt = (Button) findViewById(R.id.button1);
        mactivity = this;
        popWindow = new PopWindow(this);
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setBackgroundBlack(layout, 0);
                popWindow.showAsDropDown(v);

            }
        });


    }


    /**
     * 控制背景变暗 0变暗 1变亮
     */
    public void setBackgroundBlack(View view, int what) {
        switch (what) {
            case 0:
                view.setVisibility(View.VISIBLE);
                break;
            case 1:
                view.setVisibility(View.GONE);
                break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(popWindow.progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
