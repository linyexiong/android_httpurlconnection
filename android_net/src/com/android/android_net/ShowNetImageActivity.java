package com.android.android_net;



import com.android.service.ImageService;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ShowNetImageActivity extends Activity {

	private EditText imagePath_et;//����EditText���󣬼�ͼƬ·�������
	private Button show_netimage;//����Button����
	private ImageView imageView;//����ImageView����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		/* ��ȡ���ֹ������ĸ����ؼ� */
		imagePath_et=(EditText)findViewById(R.id.imagePath_et);
		show_netimage=(Button)findViewById(R.id.show_netimage);
		imageView=(ImageView)findViewById(R.id.imageView);
		
		//Ϊ��ť�������¼�������
		show_netimage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String imagePath=imagePath_et.getText().toString();//��ȡͼƬ·��
				//�½�һ���߳�
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							byte[] data=ImageService.getImage(imagePath);//����ImageService���getImage()�����������ֽ�����
							final Bitmap bitmap=BitmapFactory.decodeByteArray(data, 0, data.length);//����һ��Bitmap����
							imageView.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									imageView.setImageBitmap(bitmap);//������ʾ��ͼƬ
								}
							});
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}).start();//�����߳�
			}
		});
	}
	
}
