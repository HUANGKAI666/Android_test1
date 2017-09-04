package com.example.a1.suipian_fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by 1 on 2017/5/10.
 */

public class NewsContentActivity extends Activity {

    public static void actionStart(Context context, String newsTitle,
                                   String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.f2);
        String newsTitle = getIntent().getStringExtra("news_title");
// 获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("news_content");
// 获取传入的新闻内容
        f2 newsContentFragment = (f2)
                getFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent);
// 刷新NewsContentFragment界面
    }
}
