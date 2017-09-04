package test.hk.com.imagelodervolley;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.net.URL;
import java.util.List;
import java.util.zip.Inflater;

import test.hk.com.imagelodervolley.been.NewData;

import static android.R.attr.data;
import static android.R.attr.targetActivity;
import static android.content.ContentValues.TAG;
import static test.hk.com.imagelodervolley.MainActivity.flag;

/**
 * Created by 1 on 2017/4/19.
 */

public class Myadapte extends BaseAdapter {
    private LayoutInflater minflater;
    private List<NewData> dataList;
    private ImageLoader imageLoader;
    private DisplayImageOptions displayImageOptions;

    public Myadapte(Context context, List<NewData> dataList, ImageLoader imageLoader,
                    DisplayImageOptions displayImageOptions) {
        this.imageLoader = imageLoader;
        this.displayImageOptions = displayImageOptions;
        this.dataList = dataList;
        minflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v = null;
        NewData m = dataList.get(position);
        if (convertView == null) {
            v = new ViewHolder();
            convertView = minflater.inflate(R.layout.lsitview_item, parent, false);
            v.textView = (TextView) convertView.findViewById(R.id.id_tv);
            v.imageView = (ImageView) convertView.findViewById(R.id.id_iv);
            convertView.setTag(v);

        } else {
            v = (ViewHolder) convertView.getTag();
        }


        v.textView.setText(dataList.get(position).conten);
        String url = dataList.get(position).iconurl;
        imageLoader.displayImage(url, v.imageView, displayImageOptions);


        return convertView;
    }

    class ViewHolder {
        TextView textView, titleView;
        ImageView imageView;

    }


}


