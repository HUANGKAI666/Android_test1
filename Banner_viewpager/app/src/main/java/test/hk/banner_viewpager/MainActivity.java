package test.hk.banner_viewpager;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    // 声明控件
    private ViewPager mViewPager;
    private List<ImageView> mlist;
    private TextView mTextView;
    private LinearLayout mLinearLayout;


    // 广告图素材
    private int[] bannerImages = {R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,
            R.mipmap.image1,R.mipmap.image2,R.mipmap.image3};
    // 广告语
    private String[] bannerTexts = { "轮播图1", "轮播图2", "轮播图3",
            "轮播图4", "轮播图5", "轮播图6"
    };

    // ViewPager适配器与监听器
    private BannerAdapter mAdapter;

    private BannerListener bannerListener;

    // 圆圈标志位
    private int pointIndex = 0;
    // 线程标志
    private boolean isStop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAction();

        // 开启新线程，2秒一次更新Banner
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isStop) {
                    SystemClock.sleep(2000);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {


                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);

                        }
                    });
                }
            }
        }).start();
    }
    /**
     * 初始化事件
     */
    private void initAction() {
        bannerListener = new BannerListener();
        mViewPager.setOnPageChangeListener(bannerListener);
        //取中间数来作为起始位置
        int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % mlist.size());
        //用来触发监听器
        mViewPager.setCurrentItem(index);
        mLinearLayout.getChildAt(pointIndex).setEnabled(true);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mlist = new ArrayList<ImageView>();
        View view;
        LinearLayout.LayoutParams params;
        for (int i = 0; i < bannerImages.length; i++) {
            // 设置广告图
            //动态创建一个imageview
            ImageView imageView = new ImageView(MainActivity.this);
            //设置imageview大小
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            imageView.setBackgroundResource(bannerImages[i]);
            mlist.add(imageView);
            // 设置圆圈点
            //动态创建一个view
            view = new View(MainActivity.this);
            params = new LinearLayout.LayoutParams(5, 5);
            params.leftMargin = 10;
            view.setBackgroundResource(R.drawable.select);
            view.setLayoutParams(params);
            view.setEnabled(false);
            mLinearLayout.addView(view);
        }
        mAdapter = new BannerAdapter(mlist);
        mViewPager.setAdapter(mAdapter);
    }

    /**
     * 初始化View操作
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextView = (TextView) findViewById(R.id.tv_bannertext);
        mLinearLayout = (LinearLayout) findViewById(R.id.points);
    }

    //实现VierPager监听器接口
    class BannerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            int newPosition = position % bannerImages.length;
//            Toast.makeText(MainActivity.this,newPosition,Toast.LENGTH_SHORT).show();
            mTextView.setText(bannerTexts[newPosition]);
            mLinearLayout.getChildAt(newPosition).setEnabled(true);
            mLinearLayout.getChildAt(pointIndex).setEnabled(false);
            // 更新标志位
            pointIndex = newPosition;
        }

    }

    @Override
    protected void onDestroy() {
        // 关闭定时器
        isStop = true;
        super.onDestroy();
    }



    }

