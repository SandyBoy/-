package com.example.baidubizhi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.example.baidubizhi.MyBottomLayout.ICallbackLister;
import com.example.fragement.HomeFragement;
import com.example.fragement.LocationFragement;
import com.example.fragement.SearchFragement;
import com.example.fragement.SettingFragement;
import com.example.fragement.selectFragement;

public class MainActivity extends FragmentActivity {
	MyBottomLayout mybottom;
	ViewPager viewpage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mybottom = (MyBottomLayout) findViewById(R.id.mybottomlayou);
		mybottom.setonCallbackListener(new ItemCallback());
		viewpage = (ViewPager) findViewById(R.id.myViewPage);
		viewpage.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
		viewpage.setOnPageChangeListener(new listener());

	}

	private class listener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			mybottom.initpic(arg0);
		}

	}

	private class ItemCallback implements ICallbackLister {

		@Override
		public void click(int id) {
			// TODO Auto-generated method stub
			switch (id) {
			case R.id.homelayout:
				viewpage.setCurrentItem(0);
				break;
			case R.id.locationlayout:
				viewpage.setCurrentItem(1);
				break;
			case R.id.searchlayout:
				viewpage.setCurrentItem(2);
				break;
			case R.id.selectlayout:
				viewpage.setCurrentItem(3);
				break;
			case R.id.setting:
				viewpage.setCurrentItem(4);
				break;
			default:
				break;
			}
		}

	}

	private class MyFragmentAdapter extends FragmentPagerAdapter {

		public MyFragmentAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			switch (arg0) {
			case 0:
				return new HomeFragement();
			case 1:
				return new LocationFragement();
			case 2:
				return new SearchFragement();
			case 3:
				return new selectFragement();
			case 4:
				return new SettingFragement();
			}
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
		}
	}
}
