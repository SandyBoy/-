package com.example.fragement;

import java.util.ArrayList;

import com.example.baidubizhi.R;
import com.example.baidubizhi.adScroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragement extends Fragment {
	adScroll ads;
	ViewPager myviewpage;
	ArrayList<View> bitmap = new ArrayList<View>();

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.homepage, container, false);
		findView(view);
		return view;
	}

	private void findView(View view) {
		// TODO Auto-generated method stub
		ads = (adScroll) view.findViewById(R.id.myaddscroll);
		myviewpage = ads.getviewpage();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		init();
		myviewpage.setAdapter(new MyAdapter());
		ads.setPageFromImage(3000);
	}

	private void init() {
		// TODO Auto-generated method stub
		LayoutInflater inf = getActivity().getLayoutInflater();
		View view = inf.inflate(R.layout.adscroolitem, null);
		view.findViewById(R.id.adImg).setBackgroundResource(
				R.drawable.image_tabbar_button_find_down);
		bitmap.add(view);
		LayoutInflater inf1 = getActivity().getLayoutInflater();
		View view1 = inf1.inflate(R.layout.adscroolitem, null);
		view1.findViewById(R.id.adImg).setBackgroundResource(
				R.drawable.image_tabbar_button_find_down);
		bitmap.add(view1);
		LayoutInflater inf2 = getActivity().getLayoutInflater();
		View view2 = inf2.inflate(R.layout.adscroolitem, null);
		view2.findViewById(R.id.adImg).setBackgroundResource(
				R.drawable.image_tabbar_button_find_down);
		bitmap.add(view2);
		LayoutInflater inf3 = getActivity().getLayoutInflater();
		View view3 = inf3.inflate(R.layout.adscroolitem, null);
		view3.findViewById(R.id.adImg).setBackgroundResource(
				R.drawable.image_tabbar_button_find_down);
		bitmap.add(view3);
	}
	/**
	 * 
	 * @author Sandy
	 *
	 */
	private class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return bitmap.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager)container).addView(bitmap.get(position));
			return bitmap.get(position);
		}
		
		
	}
}
