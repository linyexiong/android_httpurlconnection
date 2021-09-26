package com.android.android_net;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.service.CodeService;

public class ShowNetCodeActivity extends Activity {

	private EditText codePath_et;//声明EditText对象
	private Button show_netcode;//声明Button对象
	private TextView textView;//声明textView对象
	private String result="";//初始化一个空的String类型变量
	private Handler handler;//声明一个Handler对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code);
		/* 获取布局管理器中的各个控件 */
		codePath_et=(EditText)findViewById(R.id.codePath_et);
		show_netcode=(Button)findViewById(R.id.show_netcode);
		textView=(TextView)findViewById(R.id.textView);
		
		//为按钮点击添加监听事件
		show_netcode.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String codePath=codePath_et.getText().toString();//获取网络源码的路径
				//新建一个线程
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							result=CodeService.getCode(codePath);//调用CodeSErvice类的getCode方法，返回字符串数据
							Message msg=handler.obtainMessage();//通过handler对象获得Message消息
							handler.sendMessage(msg);//发送消息
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();//开启一个线程		
				
				//实例化一个Handler对象
				handler=new Handler(){

					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						if(result!=null){
							textView.setText(result);//设置文本视图显示的文本
						}
						super.handleMessage(msg);
					}
					
				};
			}
		});
	}
	
}
