package test.hk.com.KkDriving.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.LocaleDisplayNames;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.hk.com.KkDriving.R;

import test.hk.com.KkDriving.been.TestData;
import test.hk.com.KkDriving.been.Url;

import test.hk.com.KkDriving.db.DbHelper;
import test.hk.com.KkDriving.http.Requstes;
import test.hk.com.KkDriving.tool.ImageLoaderApplication;
import test.hk.com.KkDriving.ui.adapter.myfragmentAdapter;
import test.hk.com.KkDriving.ui.fragment.MyFragment;

import static test.hk.com.KkDriving.ui.fragment.MyFragment.mScrollview;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    public static ViewPager mViewPager;
    private Toolbar mToolbar;
    public static TextView mcount2_tv,mcount1_tv,mRight_tv,mMistake_tv;
    public static List<TestData> mlistdata = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private myfragmentAdapter mAdapter;
    private ImageLoaderApplication application = (ImageLoaderApplication) getApplication();
    Url mUrl;
    String imgurl, itme1, itme2, itme3, itme4, question, explains;
    int id;
    MyFragment fragment;
    private int answer;
    private TextView mBeiTi,mLianTi;
    private ImageView mBack;
    private SQLiteDatabase dbread;

//    private  MyListener mListenter;
//    public interface MyListener
//    {
//        void setFlag(int index);
//    }
//    public void setFlaglistenter(MyListener listtenter){
//        this.mListenter = listtenter;
//    }




    public Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mlistdata = (List<TestData>) msg.obj;
            setfragment(mlistdata);
        }
    };


    private void setfragment(List<TestData> listdata) {
        for (int i = 0; i < listdata.size(); i++) {

            question = mlistdata.get(i).getQuestion();
            imgurl = mlistdata.get(i).getImgurl();
            itme1 = mlistdata.get(i).getItem1();
            itme2 = mlistdata.get(i).getItem2();
            itme3 = mlistdata.get(i).getItem3();
            itme4 = mlistdata.get(i).getItem4();
            answer = mlistdata.get(i).getAnswer();
            explains = mlistdata.get(i).getExplains();
            fragment = new MyFragment(this, question, imgurl, itme1, itme2, itme3, itme4, answer, explains,i,mAdapter);
            mFragments.add(fragment);
        }

        mAdapter = new myfragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mcount2_tv.setText(mFragments.size()+"");
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mcount1_tv.setText(position+1+"");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//       mViewPager.setOffscreenPageLimit(listdata.size());


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DbHelper dbHelper = new DbHelper(this);
        dbHelper.getWritableDatabase().delete("right_table",null,null);
        dbHelper.getWritableDatabase().delete("mistake_table",null,null);

        mUrl = new Url(this);
        Requstes requstes = new Requstes();
        requstes.getJson(mUrl.url, this, mHandler);
        initView();




    }




    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mcount2_tv = (TextView) findViewById(R.id.id_count2_tv);
        mcount1_tv = (TextView) findViewById(R.id.id_count1_tv);

        mBack = (ImageView) findViewById(R.id.id_back);
        mBeiTi = (TextView) findViewById(R.id.id_BT);
        mLianTi = (TextView) findViewById(R.id.id_LT);
        mRight_tv = (TextView) findViewById(R.id.id_right_tv);
        mMistake_tv = (TextView) findViewById(R.id.id_wrong_tv);
        mBack.setOnClickListener(this);
        mBeiTi.setOnClickListener(this);
        mLianTi.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch ( v.getId()){
            case R.id.id_back:

                break;
            case R.id.id_LT:
                MyFragment.flag=false;
                break;
            case R.id.id_BT:
                MyFragment.flag=true;
                Log.d("xxx","点击");
                break;

        }

    }



}
