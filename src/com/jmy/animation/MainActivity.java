package com.jmy.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (ImageView)findViewById(R.id.animationImageView);
	}
	
	//静态常量必须初始化
	//static final private int MENU_ITEM = Menu.FIRST;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//推荐使用xml来布局菜单，方便硬件适配
		getMenuInflater().inflate(R.menu.select, menu);
		return super.onCreateOptionsMenu(menu);
		
		//用代码添加菜单
//		super.onCreateOptionsMenu(menu);
//		int groupId = 0;
//		int menuItemId = 0;
//		int menuItemOrder = Menu.NONE;
//		int menuItemText = R.string.menu_select;
//		MenuItem menuItem = menu.add(groupId,menuItemId,menuItemOrder,menuItemText);
//		menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.menu_item1:
			frameAnimation();
			break;
		case R.id.menu_item2:
			twwenAnimation();
			break;
		case R.id.menu_item3:
			Toast.makeText(this, "OptonItem3", Toast.LENGTH_SHORT).show();
			break;
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void frameAnimation(){
		view.setBackgroundResource(R.drawable.frame_animation);
		AnimationDrawable drawable = (AnimationDrawable)view.getBackground();
		drawable.start();
	}
	
	public  void twwenAnimation(){
		view.setBackgroundResource(R.drawable.frame_animation);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.tween_animation);
		view.startAnimation(anim);
	}
	
	
	
	
	
	
	
	
}
