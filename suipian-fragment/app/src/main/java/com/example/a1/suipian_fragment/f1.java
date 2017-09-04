package com.example.a1.suipian_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.a1.suipian_fragment.MainActivity.activity;

/**
 * Created by 1 on 2017/5/8.
 */

public class f1 extends Fragment implements AdapterView.OnItemClickListener {
    @Nullable
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;
    private View view;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        newsList = getNews(); // 初始化新闻数据
//        adapter = new NewsAdapter(activity, R.layout.news_itme, newsList);
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.f1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        newsList = getNews(); // 初始化新闻数据
         getNews(); // 初始化新闻数据
      adapter = new NewsAdapter(activity, R.layout.news_itme, newsList);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            isTwoPane = true; // 可以找到news_content_layout布局时，为双页模式
        } else {
            isTwoPane = false; // 找不到news_content_layout布局时，为单页模式
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        News news = newsList.get(position);
        if (isTwoPane) {
// 如果是双页模式，则刷新NewsContentFragment中的内容

            f2 newsContentFragment = (f2) getFragmentManager()
                    .findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(), news.getContent());


        } else {
// 如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(), news.getTitle(),
                    news.getContent());
        }
    }
//        private List<News> getNews() {
//        List<News> newsList = new ArrayList<News>();
//        News news1 = new News();
//        news1.setTitle("Succeed in College as a Learning Disabled Student");
//        news1.setContent("College freshmen will soon learn " +
//                "to live with a roommate, adjust to a new so" +
//                "cial scene and survive less-than-stellardining h" +
//                "all food. Students with learning disabilities will face t" +
//                "hese transitions while also grappling with a few more hurdles.");
//        newsList.add(news1);
//        News news2 = new News();
//        news2.setTitle("Google Android exec poached by China's Xiaomi");
//        news2.setContent("China's Xiaomi has poached a key Google executive involved in the tech giant's And" +
//                "roid phones, in a move seen as" +
//                " a coup for the rapidly growing Chinese smartphone maker.");
//        newsList.add(news2);
//        return newsList;
//    }

    private void getNews() {
        newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("Succeed in College as a Learning Disabled Student");
        news1.setContent("College freshmen will soon learn " +
                "to live with a roommate, adjust to a new so" +
                "cial scene and survive less-than-stellardining h" +
                "all food. Students with learning disabilities will face t" +
                "hese transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xiaomi");
        news2.setContent("China's Xiaomi has poached a key Google executive involved in the tech giant's And" +
                "roid phones, in a move seen as" +
                " a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);

    }
    }

