package com.android.android_net;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button net_image,net_code;//����Button����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* ��ȡ���ֹ������е�����Button�ؼ� */
		net_image=(Button)findViewById(R.id.net_image);
		net_code=(Button)findViewById(R.id.net_code);
		
		/* �ֱ���Ӱ�ť��������¼� */
		net_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,ShowNetImageActivity.class);//ʵ����Intent����
				startActivity(intent);//������Activity����ת��ShowNetImageActivity��
			}
		});
		
		net_code.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,ShowNetCodeActivity.class);//ʵ����Intent����
				startActivity(intent);//������Activity����ת��ShowNetCodeActivity��
			}
		});
	}
}
