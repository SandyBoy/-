package com.example.baidubizhi;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class adScroll extends LinearLayout {
	ViewPager myViewpage;
	ImageView imageview1, imageview2, imageview3, imageview4;
	Timer timer;
	TimerTask task;
	int index = 0;

	public adScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		LayoutInflater inflate = LayoutInflater.from(getContext());
		View view = inflate.inflate(R.layout.adscrool, this);
		myViewpage = (ViewPager) view.findViewById(R.id.myViewPage);
		imageview1 = (ImageView) view.findViewById(R.id.imgone);
		imageview2 = (ImageView) view.findViewById(R.id.imgtwo);
		imageview3 = (ImageView) view.findViewById(R.id.imgthree);
		imageview4 = (ImageView) view.findViewById(R.id.imgfour);
		
		
	}
private class MypageChangList implements OnPageChangeListener{

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
		index=arg0;
		hanle();
	}
	
	
}
	
	public void setPageFromImage(int delayTime) {
		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
			hanle();
				
				index++;
				if (index==4) {
					index=0;
				}
			}

		
		
		};
		timer.schedule(task, delayTime, delayTime);
	}
	Handler handler=new Handler(){
	public void handleMessage(android.os.Message msg) {
		switch (msg.what) {
		case 100:
			msg.getData().getInt("index");
			initpic(index);
			break;

		default:
			break;
		}
		
	};	
		
	};
	
	private void hanle() {
		// TODO Auto-generated method stub
		Bundle bundle=new Bundle();
		bundle.putInt("index", index);
		Message msg=new Message();
		msg.setData(bundle);
		msg.what=100;
		handler.sendMessage(msg);
	}
	private void initpic(int index1) {
		// TODO Auto-generated method stub
		myViewpage.setCurrentItem(index1);
		switch (index1) {
		case 0:
			imageview1.setBackgroundResource(R.drawable.point_selected);
			imageview2.setBackgroundResource(R.drawable.point_normal);
			imageview3.setBackgroundResource(R.drawable.point_normal);
			imageview4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 1:
			
			imageview1.setBackgroundResource(R.drawable.point_normal);
			imageview2.setBackgroundResource(R.drawable.point_selected);
			imageview3.setBackgroundResource(R.drawable.point_normal);
			imageview4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 2:
			
			imageview2.setBackgroundResource(R.drawable.point_normal);
			imageview1.setBackgroundResource(R.drawable.point_normal);
			imageview3.setBackgroundResource(R.drawable.point_selected);
			imageview4.setBackgroundResource(R.drawable.point_normal);
			break;
		case 3:
			
			imageview2.setBackgroundResource(R.drawable.point_normal);
			imageview3.setBackgroundResource(R.drawable.point_normal);
			imageview1.setBackgroundResource(R.drawable.point_normal);
			imageview4.setBackgroundResource(R.drawable.point_selected);
			break;
		default:
			break;
		}
	}
	public ViewPager getviewpage(){
		
		return myViewpage;
	}
}
