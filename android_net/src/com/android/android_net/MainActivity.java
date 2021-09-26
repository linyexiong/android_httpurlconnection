package com.android.android_net;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button net_image,net_code;//声明Button对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* 获取布局管理器中的两个Button控件 */
		net_image=(Button)findViewById(R.id.net_image);
		net_code=(Button)findViewById(R.id.net_code);
		
		/* 分别添加按钮点击监听事件 */
		net_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,ShowNetImageActivity.class);//实例化Intent对象
				startActivity(intent);//开启此Activity，跳转到ShowNetImageActivity类
			}
		});
		
		net_code.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,ShowNetCodeActivity.class);//实例化Intent对象
				startActivity(intent);//开启此Activity，跳转到ShowNetCodeActivity类
			}
		});
	}
}
