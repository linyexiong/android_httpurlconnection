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

	private EditText imagePath_et;//声明EditText对象，即图片路径输入框
	private Button show_netimage;//声明Button对象
	private ImageView imageView;//声明ImageView对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		/* 获取布局管理器的各个控件 */
		imagePath_et=(EditText)findViewById(R.id.imagePath_et);
		show_netimage=(Button)findViewById(R.id.show_netimage);
		imageView=(ImageView)findViewById(R.id.imageView);
		
		//为按钮点击添加事件监听器
		show_netimage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String imagePath=imagePath_et.getText().toString();//获取图片路径
				//新建一个线程
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							byte[] data=ImageService.getImage(imagePath);//调用ImageService类的getImage()方法，返回字节数组
							final Bitmap bitmap=BitmapFactory.decodeByteArray(data, 0, data.length);//创建一个Bitmap对象
							imageView.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									imageView.setImageBitmap(bitmap);//设置显示的图片
								}
							});
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}).start();//开启线程
			}
		});
	}
	
}
