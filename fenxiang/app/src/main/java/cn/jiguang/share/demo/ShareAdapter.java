package cn.jiguang.share.demo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;





public class ShareAdapter extends BaseAdapter{
	private List<cn.jiguang.share.demo.Share> fruitList;
	private LayoutInflater inflater;
	public ShareAdapter(Context context, List<cn.jiguang.share.demo.Share> fruitList){
		this.fruitList = fruitList;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fruitList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return fruitList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		cn.jiguang.share.demo.Share f = fruitList.get(position);
		ViewHolder vh = null;
		if (convertView == null) {
			vh =new ViewHolder();
			convertView = inflater.inflate(R.layout.fruit_item, parent,false);
		vh.im = (ImageView) convertView.findViewById(R.id.fruit_image);
		vh.tx = (TextView) convertView.findViewById(R.id.fruit_name);
		convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		vh.im.setImageResource(f.getImageId());
		vh.tx.setText(f.getName());
		
		return convertView;
	}
	private final class ViewHolder {
		
		TextView tx;
		ImageView im;
		
	}
	
	
	
}