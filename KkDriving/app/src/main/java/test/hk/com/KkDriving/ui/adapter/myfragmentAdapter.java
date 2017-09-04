package test.hk.com.KkDriving.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class myfragmentAdapter extends FragmentPagerAdapter{
	private List<Fragment> data = new ArrayList<>();

	public myfragmentAdapter(FragmentManager fm, List<Fragment> data) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.data = data;
	}


	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	

}


