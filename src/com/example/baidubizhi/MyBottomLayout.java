package com.example.baidubizhi;

import com.example.fragement.HomeFragement;
import com.example.fragement.LocationFragement;
import com.example.fragement.SearchFragement;
import com.example.fragement.SettingFragement;
import com.example.fragement.selectFragement;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyBottomLayout extends LinearLayout {
	RelativeLayout home;
	RelativeLayout select;
	RelativeLayout search;
	RelativeLayout location;
	RelativeLayout setting;
	LayoutInflater inflater;
	
	public MyBottomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initView();
		initdata();
	}

	private void initdata() {
		// TODO Auto-generated method stub
		home.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
		TextView text=(TextView)home.findViewById(R.id.tabtest);
		text.setTextColor(Color.BLUE);
		text.setText("主页");
		select.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_find_down);
		TextView text1=(TextView)select.findViewById(R.id.tabtest);
		text1.setTextColor(Color.BLUE);
		text1.setText("选择");
		search.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_manage_down);
		TextView text2=(TextView)search.findViewById(R.id.tabtest);
		text2.setTextColor(Color.BLUE);
		text2.setText("查找");
		location.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_search_down);
		TextView text3=(TextView)location.findViewById(R.id.tabtest);
		text3.setTextColor(Color.BLUE);
		text3.setText("当地");
		setting.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
		TextView text4=(TextView)setting.findViewById(R.id.tabtest);
		text4.setTextColor(Color.BLUE);
		text4.setText("设置");
	}

	private void initView() {
		// TODO Auto-generated method stub
		inflater = LayoutInflater.from(getContext());
		View view = inflater.inflate(R.layout.layout_bottom, this);
		findview(view);
		
	}

	private void setOnClick() {
		// TODO Auto-generated method stub
		home.setOnClickListener(new lister());
		select.setOnClickListener(new lister());
		search.setOnClickListener(new lister());
		location.setOnClickListener(new lister());
		setting.setOnClickListener(new lister());
	}

	interface ICallbackLister{
		public void click(int id);
		
	}
	ICallbackLister callbackLister=null;
	public void setonCallbackListener(ICallbackLister itcallback){
		this.callbackLister=itcallback;
		
	}
	
	
	private class lister implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.homelayout:
				initpic(0);
				Toast.makeText(getContext(), "ddd", 0).show();
				break;
			case R.id.selectlayout:
				initpic(1);
				
				break;
			case R.id.searchlayout:
				initpic(2);
				
				break;
			case R.id.locationlayout:
				initpic(3);
				
				break;
			case R.id.setting:
				initpic(4);
				
				break;
			default:
				break;
			}
			callbackLister.click(v.getId());
		}

	

	}

	public void initpic(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case 0:
			
			home.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_find);
			TextView text=(TextView)home.findViewById(R.id.tabtest);
			text.setTextColor(Color.BLUE);
			text.setText("主页");
			break;
		case 1:
			
			select.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_more);
			TextView text1=(TextView)select.findViewById(R.id.tabtest);
			text1.setTextColor(Color.BLUE);
			text1.setText("选择");
			break;
		case 2:
			search.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_find);
			TextView text2=(TextView)search.findViewById(R.id.tabtest);
			text2.setTextColor(Color.BLUE);
			text2.setText("查找");
			break;
		case 3:
			location.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_search);
			TextView text3=(TextView)location.findViewById(R.id.tabtest);
			text3.setTextColor(Color.BLUE);
			text3.setText("当地");
			break;
		case 4:
			setting.findViewById(R.id.tabImag).setBackgroundResource(R.drawable.image_tabbar_button_find);
			TextView text4=(TextView)setting.findViewById(R.id.tabtest);
			text4.setTextColor(Color.BLUE);
			text4.setText("设置");
			break;
		default:
			break;
		}
	}
	private void findview(View view) {
		// TODO Auto-generated method stub
		home = (RelativeLayout) view.findViewById(R.id.homelayout);
		select = (RelativeLayout) view.findViewById(R.id.selectlayout);
		search = (RelativeLayout) view.findViewById(R.id.searchlayout);
		location = (RelativeLayout) view.findViewById(R.id.locationlayout);
		setting = (RelativeLayout) view.findViewById(R.id.setting);
		home.setOnClickListener(new lister());
		select.setOnClickListener(new lister());
		search.setOnClickListener(new lister());
		location.setOnClickListener(new lister());
		setting.setOnClickListener(new lister());
		//setOnClick();
	}

}
