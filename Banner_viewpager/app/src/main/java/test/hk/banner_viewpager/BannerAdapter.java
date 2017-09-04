package test.hk.banner_viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 1 on 2017/6/13.
 */

class BannerAdapter extends PagerAdapter{

    private List<ImageView> mList;

    public BannerAdapter(List<ImageView> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
        //取超大的数，实现无线循环效果
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view  == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //这个方法用来实例化页卡
        container.addView(mList.get(position%mList.size()));
        return mList.get(position%mList.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //这个方法用来删除页卡
        container.removeView(mList.get(position%mList.size()));
    }


}
