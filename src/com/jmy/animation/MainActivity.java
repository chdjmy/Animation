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
 * Demo��ʾ֡���������䶯�������Զ���
 * ֡�����Ͳ��䶯���Ƽ���xmlʵ��
 * ���Զ����Ƽ��ô���ʵ�֣���Ϊ��Щ��ʼ����ֵ��Ҫ�ڴ����в���֪��
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
	
	//��̬���������ʼ��
	//static final private int MENU_ITEM = Menu.FIRST;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//�Ƽ�ʹ��xml�����ֲ˵�������Ӳ������
		getMenuInflater().inflate(R.menu.select, menu);
		return super.onCreateOptionsMenu(menu);
		
		//�ô�����Ӳ˵�
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
