package com.jmy.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
/**
 * Demo演示帧动画、补间动画和属性动画
 * 帧动画和补间动画推荐用xml实现
 * 属性动画推荐用代码实现，因为有些起始属性值需要在代码中才能知道
 * @author Administrator
 *
 */
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
			propertyAnimation();
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
	public void propertyAnimation(){
		view.setBackgroundResource(R.drawable.frame_animation);
		AnimatorSet set = new AnimatorSet();
		set.playTogether(
				ObjectAnimator.ofFloat(view, "rotationX", 0,360),
				ObjectAnimator.ofFloat(view, "rotationY", 0,180),
				ObjectAnimator.ofFloat(view, "rotation", 0,-90),
				ObjectAnimator.ofFloat(view, "translationX", 0,90),
				ObjectAnimator.ofFloat(view, "translationY", 0,90),
				ObjectAnimator.ofFloat(view, "scaleX", 1,1.5f),
				ObjectAnimator.ofFloat(view, "scaleY", 1,0.5f),
				ObjectAnimator.ofFloat(view, "alpha", 1,0.25f)
		);
		set.start();
	}
	
	
	
	
	
	
	
	
}
