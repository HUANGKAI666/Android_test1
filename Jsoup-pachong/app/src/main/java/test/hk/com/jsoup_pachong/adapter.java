package test.hk.com.jsoup_pachong;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by 1 on 2017/7/21.
 */

public class adapter extends ArrayAdapter<Data>{
    private List<Data> datas;
    private Context context;
    private int resource;
    DisplayImageOptions displayImageOptions;
    private ImageLoader imageLoader;


    public adapter( Context context, int resource,List<Data> datas,
                    DisplayImageOptions displayImageOptions,ImageLoader imageLoader) {
        super(context,resource,datas);
        this.datas = datas;
        this.context = context;
        this.resource = resource;
        this.imageLoader = imageLoader;
        this.displayImageOptions = displayImageOptions;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewholder  v = new viewholder();
//        View view;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            v.name = (TextView) convertView.findViewById(R.id.textView);
            v.text = (TextView) convertView.findViewById(R.id.textView2);
            v.img = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(v);
        }else {
//            view = convertView;
            v = (viewholder) convertView.getTag();
        }
        v.name.setText(datas.get(position).getName());
        v.text.setText(datas.get(position).getText());
        imageLoader.displayImage("http:"+datas.get(position).getImg(), v.img, displayImageOptions);
        Log.d("img","http://"+datas.get(position).getImg());
        return convertView;
    }
     class viewholder{
        TextView name,text;
         ImageView img;


    }
}
